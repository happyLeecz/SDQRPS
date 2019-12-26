package edu.gxu.sdqrps.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cz
 */
@Data
public class User {
    private int userId;
    private String description;
    private String userName;
    private String password;
    private int level;
}
