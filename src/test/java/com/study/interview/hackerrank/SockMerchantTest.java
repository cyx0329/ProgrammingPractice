package com.study.interview.hackerrank;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SockMerchantTest {

    SockMerchant sockMerchant;

    @Before
    public void setUp() throws Exception {
        sockMerchant = new SockMerchant();
    }

    @Test
    public void sockMerchant() {
        int n = 9;
        int[] ar = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        int actual = sockMerchant.sockMerchant(n, ar);
        assertEquals(3, actual);
    }
}