package com.study.interview.amazon.algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfStores {
    public static void main(String[] args) {
        Character[] line1 = new Character[]{'1', '1', '1', '1', '0'};
        List<Character> list1 = Arrays.asList(line1);
        Character[] line2 = new Character[]{'1', '1', '0', '1', '0'};
        List<Character> list2 = Arrays.asList(line2);
        Character[] line3 = new Character[]{'1', '1', '0', '0', '1'};
        List<Character> list3 = Arrays.asList(line3);
        Character[] line4 = new Character[]{'0', '1', '0', '0', '0'};
        List<Character> list4 = Arrays.asList(line4);
        List<List<Character>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        grid.add(list4);
        System.out.println(grid);
        NumberOfStores solution = new NumberOfStores();
        System.out.println(solution.numStores(grid));
        Character[] line5 = new Character[]{'1', '1', '0', '0', '0'};
        List<Character> list5 = Arrays.asList(line5);
        Character[] line6 = new Character[]{'1', '1', '0', '0', '0'};
        List<Character> list6 = Arrays.asList(line6);
        Character[] line7 = new Character[]{'0', '0', '1', '0', '0'};
        List<Character> list7 = Arrays.asList(line7);
        Character[] line8 = new Character[]{'0', '0', '0', '1', '1'};
        List<Character> list8 = Arrays.asList(line8);
        List<List<Character>> grid1 = new ArrayList<>();
        grid1.add(list5);
        grid1.add(list6);
        grid1.add(list7);
        grid1.add(list8);
        System.out.println(grid1);
        //NumberOfStores solution1 = new NumberOfStores();
        System.out.println(solution.numStores(grid1));
    }

    public int numStores(List<List<Character>> grid) {
        if(grid == null || grid.size() == 0 || grid.get(0).size() == 0) {
            return 0;
        }
        int count  = 0;
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid.get(0).size(); j++) {
                if(grid.get(i).get(j) == '1') {
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private int dfs(List<List<Character>> grid, int i, int j) {
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).size() || grid.get(i).get(j) == '0') {
            return 0;
        }
        grid.get(i).set(j, '0');
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        return 1;
    }
}
