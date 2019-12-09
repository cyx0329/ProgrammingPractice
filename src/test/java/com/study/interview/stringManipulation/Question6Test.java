package com.study.interview.stringManipulation;

import com.study.interview.stringManipulation.Question6;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class Question6Test {

    Question6 q;

    @Before
    public void setUp() throws Exception {
        q = new Question6();
    }

    @Test
    public void findDuplicateCharactersTestCase1() {
        String input = "Programming";
        Map<Character, Integer> map = q.findDuplicateCharacters(input);
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        result.put('m', 2);
        result.put('g', 2);
        result.put('r', 2);
        assertThat(map, is(result));
        assertThat(map.size(), is(3));
        assertThat(map, IsMapContaining.hasEntry('g', 2));
        assertThat(map, not(IsMapContaining.hasEntry('o', 1)));
    }
}