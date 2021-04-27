package com.study.interview.amazon.OA2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrimeAirRouteWith1DArray {

    public static class TaskWithIndex {
        int index, task;

        public TaskWithIndex(int index, int task) {
            this.index = index;
            this.task = task;
        }
    }

    public static List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K) {

        List<TaskWithIndex> foreList = getSortedList(foregroundTasks);
        List<TaskWithIndex> backList = getSortedList(backgroundTasks);

        if(foreList.size() == 0 && backList.size() == 0) {
            List<int[]> result = new ArrayList<>();
            result.add(new int[] {-1, -1});
            return result;
        } else if(foreList.size() == 0) {
            return getResultWithSingle(backList, K, false);
        } else if(backList.size() == 0) {
            return getResultWithSingle(foreList, K, true);
        }

        return getResult(foreList, backList, K);


    }

    private static List<int[]> getResultWithSingle(List<TaskWithIndex> list, int K, boolean fore) {
        int s = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();
        int index = getIndex(list, 0, list.size() - 1, K);
        for(int i = 0; i < index; i++) {
            if(list.get(i).task > s) {
                result.clear();
                s = list.get(i).task;
            }
            if(fore == true) {
                result.add(new int[] {list.get(i).index, -1});
            } else {
                result.add(new int[] {-1, list.get(i).index});
            }
        }
        if(result.size() == 0) {
            result.add(new int[]{-1, -1});
        }
        return result;
    }

    private static List<int[]> getResult(List<TaskWithIndex> foreList, List<TaskWithIndex> backList, int K) {
        int s = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < foreList.size(); i++) {
            int target = K - foreList.get(i).task;
            int size = getIndex(backList, 0, backList.size() - 1, target);
            for(int j = 0; j < size; j++) {
                int sum = foreList.get(i).task + backList.get(j).task;
                if (sum < s) {
                    continue;
                }
                if(sum > s) {
                    result.clear();
                    s = sum;
                }
                result.add(new int[] {foreList.get(i).index, backList.get(j).index});
            }

        }

        for (int i = 0; i < foreList.size(); i++) {
            if(foreList.get(i).task == K) {
                result.add(new int[]{foreList.get(i).index, -1});
            }
        }
        for (int j = 0; j < backList.size(); j++) {
            if(backList.get(j).task == K) {
                result.add(new int[]{-1, backList.get(j).index});
            }
        }
        if(result.size() == 0) {
            result.add(new int[]{-1, -1});
        }
        return result;
    }

    private static List<int[]> getResultRotation(List<TaskWithIndex> foreList, List<TaskWithIndex> backList, int K) {
        int s = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < foreList.size(); i++) {
            int target = K - foreList.get(i).task;
            if(target == 0) {
                result.add(new int[] {-1, foreList.get(i).index});
            }
            int size = getIndex(backList, 0, backList.size() - 1, target);
            for(int j = 0; j < size; j++) {
                int sum = foreList.get(i).task + backList.get(j).task;
                if (sum < s) {
                    continue;
                }
                if(sum > s) {
                    result.clear();
                    s = sum;
                }
                result.add(new int[] {backList.get(j).index, foreList.get(i).index});
            }

        }
        return result;
    }

    private static int getIndex(List<TaskWithIndex> list, int start, int end, int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(list.get(mid).task == target) {
                start = mid + 1;
            } else if(list.get(mid).task < target) {
                start = mid + 1;
            } else{
                end = mid -1;
            }
        }
        return start;
    }

    private static List<TaskWithIndex> getSortedList(int[] array) {
        List<TaskWithIndex> list = new ArrayList<>();

        for(int i = 0; i < array.length; i++) {
            list.add(new TaskWithIndex(i, array[i]));
        }

        Collections.sort(list, new SortbyIndex());
        return list;
    }

    private static class SortbyIndex implements Comparator<TaskWithIndex> {

        public int compare(TaskWithIndex a, TaskWithIndex b)
        {
            return a.task - b.task;
        }
    }

    public static void main(String[] args) {
        int[] foregroundTasks4 = {};
        int[] backgroundTasks4 = {};
        int K4 = 10;
        List<int[]> result4 = optimizeMemoryUsage(foregroundTasks4, backgroundTasks4, K4);
        for(int[] i : result4) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
        System.out.println("");
        int[] foregroundTasks5 = {1};
        int[] backgroundTasks5 = {};
        int K5 = 0;
        List<int[]> result5 = optimizeMemoryUsage(foregroundTasks5, backgroundTasks5, K5);
        for(int[] i : result5) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
        System.out.println("");
        int[] foregroundTasks6 = {};
        int[] backgroundTasks6 = {1};
        int K6 = 0;
        List<int[]> result6 = optimizeMemoryUsage(foregroundTasks6, backgroundTasks6, K6);
        for(int[] i : result6) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
        System.out.println("");
        int[] foregroundTasks3 = {1, 7, 8};
        int[] backgroundTasks3 = {3, 1, 2};
        int K3 = 10;
        List<int[]> result3 = optimizeMemoryUsage(foregroundTasks3, backgroundTasks3, K3);
        for(int[] i : result3) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
        System.out.println("");
        int[] foregroundTasks = {1, 7, 2, 4, 5, 6};
        int[] backgroundTasks = {3, 1, 2};
        int K = 6;
        List<int[]> result = optimizeMemoryUsage(foregroundTasks, backgroundTasks, K);
        for(int[] i : result) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
        System.out.println("");
        int[] foregroundTasks1 = {1, 7, 2, 4, 5, 6};
        int[] backgroundTasks1 = {1, 1, 2};
        int K1 = 10;
        List<int[]> result1 = optimizeMemoryUsage(foregroundTasks1, backgroundTasks1, K1);
        for(int[] i : result1) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
        System.out.println("");
        int[] foregroundTasks2 = {1, 1};
        int[] backgroundTasks2 = {6, 6, 6, 6, 7};
        int K2 = 7;
        List<int[]> result2 = optimizeMemoryUsage(foregroundTasks2, backgroundTasks2, K2);
        for(int[] i : result2) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
        System.out.println("");
    }
}
