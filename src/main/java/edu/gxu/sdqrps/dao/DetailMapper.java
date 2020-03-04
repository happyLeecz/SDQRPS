package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.vo.DetailInfo;
import edu.gxu.sdqrps.model.vo.SchoolStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cz
 */
@Repository
public interface DetailMapper {

    int updateValues(@Param("contentId") int contentId,
                     @Param("userId") int userId,
                     @Param("indexId") int indexId,
                     @Param("qualityControlId") int qualityControlId,
                     @Param("target") int target,
                     @Param("standard") int standard,
                     @Param("preWarningValue") int preWarningValue);


    DetailInfo getById(@Param("contentId") int contentId,
                       @Param("userId") int userId,
                       @Param("indexId") int indexId,
                       @Param("qualityControlId") int qualityControlId);

    int updateTarget(@Param("contentId") int contentId,
                     @Param("userId") int userId,
                     @Param("indexId") int indexId,
                     @Param("qualityControlId")int qualityControlId,
                     @Param("newTarget") int newTarget);

    int updateStandard(
                       @Param("contentId") int contentId,
                       @Param("userId") int userId,
                       @Param("indexId") int indexId,
                       @Param("qualityControlId")int qualityControlId,
                       @Param("newStandard") int newStandard);

    int updatePreWarning(@Param("contentId") int contentId,
                         @Param("userId") int userId,
                         @Param("indexId") int indexId,
                         @Param("qualityControlId")int qualityControlId,
                         @Param("newPreWarningValue") int newPreWarningValue);

    List<DetailInfo> listById(@Param("userId") int userId,@Param("contentId") int contentId);

    List<DetailInfo> listByUserId(@Param("userId")int userId);

}
