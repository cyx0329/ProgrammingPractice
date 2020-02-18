package com.study.interview.leetCode;

/*
    You have an array of logs.  Each log is a space delimited string of words.
    For each log, the first word in each log is an alphanumeric identifier.  Then, either:
    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.
    We will call these two varieties of logs letter-logs and digit-logs.
    It is guaranteed that each log has at least one word after its identifier.
    Reorder the logs so that all of the letter-logs come before any digit-log.
    The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
    Return the final order of the logs.

    Constraints:
    0 <= logs.length <= 100
    3 <= logs[i].length <= 100
    logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

import java.util.*;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles1(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            String[] split = log.split(" ", 2);
            if (Character.isDigit(split[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" "))) == 0) {
                    return o1.compareTo(o2);
                } else {
                    return o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")));
                }
            }
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }

    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                } else {
                    //return log1.compareTo(log2); Don't use log1 log2 to compare, run time is huge!
                    return split1[0].compareTo(split2[0]);
                }
            } else if (isDigit1) {
                if (isDigit2) {
                    return 0;
                } else {
                    return 1; //In here should return 1
                    // because it means 1 is Digit, 2 is not Digit, value 1 > value 2
                    // then switch there position, nature order
                }
            } else {
                return -1;
            }
        });
        return logs;
    }
}

