package edu.gxu.sdqrps.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cz
 * @date 2019/12/29 3:16 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T>{
    private int code;
    private T info;
}
