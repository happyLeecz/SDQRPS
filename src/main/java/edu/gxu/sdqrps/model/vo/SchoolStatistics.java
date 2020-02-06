package edu.gxu.sdqrps.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cz
 * @date 2020/2/6 6:09 下午
 */
@Data
@NoArgsConstructor
public class SchoolStatistics{
    private int userId;
    private String description;
    private int level;
    private long preWarningNum;
    private long normalNum;
    private long totalNum;

    public SchoolStatistics(int userId, String description, int level, long preWarningNum, long normalNum, long totalNum) {
        this.userId = userId;
        this.description = description;
        this.level = level;
        this.preWarningNum = preWarningNum;
        this.normalNum = normalNum;
        this.totalNum = totalNum;
    }
}

