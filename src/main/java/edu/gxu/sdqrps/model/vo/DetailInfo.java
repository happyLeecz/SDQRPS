package edu.gxu.sdqrps.model.vo;

import lombok.Data;

/**
 * @author cz
 * @date 2020/1/7 7:36 下午
 */
@Data
public class DetailInfo {
    private int contentId;
    private int userId;
    private int indexId;
    private int qualityControlId;
    private String qualityControlDescription;
    private int target;
    private int standard;
    private int preWarningValue;
}
