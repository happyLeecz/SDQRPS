package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.domain.IdeologyAndEthics;
import org.apache.ibatis.annotations.Param;

/**
 * @author cz
 */
public interface IdeologyAndEthicsMapper {

//    int insertTarget(@Param("userId") int userId,
//                     @Param("qualityControlId") int qualityControlId,
//                     @Param("target") int target);
//
//    int insertStandard(@Param("userId") int userId,
//                       @Param("qualityControlId") int qualityControlId,
//                       @Param("standard") int standard);
//
//    int insertPreWarning(@Param("userId") int userId,
//                         @Param("qualityControlId") int qualityControlId,
//                         @Param("preWarning") int preWarning);
    int updateValues(@Param("userId") int userId,
                     @Param("qualityControlId") int qualityControlId,
                     @Param("target") int target,
                     @Param("standard") int standard,
                     @Param("preWarningValue") int preWarningValue);


    IdeologyAndEthics getById(@Param("userId") int userId,
                              @Param("qualityControlId") int qualityControlId);

    int updateTarget(@Param("userId") int userId,
                     @Param("qualityControlId")int qualityControlId,
                     @Param("newTarget") int newTarget);

    int updateStandard(@Param("userId") int userId,
                       @Param("qualityControlId")int qualityControlId,
                       @Param("newStandard") int newStandard);

    int updatePreWarning(@Param("userId") int userId,
                         @Param("qualityControlId")int qualityControlId,
                         @Param("newPreWarningValue") int newPreWarningValue);


}
