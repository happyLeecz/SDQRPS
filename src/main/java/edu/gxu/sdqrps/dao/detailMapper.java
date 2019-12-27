package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.entity.Detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cz
 */

public interface detailMapper {

    int updateValues(@Param("contentId") int contentId,
                     @Param("userId") int userId,
                     @Param("qualityControlId") int qualityControlId,
                     @Param("target") int target,
                     @Param("standard") int standard,
                     @Param("preWarningValue") int preWarningValue);


    Detail getById(@Param("contentId") int contentId,
                   @Param("userId") int userId,
                   @Param("qualityControlId") int qualityControlId);

    int updateTarget(@Param("contentId") int contentId,
                     @Param("userId") int userId,
                     @Param("qualityControlId")int qualityControlId,
                     @Param("newTarget") int newTarget);

    int updateStandard(
                       @Param("contentId") int contentId,
                       @Param("userId") int userId,
                       @Param("qualityControlId")int qualityControlId,
                       @Param("newStandard") int newStandard);

    int updatePreWarning(@Param("contentId") int contentId,
                         @Param("userId") int userId,
                         @Param("qualityControlId")int qualityControlId,
                         @Param("newPreWarningValue") int newPreWarningValue);

    List<Detail> listByUserId(@Param("userId") int userId);
    

}
