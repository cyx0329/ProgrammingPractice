package com.study.interview.ood.bankSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
    private int id;
    private int currentBalance;
    private List<Integer> balances;
    private List<Long> timestamps;

    public Account(int _id) {
        id = _id;
        currentBalance = 0;
        balances = new ArrayList<>();
        timestamps = new ArrayList<>();
    }

    public void deposite(int amount, long timestamp) {
        currentBalance += amount;
        balances.add(currentBalance);
        timestamps.add(timestamp);
    }

    public boolean withdraw(int amount , long timestamp) {
        if (currentBalance < amount) {
            return false;
        }

        currentBalance -= amount;
        balances.add(currentBalance);
        timestamps.add(timestamp);
        return true;
    }

    public int[] check(long startTime, long endTime) {
        return new int[]{findLeftClosest(startTime), findLeftClosest(endTime)};
    }

    private int findLeftClosest(long target){
        int len = timestamps.size();
        if (len == 0) {
            return 0;
        }

        int left = 0, right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (timestamps.get(mid) == target) {
                return balances.get(mid);
            } else if (timestamps.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (timestamps.get(left) > target){
            return left == 0 ? 0 : balances.get(left - 1);
        }

        if (timestamps.get(right) > target) {
            return right == 0 ? 0 : balances.get(right - 1);
        }

        return balances.get(right);
    }
}

