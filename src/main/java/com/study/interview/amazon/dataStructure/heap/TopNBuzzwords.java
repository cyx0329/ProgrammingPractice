package com.study.interview.amazon.dataStructure.heap;

/*  You work on a team whose job is to understand the most sought after toys for the holiday season.
    A teammate of yours has built a webcrawler that extracts a list of quotes about toys from different articles.
    You need to take these quotes and identify which toys are mentioned most frequently.
    Write an algorithm that identifies the top N toys out of a list of quotes and list of toys.

    Your algorithm should output the top N toys mentioned most frequently in the quotes.

    Input:
    The input to the function/method consists of five arguments:

    numToys, an integer representing the number of toys
    topToys, an integer representing the number of top toys your algorithm needs to return;
    toys, a list of strings representing the toys,
    numQuotes, an integer representing the number of quotes about toys;
    quotes, a list of strings that consists of space-sperated words representing articles about toys

    Output:
    Return a list of strings of the most popular N toys in order of most to least frequently mentioned

    Note:
    The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys, return the names of only the toys mentioned in the quotes. If toys are mentioned an equal number of times in quotes, sort alphabetically.

    Example 1:

    Input:
    numToys = 6
    topToys = 2
    toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
    numQuotes = 6
    quotes = [
    "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
    "The new Elmo dolls are super high quality",
    "Expect the Elsa dolls to be very popular this year, Elsa!",
    "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
    "For parents of older kids, look into buying them a drone",
    "Warcraft is slowly rising in popularity ahead of the holiday season"
    ];

    Output:
    ["elmo", "elsa"]

    Explanation:
    elmo - 4
    elsa - 4
    "elmo" should be placed before "elsa" in the result because "elmo" appears in 3 different quotes and "elsa" appears in 2 different quotes.
 */

import java.util.*;

public class TopNBuzzwords {

    public List<String> topNToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        if(topToys == 0 || toys == null || toys.length == 0) {
            return Collections.EMPTY_LIST;
        }

        HashMap<String, int[]> toyFreq = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(String toy : toys) {
            String toyLower = toy.toLowerCase();
            toyFreq.put(toyLower, new int[]{0, 0});
        }

        for(String quote : quotes) {
            HashSet<String> toysSet = new HashSet<>();
            String[] words = quote.toLowerCase().split("\\W+");
            for(String word : words) {
                if(toyFreq.containsKey(word)) {
                    int[] freq = toyFreq.get(word);
                    freq[0]++; //increment word freq
                    if(!toysSet.contains(word)) {
                        freq[1]++; //means current quote contains the word, but haven't input to set to check yet
                    }   //increment quote freq
                    toysSet.add(word);
                }
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<String>(
                (w1, w2) -> {
                    if (toyFreq.get(w1)[0] != toyFreq.get(w2)[0]) {
                        return toyFreq.get(w1)[0] - toyFreq.get(w2)[0];
                    }
                    if(toyFreq.get(w1)[1] != toyFreq.get(w2)[1]) {
                        return toyFreq.get(w1)[1] - toyFreq.get(w2)[1];
                    }
                    return w2.compareTo(w1); //because we need to reverse the ans at the end, so we store alph order reversely
                });

        if(topToys > numToys) {
            for(String toy: toyFreq.keySet()) {
                if(toyFreq.get(toy)[0] > 0) {
                    minHeap.add(toy);
                }
            }
        } else {
            for(String toy: toyFreq.keySet()) {
                if(toyFreq.get(toy)[0] > 0) {
                    minHeap.add(toy);
                    if (minHeap.size() > topToys) {
                        minHeap.poll();
                    }
                }
            }
        }

        while (!minHeap.isEmpty()) ans.add(minHeap.poll());
        Collections.reverse(ans);
        return ans;

    }


    public static void main(String[] args) {
        TopNBuzzwords solution = new TopNBuzzwords();
        int numToys = 6;
        int topToys = 3;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = {
                "tablet Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "tablet tablet The new Elmo dolls are super high quality",
                "tablet Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"};
        List<String> result = solution.topNToys(numToys, topToys, toys, numQuotes, quotes);
        System.out.println(result);
    }


}
