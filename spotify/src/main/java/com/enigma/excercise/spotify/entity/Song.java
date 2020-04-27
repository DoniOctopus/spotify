package com.enigma.excercise.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_song")
public class Song {

    @Id
    @GeneratedValue(generator = "song_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "song_uuid", strategy = "uuid")
    private String id;
    private String title;
    private Integer releaseYear;
    private Integer duration;
    private Double price;


    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonIgnoreProperties("songs")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonIgnoreProperties("songs")
    private Album album;


    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties("songs")
    private Artist artist;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mst_song_has_playlist",joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "playlist_id")})
    private List<Playlist> playlists = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    @JsonIgnoreProperties("song")
    private List<Transaction> transactions = new ArrayList<>();


    public Song(String title, Integer releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;

    }

    public Song() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return id.equals(song.id) &&
                title.equals(song.title) &&
                releaseYear.equals(song.releaseYear) &&
                duration.equals(song.duration) &&
                price.equals(song.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseYear, duration, price);
    }
}
