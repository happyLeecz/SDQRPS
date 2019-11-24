package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.domain.QualityControl;
import org.apache.ibatis.annotations.Param;

/**
 * @author cz
 */
public interface QualityControlMapper {

    QualityControl getById(@Param("qualityControlId") int qualityControlId);
}
