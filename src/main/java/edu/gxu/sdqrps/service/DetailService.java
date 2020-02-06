package edu.gxu.sdqrps.service;

import edu.gxu.sdqrps.model.vo.InfoResult;

/**
 * @author cz
 * @date 2019/11/28 7:33 PM
 */
public interface DetailService {

    InfoResult getAllWithUserIdAndContentId(int userId, int contentId, Integer indexId);

    InfoResult updateTargetValue(int contentId, int userId,int indexId,int qualityControlId,int newTarget);

    InfoResult updateStandardValue(int contentId, int userId,int indexId,int qualityControlId,int newStandard);

    InfoResult updatePreWarningValue(int contentId, int userId,int indexId,int qualityControlId,int newPreWarningValue);

    InfoResult getProjectWithQualityControlId(int qualityControlId);

    InfoResult getRatioNum(int userId, int contentId, Integer indexId);

    InfoResult getSchoolStatistics(int userId);

}
