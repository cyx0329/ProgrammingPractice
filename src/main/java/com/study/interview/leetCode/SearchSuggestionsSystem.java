package com.study.interview.leetCode;

/*
    Given an array of strings products and a string searchWord. We want to design a system that suggests at most three
    product names from products after each character of searchWord is typed. Suggested products should have common
    prefix with the searchWord. If there are more than three products with a common prefix return the three
    lexicographically minimums products.
    Return list of lists of the suggested products after each character of searchWord is typed.
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //sort products lexicographically
        /*for(int i = 0; i < products.length -1 ; i++) {
            for(int j = i+1; j < products.length; j++) {
                if(products[i].compareTo(products[j]) > 0)  {
                    String temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }*/
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<List<String>>();
        //Queue<String> queue = new LinkedList<>();
        String perfix;
        for(int m = 1; m <= searchWord.length(); m++) {
            perfix = searchWord.substring(0, m);
            List<String> top3Products = new ArrayList<>();
            for(int n = 0; n < products.length; n++) {
                if(products[n].startsWith(perfix) && top3Products.size() < 3) {
                    top3Products.add(products[n]);
                }
            }
            //List<String> list = new ArrayList<>();
            //Iterator<String> iterator = queue.iterator();
            //while(iterator.hasNext()){
            //    list.add(queue.poll());
            //}
            result.add(top3Products);
        }
        return result;
    }
}

