package com.study.interview.amazon.algorithm.slidingWindow;

import com.study.interview.amazon.algorithm.slidingWindow.SubstringWithExactlyKDistinctChars;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubstringWithExactlyKDistinctCharsTest {

    SubstringWithExactlyKDistinctChars substringWithExactlyKDistinctChars;

    @Before
    public void setUp() throws Exception {
        substringWithExactlyKDistinctChars = new SubstringWithExactlyKDistinctChars();
    }

    @Test
    public void substringWithExactlyKDistinctCharsTest1() {
        String s = "pqpqs";
        int k = 2;
        int actual = substringWithExactlyKDistinctChars.substringWithExactlyKDistinctChars(s, k);
        assertEquals(7, actual);
    }

    @Test
    public void substringWithExactlyKDistinctCharsTest2() {
        String s = "aabab";
        int k = 3;
        int actual = substringWithExactlyKDistinctChars.substringWithExactlyKDistinctChars(s,k);
        assertEquals(0, actual);
    }
}