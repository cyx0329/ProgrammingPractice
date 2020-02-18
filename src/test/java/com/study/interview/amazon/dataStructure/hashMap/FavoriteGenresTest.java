package com.study.interview.amazon.dataStructure.hashMap;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FavoriteGenresTest {

    FavoriteGenres favoriteGenres;

    @Before
    public void setUp() throws Exception {
        favoriteGenres = new FavoriteGenres();
    }

    @Test
    public void findFavoriteGenres1() {
        List<String> songs1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
        List<String> songs2 = Arrays.asList("song5", "song6", "song7");
        List<String> songs3 = Arrays.asList("song1", "song3");
        List<String> songs4 = Arrays.asList("song7");
        List<String> songs5 = Arrays.asList("song2", "song4");
        List<String> songs6 = Arrays.asList("song5", "song6");
        List<String> songs7 = Arrays.asList("song8", "song9");
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        userSongs.put("David", songs1);
        userSongs.put("Emma", songs2);
        songGenres.put("Rock", songs3);
        songGenres.put("Dubstep", songs4);
        songGenres.put("Techno", songs5);
        songGenres.put("Pop", songs6);
        songGenres.put("Jazz", songs7);
        Map<String, List<String>> userGenres = new HashMap<>();
        List<String> genres1 = Arrays.asList("Rock", "Techno");
        List<String> genres2 = Arrays.asList("Pop");
        userGenres.put("David", genres1);
        userGenres.put("Emma", genres2);
        Map<String, List<String>> acutal = favoriteGenres.findFavoriteGenres(userSongs, songGenres);
        assertEquals(userGenres, acutal);
    }

    @Test
    public void findFavoriteGenres2() {
        List<String> songs1 = Arrays.asList("song1", "song2");
        List<String> songs2 = Arrays.asList("song3", "song4");
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        userSongs.put("David", songs1);
        userSongs.put("Emma", songs2);
        Map<String, List<String>> userGenres = new HashMap<>();
        userGenres.put("David", Collections.emptyList());
        userGenres.put("Emma", Collections.emptyList());
        Map<String, List<String>> acutal = favoriteGenres.findFavoriteGenres(userSongs, songGenres);
        assertEquals(userGenres, acutal);
    }
}