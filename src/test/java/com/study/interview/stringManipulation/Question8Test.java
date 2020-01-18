package com.study.interview.stringManipulation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question8Test {

    Question8 q;

    @Before
    public void setUp() throws Exception {
        q = new Question8();
    }

    @Test
    public void countGivenCharacterTestCase1() {
        String givenStr = "programming";
        char givenChar = 'n';
        int actual = q.countGivenCharacter(givenStr, givenChar);
        assertEquals(1, actual);
    }

    @Test
    public void countGivenCharacterTestCase2() {
        String givenStr = "java";
        char givenChar = 'a';
        int actual = q.countGivenCharacter(givenStr, givenChar);
        assertEquals(2, actual);
    }

    @Test
    public void countGivenCharacterTestCase3() {
        String givenStr = "";
        char givenChar = 'n';
        int actual = q.countGivenCharacter(givenStr, givenChar);
        assertEquals(0, actual);
    }

    @Test
    public void countGivenCharacterTestCase4() {
        String givenStr = null;
        char givenChar = 'n';
        int actual = q.countGivenCharacter(givenStr, givenChar);
        assertEquals(0, actual);
    }
}