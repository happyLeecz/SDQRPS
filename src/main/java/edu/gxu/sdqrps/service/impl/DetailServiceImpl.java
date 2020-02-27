package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.DetailMapper;
import edu.gxu.sdqrps.dao.ProjectMapper;
import edu.gxu.sdqrps.dao.UserMapper;
import edu.gxu.sdqrps.model.entity.Project;
import edu.gxu.sdqrps.model.entity.User;
import edu.gxu.sdqrps.model.vo.DetailInfo;
import edu.gxu.sdqrps.model.vo.DetailRatio;
import edu.gxu.sdqrps.model.vo.InfoResult;
import edu.gxu.sdqrps.model.vo.SchoolStatistics;
import edu.gxu.sdqrps.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author cz
 * @date 2019/12/22 11:19 上午
 */
@Service
public class DetailServiceImpl implements DetailService {
    private DetailMapper detailMapper;
    private ProjectMapper projectMapper;
    private UserMapper userMapper;

    @Autowired
    public DetailServiceImpl(DetailMapper detailMapper, ProjectMapper projectMapper, UserMapper userMapper) {
        this.detailMapper = detailMapper;
        this.projectMapper = projectMapper;
        this.userMapper = userMapper;
    }

    @Override
    public InfoResult getAllWithUserIdAndContentId(int userId, int contentId, Integer indexId) {
        List<DetailInfo> details = detailMapper.listById(userId, contentId);
        if (indexId != null)
            details = details.stream().filter((detailInfo) -> detailInfo.getIndexId() == indexId).collect(Collectors.toList());
        if (details.isEmpty())
            return new InfoResult<String>(201, "没有信息");
        else return new InfoResult<List>(200, details);
    }

    @Override
    public InfoResult updateTargetValue(int contentId, int userId, int indexId, int qualityControlId, int newTarget) {

        if (detailMapper.updateTarget(contentId, userId, indexId, qualityControlId, newTarget) == 1)
            return new InfoResult<String>(400, "修改目标值成功");
        else
            return new InfoResult<String>(401, "修改目标值失败");
    }

    @Override
    public InfoResult updateStandardValue(int contentId, int userId, int indexId, int qualityControlId, int newStandard) {
        if (detailMapper.updateStandard(contentId, userId, indexId, qualityControlId, newStandard) == 1)
            return new InfoResult<String>(400, "修改标准值成功");
        else
            return new InfoResult<String>(401, "修改标准值失败");
    }

    @Override
    public InfoResult updatePreWarningValue(int contentId, int userId, int indexId, int qualityControlId, int newPreWarningValue) {
        if (detailMapper.updatePreWarning(contentId, userId, indexId, qualityControlId, newPreWarningValue) == 1)
            return new InfoResult<String>(400, "修改预警值成功");
        else
            return new InfoResult<String>(401, "修改预警值失败");
    }

    @Override
    public InfoResult getProjectWithQualityControlId(int qualityControlId) {
        List<Project> projectList = projectMapper.listById(qualityControlId);
        if (!projectList.isEmpty())
            return new InfoResult<List>(500, projectList);
        else
            return new InfoResult<String>(501, "找不到项目");
    }

    @Override
    public InfoResult getRatioNum(int userId, int contentId, Integer indexId) {
        List<DetailInfo> details = detailMapper.listById(userId, contentId);
        if (indexId != null)
            details = details.stream().filter(detailInfo -> detailInfo.getIndexId() == indexId).collect(Collectors.toList());

        if (!details.isEmpty()) {
            long preWarningNum = details.stream().filter(detailInfo -> detailInfo.getStandard() < detailInfo.getPreWarningValue()).count();
            return new InfoResult(600, new DetailRatio(preWarningNum, details.size() - preWarningNum));
        } else
            return new InfoResult(601, "没有数据");
    }

    @Override
    public InfoResult getStatistics(Integer userId) {
        if (userId != null) {
            SchoolStatistics schoolStatistics = getSs(userId);
            return new InfoResult<SchoolStatistics>(800, schoolStatistics);
        } else {
            List<Integer> idList = userMapper.getAllSchoolUserId();
            List<SchoolStatistics> schoolStatisticsList = new ArrayList<>();
            idList.forEach((id -> {
                schoolStatisticsList.add(getSs(id));
            }));
            return new InfoResult(900, schoolStatisticsList);
        }
    }

    public SchoolStatistics getSs(int userId) {
        List<DetailInfo> detailInfoList = detailMapper.listByUserId(userId);
        long totalNum = detailInfoList.size();
        long preWarningNum = detailInfoList.stream().filter(detailInfo -> detailInfo.getTarget() < detailInfo.getPreWarningValue()).count();
        long normalNum = totalNum - preWarningNum;
        User user = userMapper.getById(userId);
        return new SchoolStatistics(user.getUserId(), user.getDescription(), user.getLevel(), preWarningNum, normalNum, totalNum);
    }
}
