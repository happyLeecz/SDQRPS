package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.detailMapper;
import edu.gxu.sdqrps.model.entity.Detail;
import edu.gxu.sdqrps.model.vo.Result;
import edu.gxu.sdqrps.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cz
 * @date 2019/12/22 11:19 上午
 */
@Service
public class DetailServiceImpl implements DetailService {
    private detailMapper detailMapper;

    @Autowired
    public DetailServiceImpl(detailMapper detailMapper) {
        this.detailMapper = detailMapper;
    }

    @Override
    public Result getAllWithUserIdAndContentId(int userId, int contentId) {
        List<Detail> details = detailMapper.listById(userId, contentId);
        if(details.isEmpty())
            return new Result<String>(201, "没有信息");
        else return new Result<List>(200, details);
    }

    @Override
    public boolean updateTargetValue(int contentId, int userId, int qualityControlId, int newTarget) {
        return detailMapper.updateTarget(contentId, userId, qualityControlId, newTarget) != 0;
    }

    @Override
    public boolean updateStandardValue(int contentId, int userId, int qualityControlId, int newStandard) {
        return detailMapper.updateStandard(contentId, userId, qualityControlId, newStandard) != 0;
    }

    @Override
    public boolean updatePreWarningValue(int contentId, int userId, int qualityControlId, int newPreWarningValue) {
        return detailMapper.updatePreWarning(contentId, userId, qualityControlId, newPreWarningValue) != 0;
    }
}
