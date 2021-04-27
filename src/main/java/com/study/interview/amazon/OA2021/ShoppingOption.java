package com.study.interview.amazon.OA2021;

import java.util.*;
import java.util.stream.Collectors;

public class ShoppingOption {

    public static int getNumberOfOptions(int[] priceOfJeans, int[] priceOfShoes, int[] priceOfSkirts, int[] priceOfTops, int dollar) {

        List<Integer> price1 = getList(priceOfJeans, priceOfShoes);
        List<Integer> price2 = getList(priceOfSkirts, priceOfTops);

        int result = 0;

        for(int i = 0; i < price1.size(); i++) {
            int target = dollar - price1.get(i);
            result += getPriceCom(price2, 0, price2.size()-1, target);
        }

        return result;
    }

    private static int getPriceCom(List<Integer> price2, int start, int end, int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(price2.get(mid) == target) {
                start = mid + 1;
            } else if(price2.get(mid) < target) {
                start = mid + 1;
            } else{
                end = mid -1;
            }
        }
        return start;
    }

    private static List<Integer> getList(int[] A, int[] B) {
        List<Integer> list = new ArrayList<>();

        for(int a : A) {
            for(int b : B) {
                int sum = a + b;
                list.add(sum);
            }
        }

        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        int[] priceOfJeans = {2, 3};
        int[] priceOfShoes = {4};
        int[] priceOfSkirts = {2, 3};
        int[] priceOfTops = {1, 2};
        int budget = 10;
        int result = getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, budget);
        System.out.println(result);

        int[] priceOfJeans1 = {2};
        int[] priceOfShoes1 = {3, 4};
        int[] priceOfSkirts1 = {2, 5};
        int[] priceOfTops1 = {4, 6};
        int budget1 = 12;
        int result1 = getNumberOfOptions(priceOfJeans1, priceOfShoes1, priceOfSkirts1, priceOfTops1, budget1);
        System.out.println(result1);

        int[] priceOfJeans2 = {2};
        int[] priceOfShoes2 = {2, 2};
        int[] priceOfSkirts2 = {2};
        int[] priceOfTops2 = {2};
        int budget2 = 9;
        int result2 = getNumberOfOptions(priceOfJeans2, priceOfShoes2, priceOfSkirts2, priceOfTops2, budget2);
        System.out.println(result2);

        int[] priceOfJeans3 = {4, 7};
        int[] priceOfShoes3 = {6, 6};
        int[] priceOfSkirts3 = {1, 3, 5};
        int[] priceOfTops3 = {5, 7, 12};
        int budget3 = 20;
        int result3 = getNumberOfOptions(priceOfJeans3, priceOfShoes3, priceOfSkirts3, priceOfTops3, budget3);
        System.out.println(result3);
    }
}
