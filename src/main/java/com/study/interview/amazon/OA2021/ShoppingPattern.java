package com.study.interview.amazon.OA2021;

import java.util.*;
import java.util.stream.Collectors;

public class ShoppingPattern {
    public static int shoppingPatterns(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        // WRITE YOUR BRILLIANT CODE HERE
        Map<Integer, Set<Integer>> graph = createGraph(productsNodes, productsFrom, productsTo);
        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i <= productsNodes; i++) {
            List<Integer> neighbor = new ArrayList<>(graph.get(i));
            if(neighbor.size() >= 2) {
                int j = 0;
                int k = j+1;
                while(j < k && k < neighbor.size()) {
                    Integer node_A = neighbor.get(j);
                    Integer node_B = neighbor.get(k);
                    if(graph.get(node_A).contains(node_B)) {
                        int cost = graph.get(i).size() + graph.get(node_A).size() + graph.get(node_B).size() - 6;
                        minCost = Math.min(minCost, cost);
                    }
                    j++;
                    k++;
                }
            }
        }
        return minCost == Integer.MAX_VALUE? -1 : minCost;
    }

    private static Map<Integer, Set<Integer>> createGraph(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 1; i <= productsNodes; i++) {
            graph.put(i, new HashSet<>());
        }
        for(int i = 0; i < productsFrom.size(); i++) {
            graph.get(productsFrom.get(i)).add(productsTo.get(i));
            graph.get(productsTo.get(i)).add(productsFrom.get(i));
        }
        return graph;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int productsNodes = Integer.parseInt(scanner.nextLine());
        List<Integer> productsFrom = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> productsTo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = shoppingPatterns(productsNodes, productsFrom, productsTo);
        System.out.println(res);
    }
}
