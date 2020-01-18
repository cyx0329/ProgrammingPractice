package com.study.interview.leetCode;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystemTest extends TestCase {

    SearchSuggestionsSystem searchSuggestionsSystem;

    @Before
    public void setUp() throws Exception {
        searchSuggestionsSystem = new SearchSuggestionsSystem();
    }

    @Test
    public void testSuggestedProducts() {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = searchSuggestionsSystem.suggestedProducts(products, searchWord);
        List<List<String>> actual = new ArrayList<>();
        List<String> list1 = Arrays.asList("mobile","moneypot","monitor");
        List<String> list2 = Arrays.asList("mobile","moneypot","monitor");
        List<String> list3 = Arrays.asList("mouse","mousepad");
        List<String> list4 = Arrays.asList("mouse","mousepad");
        List<String> list5 = Arrays.asList("mouse","mousepad");
        actual.add(list1);
        actual.add(list2);
        actual.add(list3);
        actual.add(list4);
        actual.add(list5);
        assertEquals(result, actual);
    }
}