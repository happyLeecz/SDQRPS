package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.entity.QualityControl;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author cz
 */
@Repository
public interface QualityControlMapper {

    QualityControl getById(@Param("qualityControlId") int qualityControlId);

}
