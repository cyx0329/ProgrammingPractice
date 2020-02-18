package com.study.interview.genernal.stringManipulation;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class Question7Test {

    Question7 q;

    @Before
    public void setUp() throws Exception {
        q = new Question7();
    }

    @Test
    public void findAllVowelsTestCase1() {
        String input = "How many vowels in this String";
        List<Character> actual = q.findAllVowels(input);
        List<Character> expected = Arrays.asList('o', 'a', 'o', 'e', 'i', 'i', 'i');

        assertThat(actual, is(expected));

        assertThat(actual, hasItem('a'));

        assertThat(actual, hasSize(7));

        assertThat(actual.size(), is(7));

        assertThat(actual, contains('o', 'a', 'o', 'e', 'i', 'i', 'i'));

        assertThat(actual, containsInAnyOrder('i', 'i', 'i', 'o', 'a', 'o', 'e'));

        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<Character>(), IsEmptyCollection.empty());
    }
}