package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.domain.Index;
import org.apache.ibatis.annotations.Param;

/**
 * @author cz
 */
public interface IndexMapper {

    Index getByIndexName(@Param("indexDescription") String indexDescription);

    Index getByIndexId(@Param("indexId") int indexId);
}
