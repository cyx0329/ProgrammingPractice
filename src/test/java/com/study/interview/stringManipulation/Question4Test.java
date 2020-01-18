package com.study.interview.stringManipulation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question4Test {

    Question4 q;

    @Before
    public void setUp() throws Exception {
        q = new Question4();
    }

    @Test
    public void reverseStringTestCase1() {
        String s = "Morning";
        String reverseS = q.reverseStringIter(s);
        //assertTrue(reverseS.equals("gninrom"));
        assertEquals("gninroM", reverseS);

    }

    @Test
    public void reverseStringTestCase2() {
        String s = null;
        String reverseS = q.reverseStringIter(s);
        assertNull(reverseS);
    }

    @Test
    public void reverseStringTestCase3() {
        String s = "";
        String reverseS = q.reverseStringIter(s);
        assertEquals("", reverseS);
    }

    @Test
    public void reverseStringTestCase4() {
        String s = "Morning";
        String reverseS = q.reverseStringRe(s);
        //assertTrue(reverseS.equals("gninrom"));
        assertEquals("gninroM", reverseS);

    }

    @Test
    public void reverseStringTestCase5() {
        String s = null;
        String reverseS = q.reverseStringRe(s);
        assertNull(reverseS);
    }

    @Test
    public void reverseStringTestCase6() {
        String s = "";
        String reverseS = q.reverseStringRe(s);
        assertEquals("", reverseS);
    }
}