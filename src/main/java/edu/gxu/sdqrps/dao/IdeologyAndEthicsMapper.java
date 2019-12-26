package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.entity.IdeologyAndEthics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cz
 */

public interface IdeologyAndEthicsMapper {

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

    List<IdeologyAndEthics> listByUserId(@Param("userId") int userId);
    

}
