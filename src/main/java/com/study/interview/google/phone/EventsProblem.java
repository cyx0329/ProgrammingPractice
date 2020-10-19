package com.study.interview.google.phone;

/*
Event -
Timestamp # int
Is_entry      # True if entry, False if exit
Badge_id    # unique string ID

Before events: 5
events=[
{'time':129, 'is_entry':True, 'badge_id': 'A'},
{'time':126, 'is_entry':False, 'badge_id': 'B'},
{'time':126, 'is_entry':True, 'badge_id': 'E'},
{'time':123, 'is_entry':True, 'badge_id': 'C'},
{'time':126, 'is_entry':True, 'badge_id': 'D'},
]

time 123, max: 6
time 126, max: 5
time 129, max: 6

def GetMaxOccupancy(events, initial_occupancy):
# Implementation here..
*/

import java.util.Collections;
import java.util.List;

public class EventsProblem {

    class Event {
        int time;
        boolean is_entry;
        String badge_id;
    }

    public int getMaxOccupancy(List<Event> events, int initial) {
        Collections.sort(events, (o1, o2) -> o1.time - o2.time);
        int max = initial;
        int count = initial;
        boolean flag = false;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).time != events.get(i + 1).time) {
                flag = false;
                if (events.get(i).is_entry == true) {
                    count++;
                } else {
                    count--;
                }
            } else {
                flag = true;
                if (events.get(i).is_entry == true) {
                    count++;
                } else {
                    count--;
                }
            }
            if (flag == false) {
                max = Math.max(max, count);
            }

        }
        return max;
    }

}
