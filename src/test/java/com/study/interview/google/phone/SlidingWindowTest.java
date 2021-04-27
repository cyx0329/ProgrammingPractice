package com.study.interview.google.phone;

import com.study.interview.genernal.SlidingWindow;
import com.study.interview.genernal.SlidingWindowFollowUp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingWindowTest {

    SlidingWindow slidingWindow;
    SlidingWindowFollowUp slidingWindowFollowUp;

    @Before
    public void setUp() throws Exception {
        slidingWindow = new SlidingWindow(3);
        slidingWindowFollowUp = new SlidingWindowFollowUp();
    }

    @Test
    public void testCase1() {
        slidingWindow.add(1);
        slidingWindow.add(2);
        assertEquals(2,slidingWindow.getProduct());
        slidingWindow.add(3);
        assertEquals(6,slidingWindow.getProduct());
        slidingWindow.add(4);
        assertEquals(24,slidingWindow.getProduct());
    }

    @Test
    public void testCase2() {
        slidingWindow.add(0);
        slidingWindow.add(0);
        assertEquals(0,slidingWindow.getProduct());
        slidingWindow.add(3);
        assertEquals(0,slidingWindow.getProduct());
        slidingWindow.add(4);
        assertEquals(0,slidingWindow.getProduct());
        slidingWindow.add(4);
        assertEquals(48,slidingWindow.getProduct());
    }

    @Test
    public void testCase3() {
        slidingWindow.add(2);
        assertEquals(2,slidingWindow.getProduct());

    }

    @Test
    public void testCase4() {
        slidingWindowFollowUp.add(1);
        slidingWindowFollowUp.add(2);
        assertEquals(2,slidingWindowFollowUp.getProduct(3));
        slidingWindowFollowUp.add(3);
        assertEquals(6,slidingWindowFollowUp.getProduct(3));
        slidingWindowFollowUp.add(4);
        assertEquals(24,slidingWindowFollowUp.getProduct(3));
    }

    @Test
    public void testCase5() {
        slidingWindowFollowUp.add(0);
        slidingWindowFollowUp.add(0);
        assertEquals(0,slidingWindowFollowUp.getProduct(3));
        slidingWindowFollowUp.add(3);
        assertEquals(0,slidingWindowFollowUp.getProduct(3));
        slidingWindowFollowUp.add(4);
        assertEquals(0,slidingWindowFollowUp.getProduct(3));
        slidingWindowFollowUp.add(4);
        assertEquals(48,slidingWindowFollowUp.getProduct(3));
    }

    @Test
    public void testCase6() {
        slidingWindowFollowUp.add(2);
        assertEquals(2,slidingWindowFollowUp.getProduct(3));

    }
}