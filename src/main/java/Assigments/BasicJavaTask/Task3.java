package Assigments.BasicJavaTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Song> songList = new ArrayList<>();
        Song song = new Song("title-1", 5 , Arrays.asList("pop", "rock"));
        Song song1 = new Song("title-2", 6 , Arrays.asList("pop"));
        Song song2 = new Song("title-3", 4 , Arrays.asList("rock"));
        songList.add(song);
        songList.add(song1);
        songList.add(song2);
        genreMaxPlayedgeneral(songList);
//        Set<Map.Entry<String, Song>> entries = genreMaxPlayedSong(songList).entrySet();
//        //System.out.println(entries);
//
//        for (Map.Entry entry : entries) {
//            Song songget = (Song) entry.getValue();
//            System.out.println(entry.getKey() + " -> " + songget.getTitle() + "," + songget.getPlayCount());
//        }
    }
    public static HashMap<String,Song> genreMaxPlayedgeneral(List<Song> songs) {
        HashMap<String, Song> map = new HashMap<>();
        for (Song song : songs) {
            List<String> genres = song.getGenre();
            System.out.println("general:"+genres);
            for (String genre : genres) {
                if (map.containsKey(genre)) {
                    Song preSong = map.get(genre);
                    if (preSong.getPlayCount() < song.getPlayCount()) {
                        map.put(genre, song);
                    }
                } else {
                    map.put(genre, song);
                }
            }
        }
        return map;
        //System.out.println(map);
    }

    public static HashMap<String,Song> genreMaxPlayedSong(List<Song> songs) {
        HashMap<String, Song> map = new HashMap<>();
        for (Song song : songs) {
            List<String> genres = song.getGenre();
            for (String genre : genres) {
                if (map.containsKey(genre)) {
                    Song preSong = map.get(genre);
                    if (preSong.getPlayCount() < song.getPlayCount()) {
                        map.put(genre, song);
                    }
                } else {
                    map.put(genre, song);
                }
            }
        }
        return map;
        //System.out.println(map);
    }
}

class Song {
    String title;
    int playCount;
    List<String> genre;

    public Song(String title, int playCount, List<String> genre) {
        this.title = title;
        this.playCount = playCount;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<String> getGenre() {
        return genre;
    }

}
/*
Suppose you are given a List of songs.
genre = pop, rock,
write a function that returns for each genre the song that is played
the maximum number of times.
song = {"title-1", 5 , ["pop","rock"]}, {"title-2",6,["pop"]}, {"title-3",4,["rock"]}
output:
pop -> title-2,6
rock -> title-1, 5
*/