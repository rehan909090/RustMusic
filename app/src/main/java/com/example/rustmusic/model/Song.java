package com.example.rustmusic.model;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public Song() {

    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    // Metode ini menghasilkan daftar lagu contoh
    public static List<Song> createDummySongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Song Title 1", "Artist 1"));
        songs.add(new Song("Song Title 2", "Artist 2"));
        songs.add(new Song("Song Title 3", "Artist 3"));
        // Tambahkan lagu lainnya sesuai kebutuhan
        return songs;
    }
}
