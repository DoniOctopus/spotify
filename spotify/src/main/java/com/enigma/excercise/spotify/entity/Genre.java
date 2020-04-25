package com.enigma.excercise.spotify.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mst_genre")
public class Genre {

    @Id
    @GeneratedValue(generator = "genre_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "genre_uuid", strategy = "uuid")
    private Integer id;
    private  String name;

    @OneToMany(mappedBy = "genre")
    @JsonBackReference
    private List<Song> songs = new ArrayList<>();


    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
