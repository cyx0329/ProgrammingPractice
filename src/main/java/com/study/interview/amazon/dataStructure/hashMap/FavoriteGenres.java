package com.study.interview.amazon.dataStructure.hashMap;

/*
    Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user
    has listened to as values.
    Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within
    that genre as values. The song can only belong to only one genre.
    The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the
    user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite
    genre if he/she has listened to the same number of songs per each of the genres.

    Example 1:
    Input:
    userSongs = {
        "David": ["song1", "song2", "song3", "song4", "song8"],
        "Emma":  ["song5", "song6", "song7"]
    },
    songGenres = {
        "Rock":    ["song1", "song3"],
        "Dubstep": ["song7"],
        "Techno":  ["song2", "song4"],
        "Pop":     ["song5", "song6"],
        "Jazz":    ["song8", "song9"]
    }

    Output: {
        "David": ["Rock", "Techno"],
        "Emma":  ["Pop"]
    }

    Explanation:
    David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
    Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.

    Example 2:
    Input:
    userSongs = {
        "David": ["song1", "song2"],
        "Emma":  ["song3", "song4"]
    },
    songGenres = {}

    Output: {
        "David": [],
        "Emma":  []
    }
 */

import java.util.*;

public class FavoriteGenres {
    public Map<String, List<String>> findFavoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> genresSong) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> songGenres = new HashMap<>();

        if(genresSong.isEmpty()) {
            for(String user: userSongs.keySet()) {
                result.put(user, Collections.emptyList());
            }
            return result;
        }
        for(String genre: genresSong.keySet()) {
            for (String song : genresSong.get(genre)) {
                songGenres.put(song, genre);
            }
        }

        for(String user: userSongs.keySet()) {
            Map<String, Integer> count  = new HashMap<>();
            int max = 0;
            result.put(user, new ArrayList<>());
            for(String song: userSongs.get(user)) {
                String genres = songGenres.get(song);
                count.put(genres, count.getOrDefault(genres, 0) + 1);
                max = Math.max(count.get(genres), max);
            }
            for(String key: count.keySet()) {
                if(count.get(key) == max) {
                    result.get(user).add(key);
                }
            }
        }
        return result;
    }
}
