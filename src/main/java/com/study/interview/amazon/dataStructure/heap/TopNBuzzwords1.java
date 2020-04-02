package com.study.interview.amazon.dataStructure.heap;

import java.util.*;

public class TopNBuzzwords1 {
    public List<String> topNToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        if(topToys == 0 || toys == null || toys.length == 0) {
            return Collections.EMPTY_LIST;
        }

        HashMap<String, Integer> toyFreq = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(String toy : toys) {
            String toyLower = toy.toLowerCase();//注意lowercase
            toyFreq.put(toyLower, 0);
        }

        for(String quote : quotes) {
            HashSet<String> toysSet = new HashSet<>();
            String[] words = quote.toLowerCase().split("\\W+");
            for(String word : words) {
                if(toyFreq.containsKey(word) && !toysSet.contains(word)) {
                    toyFreq.put(word, toyFreq.get(word) + 1);
                }
                toysSet.add(word);
            }
        }


        PriorityQueue<String> minHeap = new PriorityQueue<String>(
                (w1, w2) -> (toyFreq.get(w1).equals(toyFreq.get(w2))) ?
                        w2.compareTo(w1) : toyFreq.get(w1)-toyFreq.get(w2));

        if(topToys > numToys) {
            for(String toy: toyFreq.keySet()) {
                if(toyFreq.get(toy) > 0) {
                    minHeap.add(toy);
                }
            }
        } else {
            for(String toy: toyFreq.keySet()) {
                if(toyFreq.get(toy) > 0) {
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
        TopNBuzzwords1 solution = new TopNBuzzwords1();
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
