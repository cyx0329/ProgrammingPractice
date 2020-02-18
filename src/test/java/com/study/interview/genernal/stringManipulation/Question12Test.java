package com.study.interview.genernal.stringManipulation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question12Test {

    Question12 question12;

    @Before
    public void setUp() throws Exception {
        question12 = new Question12();
    }

    @Test
    public void reverseSentence() {
        String sentence = "Java is the best programming language";
        String actual = question12.reverseSentence(sentence);
        String expected = "language programming best the is Java";
        assertEquals(expected, actual);
    }
}