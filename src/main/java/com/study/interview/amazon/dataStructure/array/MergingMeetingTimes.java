package com.study.interview.amazon.dataStructure.array;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/*
For example, given:

  [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]

your method would return:

  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
 */

public class MergingMeetingTimes {
    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + startTime;
            result = result * 31 + endTime;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // merge meetings ranges
        Collections.sort(meetings, (o1, o2) -> o1.startTime - o2.startTime);
        PriorityQueue<Meeting> maxHeap = new PriorityQueue<>((o1, o2) -> o2.endTime - o1.endTime);
        maxHeap.add(meetings.get(0));
        for(int i = 1; i < meetings.size(); i++) {
            Meeting current = meetings.get(i);
            Meeting previous = maxHeap.poll();
            if(current.startTime <= previous.endTime) {
                previous.endTime = Math.max(previous.endTime, current.endTime);
            } else {
                maxHeap.add(current);
            }
            maxHeap.add(previous);
        }
        List<Meeting> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()) ans.add(maxHeap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
