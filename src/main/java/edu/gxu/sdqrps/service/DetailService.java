package edu.gxu.sdqrps.service;

import edu.gxu.sdqrps.model.entity.Detail;
import edu.gxu.sdqrps.model.vo.Result;

import java.util.List;

/**
 * @author cz
 * @date 2019/11/28 7:33 PM
 */
public interface DetailService {

    Result getAllWithUserIdAndContentId(int userId, int contentId);

    boolean updateTargetValue(int contentId, int userId,int qualityControlId,int newTarget);

    boolean updateStandardValue(int contentId, int userId,int qualityControlId,int newStandard);

    boolean updatePreWarningValue(int contentId, int userId,int qualityControlId,int newPreWarningValue);



}
