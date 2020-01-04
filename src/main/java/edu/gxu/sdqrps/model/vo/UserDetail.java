package edu.gxu.sdqrps.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cz
 * @date 2019/12/28 10:39 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    private int userId;
    private String description;
    private int level;
}
