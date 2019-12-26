package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author cz
 */

public interface ProjectMapper {

    Project getByProjectId(@Param("projectId") int projectId);

}
