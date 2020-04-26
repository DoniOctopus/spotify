package com.enigma.excercise.spotify.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_genre")
public class Genre {


    @Id
    @GeneratedValue(generator = "genre_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "genre_uuid", strategy = "uuid")
    private String id;
    private  String name;

    @OneToMany(mappedBy = "genre")
    private List<Song> songs = new ArrayList<>();


    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return id.equals(genre.id) &&
                name.equals(genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
