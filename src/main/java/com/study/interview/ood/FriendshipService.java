package com.study.interview.ood;

import java.util.*;

/*
Support follow & unfollow, getFollowers, getFollowings.
Note: the results of getfollow() are sorted.

样例
Example 1

input:
follow(1, 3)
getFollowers(1)
getFollowings(3)
follow(2, 3)
getFollowings(3)
unfollow(1, 3)
getFollowings(3)
output:
[3]
[1]
[1,2]
[2]
Explanation:
follow(1, 3)
getFollowers(1) // return [3]
getFollowings(3) // return [1]
follow(2, 3)
getFollowings(3) // return [1,2]
unfollow(1, 3)
getFollowings(3) // return [2]
Example 2

input:
follow(1, 2)
unfollow(1, 2)
getFollowings(1)
unfollow(1, 2)
getFollowings(1)
unfollow(1, 2)
follow(1, 2)
getFollowings(1)
output:
[]
[]
[]

 */

public class FriendshipService {

    private Map<Integer, Set<Integer>> followers, followings;

    public FriendshipService() {
        // initialize your data structure here.
        this.followers = new HashMap<Integer, Set<Integer>>();
        this.followings = new HashMap<Integer, Set<Integer>>();
    }

    // @param user_id an integer
    // return all followers and sort by user_id
    public List<Integer> getFollowers(int user_id) {
        // Write your code here
        if (!followers.containsKey(user_id))
            return new ArrayList<Integer>();

        return new ArrayList<Integer>(followers.get(user_id));
    }

    // @param user_id an integer
    // return all followings and sort by user_id
    public List<Integer>  getFollowings(int user_id) {
        // Write your code here
        if (!followings.containsKey(user_id))
            return new ArrayList<Integer>();

        return new ArrayList<Integer>(followings.get(user_id));
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int to_user_id, int from_user_id) {
        // Write your code here
        if (!followers.containsKey(to_user_id))
            followers.put(to_user_id, new TreeSet<Integer>());

        followers.get(to_user_id).add(from_user_id);

        if (!followings.containsKey(from_user_id))
            followings.put(from_user_id, new TreeSet<Integer>());

        followings.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int to_user_id, int from_user_id) {
        // Write your code here
        if (followers.containsKey(to_user_id))
            followers.get(to_user_id).remove(from_user_id);

        if (followings.containsKey(from_user_id))
            followings.get(from_user_id).remove(to_user_id);
    }
}