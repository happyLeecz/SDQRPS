package edu.gxu.sdqrps.service;

import edu.gxu.sdqrps.model.entity.IdeologyAndEthics;

import java.util.List;

/**
 * @author cz
 * @date 2019/11/28 7:33 PM
 */
public interface IdeologyAndEthicsService {

    List<IdeologyAndEthics> getAllWithUserId(int userId);

    boolean updateTargetValue(int userId,int qualityControlId,int newTarget);

    boolean updateStandardValue(int userId,int qualityControlId,int newStandard);

    boolean updatePreWarningValue(int userId,int qualityControlId,int newPreWarningValue);



}
