package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.detailMapper;
import edu.gxu.sdqrps.model.entity.Detail;
import edu.gxu.sdqrps.service.detailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cz
 * @date 2019/12/22 11:19 上午
 */
public class detailServiceImpl implements detailService {
    private detailMapper detailMapper;

    @Autowired
    public detailServiceImpl(detailMapper detailMapper) {
        this.detailMapper = detailMapper;
    }

    @Override
    public List<Detail> getAllWithUserId(int userId) {
        return detailMapper.listByUserId(userId);
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
