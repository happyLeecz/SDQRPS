package edu.gxu.sdqrps.model.domain;

import lombok.Data;
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
