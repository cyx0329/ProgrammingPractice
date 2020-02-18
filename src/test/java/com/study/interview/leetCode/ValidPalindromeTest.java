package com.study.interview.leetCode;

import com.study.interview.leetCode.ValidPalindrome;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindromeTest {

    ValidPalindrome vp;

    @Before
    public void setUp() throws Exception {
        vp = new ValidPalindrome();
    }

    @Test
    public void isPalindromeNull() {
        String s = null;
        boolean b = vp.isPalindrome(s);
        assertTrue(b);
    }

    @Test
    public void isPalindromeEmpty() {
        String s = "";
        boolean b = vp.isPalindrome(s);
        assertTrue(b);
    }

    @Test
    public void isPalindromeCase1() {
        String s = "A man, a plan, a canal: Panama";
        boolean b = vp.isPalindrome(s);
        assertTrue(b);
    }

    @Test
    public void isPalindromeCase2() {
        String s = "race a car";
        boolean b = vp.isPalindrome(s);
        assertFalse(b);
    }

    @Test
    public void isPalindromeCase3() {
        String s = "abcba";
        boolean b = vp.isPalindrome(s);
        assertTrue(b);
    }


}