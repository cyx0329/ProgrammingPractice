package com.study.interview.amazon.dataStructure.array;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MergingMeetingTimesTest {

    MergingMeetingTimes mergingMeetingTimes;

    @Before
    public void setUp() throws Exception {
        mergingMeetingTimes = new MergingMeetingTimes();
    }


    @Test
    public void mergeRanges() {
    }

    // tests

    @Test
    public void meetingsOverlapTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(new MergingMeetingTimes.Meeting(1, 3), new MergingMeetingTimes.Meeting(2, 4));
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(new MergingMeetingTimes.Meeting(1, 4));
        assertEquals(expected, actual);
    }

    @Test
    public void  meetingsTouchTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(new MergingMeetingTimes.Meeting(5, 6), new MergingMeetingTimes.Meeting(6, 8));
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(new MergingMeetingTimes.Meeting(5, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingContainsOtherMeetingTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(new MergingMeetingTimes.Meeting(1, 8), new MergingMeetingTimes.Meeting(2, 5));
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(new MergingMeetingTimes.Meeting(1, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsStaySeparateTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(new MergingMeetingTimes.Meeting(1, 3), new MergingMeetingTimes.Meeting(4, 8));
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(
                new MergingMeetingTimes.Meeting(1, 3), new MergingMeetingTimes.Meeting(4, 8)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void multipleMergedMeetingsTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergingMeetingTimes.Meeting(1, 4), new MergingMeetingTimes.Meeting(2, 5), new MergingMeetingTimes.Meeting(5, 8));
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(new MergingMeetingTimes.Meeting(1, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsNotSortedTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergingMeetingTimes.Meeting(5, 8), new MergingMeetingTimes.Meeting(1, 4), new MergingMeetingTimes.Meeting(6, 8));
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(
                new MergingMeetingTimes.Meeting(1, 4), new MergingMeetingTimes.Meeting(5, 8)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void oneLongMeetingContainsSmallerMeetingsTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergingMeetingTimes.Meeting(1, 10), new MergingMeetingTimes.Meeting(2, 5), new MergingMeetingTimes.Meeting(6, 8),
                new MergingMeetingTimes.Meeting(9, 10), new MergingMeetingTimes.Meeting(10, 12)
        );
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(
                new MergingMeetingTimes.Meeting(1, 12)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void sampleInputTest() {
        final List<MergingMeetingTimes.Meeting> meetings = Arrays.asList(
                new MergingMeetingTimes.Meeting(0, 1), new MergingMeetingTimes.Meeting(3, 5), new MergingMeetingTimes.Meeting(4, 8),
                new MergingMeetingTimes.Meeting(10, 12), new MergingMeetingTimes.Meeting(9, 10)
        );
        final List<MergingMeetingTimes.Meeting> actual = mergingMeetingTimes.mergeRanges(meetings);
        final List<MergingMeetingTimes.Meeting> expected = Arrays.asList(
                new MergingMeetingTimes.Meeting(0, 1), new MergingMeetingTimes.Meeting(3, 8), new MergingMeetingTimes.Meeting(9, 12)
        );
        assertEquals(expected, actual);
    }
}