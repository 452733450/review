package com.jack.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SubwayStation {
    private String name;
    private int bikes;

    public void addBikes(int count) {
        bikes += count;
    }

    public void removeBikes(int count) {
        bikes -= count;
    }
}
