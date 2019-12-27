package edu.gxu.sdqrps.model.entity;

import lombok.Data;
/**
 * @author cz
 */
@Data
public class Detail {
    private int contentId;
    private int userId;
    private int qualityControlId;
    private int target;
    private int standard;
    private int preWarningValue;
}
