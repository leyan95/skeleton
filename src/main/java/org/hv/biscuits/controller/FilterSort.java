package org.hv.biscuits.controller;

/**
 * @author leyan95 2020/3/3
 * @version 1.0
 */
public class FilterSort {
    /**
     * 属性
     */
    private String key;
    /**
     * 排序方式：{@link FilterSortDirection}
     */
    private String direction;
    /**
     * 排序的拼接顺序
     */
    private int idx;

    public FilterSort() {
    }

    public FilterSort(String key, String direction, int idx) {
        this.key = key;
        this.direction = direction;
        this.idx = idx;
    }

    public String getKey() {
        return key;
    }

    public String getDirection() {
        return direction;
    }

    public int getIdx() {
        return idx;
    }
}
