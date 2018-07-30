package com.study.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

//https://leetcode.com/problems/reverse-string/description/

public class ReverseStringTest {

    ReverseString rs;

    @Before
    public void setUp() throws Exception {
        rs = new ReverseString();
    }

    @Test
    public void reverseStringEmpty() {
        String s1 = "";
        String s2 = rs.reverseString(s1);
        assertEquals(s1, s2);
    }

    @Test
    public void reverseStringNull() {
        String s1 = null;
        String s2 = rs.reverseString(s1);
        assertNull(s2);
    }

    @Test
    public void reverseStringValid() {
        String s1 = "Hello";
        String s2 = rs.reverseString(s1);
        assertEquals("olleH", s2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reverseStringOverflow(){
        String s1 = "nicknick!";
        String s2 = rs.reverseString(s1);
    }
}