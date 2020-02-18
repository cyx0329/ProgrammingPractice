package com.study.interview.leetCode;

import com.study.interview.leetCode.ValidPalindromeII;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeIITest {


    ValidPalindromeII vp;

    @Before
    public void setUp() throws Exception {
        vp = new ValidPalindromeII();
    }

    @Test
    public void validPalindromeIINull() {
        String s = null;
        boolean b = vp.validPalindrome(s);
        assertTrue(b);
    }

    @Test
    public void validPalindromeIICase1(){
        String s = "aba";
        boolean b = vp.validPalindrome(s);
        assertTrue(b);
    }

    @Test
    public void validPalindromeIICase2(){
        String s = "abca";
        boolean b = vp.validPalindrome(s);
        assertTrue(b);
    }



}