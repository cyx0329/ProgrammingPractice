package com.study.interview.amazon.OA2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendCircles {

    public static int friendCircles(List<List<Integer>> relationships) {
        // WRITE YOUR BRILLIANT CODE HERE
        boolean[] visited = new boolean[relationships.size()];
        int count = 0;
        for(int i = 0; i < relationships.size(); i++) {
            if(!visited[i]) {
                dfs(i, visited, relationships);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int i, boolean[] visited, List<List<Integer>> relationships) {
        for(int j = 0; j < relationships.get(0).size(); j++) {
            if(!visited[j] && relationships.get(i).get(j) == 1) {
                visited[j] = true;
                dfs(j, visited, relationships);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int relationshipsLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> relationships = new ArrayList<>();
        for (int i = 0; i < relationshipsLength; i++) {
            relationships.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = friendCircles(relationships);
        System.out.println(res);
    }
}
