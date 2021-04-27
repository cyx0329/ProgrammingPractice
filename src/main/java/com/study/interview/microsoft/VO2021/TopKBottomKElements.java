package com.study.interview.microsoft.VO2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKBottomKElements {

    public static int[] topKAndBottomK(File file, int K) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Integer num = Integer.valueOf(line);
            minHeap.add(num);
            maxHeap.add(num);
            if(minHeap.size() > K) {
                minHeap.poll();
            }
            if(maxHeap.size() > K) {
                maxHeap.remove();
            }
        }

        return new int[] {minHeap.peek(), maxHeap.peek()};

    }

    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("/Users/yinacai/IdeaProjects/studyInterview/src/main/java/com/study/interview/microsoft/VO2021/test.txt");
        int[] result = topKAndBottomK(text, 2);
        System.out.println("Top K element:" + result[0] + ", Bottom K element:" + result[1]);
    }

}
