package com.study.interview.amazon.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReorderDataInLogFilesTest {

    ReorderDataInLogFiles reorderDataInLogFiles;

    @Before
    public void setUp() throws Exception {
        reorderDataInLogFiles = new ReorderDataInLogFiles();
    }

    @Test
    public void reorderLogFilesTest1() {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] actual = reorderDataInLogFiles.reorderLogFiles1(logs);
        String[] result = new String[]{"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        Assert.assertEquals(result, actual);
    }

    @Test
    public void reorderLogFilesTest2() {
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        String[] actual = reorderDataInLogFiles.reorderLogFiles1(logs);
        String[] result = new String[]{"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        Assert.assertEquals(result, actual);
    }

    @Test
    public void reorderLogFilesTest3() {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] actual = reorderDataInLogFiles.reorderLogFiles2(logs);
        String[] result = new String[]{"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        Assert.assertEquals(result, actual);
    }

    @Test
    public void reorderLogFilesTest4() {
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        String[] actual = reorderDataInLogFiles.reorderLogFiles2(logs);
        String[] result = new String[]{"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        Assert.assertEquals(result, actual);
    }
}