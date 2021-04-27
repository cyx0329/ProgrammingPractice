package com.study.interview.amazon.OA2021;

import java.util.*;

//https://aonecode.com/amazon-online-assessment-transaction-logs

public class TransactionLogs {

    public static String[] processLogFile(String[] logs, int threshold) {

        Map<String, Integer> map = processLogs(logs);
        List<String> result = new ArrayList<>();
        for(String user : map.keySet()) {
            if(map.get(user) >= threshold) {
                result.add(user);
                //result.add(user + " " + map.get(user));
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private static Map<String, Integer> processLogs(String[] logs) {
        Map<String, Integer> map = new HashMap<>();

        for(String log : logs) {
            String[] data = log.split("\\s");
            if(data[0].equals(data[1])) {
                map.put(data[0], map.getOrDefault(data[0], 0) + 1);
            } else {
                map.put(data[0], map.getOrDefault(data[0], 0) + 1);
                map.put(data[1], map.getOrDefault(data[1], 0) + 1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        String[] logs = {"345366 899212 45", "029323 382391 23", "382391 345366 15",
                         "029323 382391 77", "345366 382391 23", "029323 345366 13",
                         "382391 382391 23"};
        int threshold = 3;
        String[] result = processLogFile(logs, threshold);
        for(String re : result) {
            System.out.println(re);
        }
    }
}

/*
A startup that builds a chat app wants to identify highly social users. All the chat data is in a large log file with three values on each line - the sender ID, receipient ID, and the number of messages. Given a threshold number, find the number of users that appear at least as many times as this threshold.

For example:
USERA USERB 14
USERA USERC 94
USERB USERB 3
...
Note: On the third line, a user sents a message to himself.

Inputs
logs = a list of lines where each line is a string
threshold = a number

Output
Return a list of sorted user IDs. If the same user appears in the same line, only count them once.

Example:
Input:
logs:
345366 899212 45
029323 382391 23
382391 345366 15
029323 382391 77
345366 382391 23
029323 345366 13
382391 382391 23
...
threshold: 3

Output: [029323, 345366, 382391]
Explanation:
There are three users that have appear more than 3 times:
345366 appears 4 times.
382391 appears 5 times.
029323 appears 3 times.
 */
