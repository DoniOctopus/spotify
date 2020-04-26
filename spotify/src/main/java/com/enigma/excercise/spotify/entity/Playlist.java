package com.enigma.excercise.spotify.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_playlist")
public class Playlist {

    @Id
    @GeneratedValue(generator = "playlist_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "playlist_uuid", strategy = "uuid")
    private String id;
    private String name;
    private Boolean isPublic;

    @ManyToMany(mappedBy = "playlists", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("playlists")
    private List<Song> songs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("playlist")
    private Account author;

    public Playlist(String name, Boolean isPublic) {
        this.name = name;
        this.isPublic = isPublic;
    }

    public Playlist() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }



    @Override
    public String
    toString() {
        return "Playlist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist)) return false;
        Playlist playlist = (Playlist) o;
        return id.equals(playlist.id) &&
                name.equals(playlist.name) &&
                isPublic.equals(playlist.isPublic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isPublic);
    }
}
