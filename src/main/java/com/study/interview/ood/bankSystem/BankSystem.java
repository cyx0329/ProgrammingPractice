package com.study.interview.ood.bankSystem;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<Integer, Account> idToAccount;

    public BankSystem() {
        // Write your code here
        idToAccount = new HashMap<>();
    }

    /**
     * @param id:        user account id
     * @param amount:    the number of bank deposits
     * @param timestamp: the data of bank transaction
     * @return: nothing
     */
    public void deposite(int id, int amount, long timestamp) {
        // Write your code here
        if (!idToAccount.containsKey(id)) {
            idToAccount.put(id, new Account(id));
        }
        idToAccount.get(id).deposite(amount, timestamp);
    }

    /**
     * @param id:        user account id
     * @param amount     : the number of bank withdraw
     * @param timestamp: the data of bank transaction
     * @return: if user account can not withdraw the number of amount,return false. else return true
     */
    public boolean withdraw(int id, int amount, long timestamp) {
        // Write your code here
        if (!idToAccount.containsKey(id)) {
            return false;
        }
        return idToAccount.get(id).withdraw(amount, timestamp);
    }

    /**
     * @param id:        user account id
     * @param startTime: start time
     * @param endTime:   end time
     * @return: need return two numbers,the first one is start time account balance,the second is end time account balance
     */
    public int[] check(int id, long startTime, long endTime) {
        // Write your code here
        if (!idToAccount.containsKey(id)) {
            return new int[0];
        }
        return idToAccount.get(id).check(startTime, endTime);
    }
}