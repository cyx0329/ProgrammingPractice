package com.study.interview.amazon.algorithm.bfs;

import com.study.interview.amazon.algorithm.bfs.ZombieInMatrix;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ZombieInMatrixTest {

    ZombieInMatrix zombieInMatrix;

    @Before
    public void setUp() throws Exception {
        zombieInMatrix = new ZombieInMatrix();
    }

    @Test
    public void findHour1() {
        Integer[] line1 = new Integer[]{0, 1, 1, 0, 1};
        List<Integer> list1 = Arrays.asList(line1);
        Integer[] line2 = new Integer[]{0, 1, 0, 1, 0};
        List<Integer> list2 = Arrays.asList(line2);
        Integer[] line3 = new Integer[]{0, 0, 0, 0, 1};
        List<Integer> list3 = Arrays.asList(line3);
        Integer[] line4 = new Integer[]{0, 1, 0, 0, 0};
        List<Integer> list4 = Arrays.asList(line4);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        grid.add(list4);
        System.out.println(grid);
        int actual = zombieInMatrix.FindHour(grid);
        assertEquals(2, actual);
    }

    @Test
    public void findHour2() {
        Integer[] line1 = new Integer[]{0, 1, 1, 0, 1};
        List<Integer> list1 = Arrays.asList(line1);
        Integer[] line2 = new Integer[]{0, 1, 0, 1, 0};
        List<Integer> list2 = Arrays.asList(line2);
        Integer[] line3 = new Integer[]{0, 0, 0, 0, 1};
        List<Integer> list3 = Arrays.asList(line3);
        Integer[] line4 = new Integer[]{0, 1, 0, 0, 0};
        List<Integer> list4 = Arrays.asList(line4);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        grid.add(list4);
        System.out.println(grid);
        int actual = zombieInMatrix.FindHour(grid);
        assertEquals(2, actual);
    }

    @Test
    public void findHour3() {
        List<List<Integer>> grid = new ArrayList<>();
        System.out.println(grid);
        int actual = zombieInMatrix.FindHour(grid);
        assertEquals(0, actual);
    }

    @Test
    public void findHour4() {
        Integer[] line1 = new Integer[]{1, 1, 1, 1, 1};
        List<Integer> list1 = Arrays.asList(line1);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list1);
        grid.add(list1);
        grid.add(list1);
        System.out.println(grid);
        int actual = zombieInMatrix.FindHour(grid);
        assertEquals(0, actual);
    }

    @Test
    public void findHour5() {
        Integer[] line1 = new Integer[]{0, 0, 0, 0, 0};
        List<Integer> list1 = Arrays.asList(line1);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list1);
        grid.add(list1);
        grid.add(list1);
        System.out.println(grid);
        int actual = zombieInMatrix.FindHour(grid);
        assertEquals(-1, actual);
    }

    @Test
    public void findHour6() {
        int actual = zombieInMatrix.FindHour(null);
        assertEquals(0, actual);
    }
}