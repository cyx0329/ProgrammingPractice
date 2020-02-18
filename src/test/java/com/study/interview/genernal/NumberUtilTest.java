package com.study.interview.genernal;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumberUtilTest {

    NumberUtil numberUtil;

    @Before
    public void setUp() throws Exception {
        numberUtil = new NumberUtil();
    }

    @Test
    public void numberDiviableBy5() {
        int start = 25;
        int end = 175;
        List<Integer> result = numberUtil.numberDiviableBy5(start, end);
        List<Integer> excepted = Arrays.asList(25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80,
                85, 90, 95, 100, 105, 110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160,
                165, 170, 175);
        assertThat(result, is(excepted));
    }
}