package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.DetailMapper;
import edu.gxu.sdqrps.model.vo.DetailInfo;
import edu.gxu.sdqrps.model.vo.InfoResult;
import edu.gxu.sdqrps.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cz
 * @date 2019/12/22 11:19 上午
 */
@Service
public class DetailServiceImpl implements DetailService {
    private DetailMapper detailMapper;

    @Autowired
    public DetailServiceImpl(DetailMapper detailMapper) {
        this.detailMapper = detailMapper;
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

       if(detailMapper.updateTarget(contentId, userId,indexId,qualityControlId, newTarget) == 1)
           return new InfoResult<String>(400,"修改目标值成功");
       else
           return new InfoResult<String>(401,"修改目标值失败");
    }

    @Override
    public InfoResult updateStandardValue(int contentId, int userId,int indexId,int qualityControlId, int newStandard) {
        if(detailMapper.updateStandard(contentId, userId,indexId,qualityControlId, newStandard) == 1)
            return new InfoResult<String>(400,"修改标准值成功");
        else
            return new InfoResult<String>(401,"修改标准值失败");
    }

    @Override
    public InfoResult updatePreWarningValue(int contentId, int userId,int indexId, int qualityControlId, int newPreWarningValue) {
       if(detailMapper.updatePreWarning(contentId, userId,indexId, qualityControlId, newPreWarningValue) == 1)
           return new InfoResult<String>(400,"修改预警值成功");
       else
           return new InfoResult<String>(401,"修改预警值失败");
    }
}
