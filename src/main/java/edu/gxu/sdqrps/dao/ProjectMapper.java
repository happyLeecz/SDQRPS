package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.domain.Project;
import org.apache.ibatis.annotations.Param;

/**
 * @author cz
 */
public interface ProjectMapper {

    Project getByProjectId(@Param("projectId") int projectId);

}
