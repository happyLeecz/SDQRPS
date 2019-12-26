package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.IdeologyAndEthicsMapper;
import edu.gxu.sdqrps.model.entity.IdeologyAndEthics;
import edu.gxu.sdqrps.service.IdeologyAndEthicsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cz
 * @date 2019/12/22 11:19 上午
 */
public class IdeologyAndEthicsServiceImpl implements IdeologyAndEthicsService {
    private IdeologyAndEthicsMapper ideologyAndEthicsMapper;

    @Autowired
    public IdeologyAndEthicsServiceImpl(IdeologyAndEthicsMapper ideologyAndEthicsMapper) {
        this.ideologyAndEthicsMapper = ideologyAndEthicsMapper;
    }

    @Override
    public List<IdeologyAndEthics> getAllWithUserId(int userId) {
        return ideologyAndEthicsMapper.listByUserId(userId);
    }

    @Override
    public boolean updateTargetValue(int userId, int qualityControlId, int newTarget) {
        return ideologyAndEthicsMapper.updateTarget(userId, qualityControlId, newTarget) != 0;
    }

    @Override
    public boolean updateStandardValue(int userId, int qualityControlId, int newStandard) {
        return ideologyAndEthicsMapper.updateStandard(userId, qualityControlId, newStandard) != 0;
    }

    @Override
    public boolean updatePreWarningValue(int userId, int qualityControlId, int newPreWarningValue) {
        return ideologyAndEthicsMapper.updatePreWarning(userId, qualityControlId, newPreWarningValue) != 0;
    }
}
