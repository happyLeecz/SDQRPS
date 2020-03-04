package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.entity.Index;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author cz
 */
@Repository
public interface IndexMapper {

    Index getByIndexName(@Param("indexDescription") String indexDescription);

    Index getByIndexId(@Param("indexId") int indexId);
}

