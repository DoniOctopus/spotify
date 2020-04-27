package com.enigma.excercise.spotify.entity;

import com.enigma.excercise.spotify.enums.Gender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_artist")
public class Artist {

    @Id
    @GeneratedValue(generator = "artist_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "artist_uuid", strategy = "uuid")
    private String id;
    private String name;


    private Integer debutYear;

    @Enumerated(EnumType.STRING)
    private Gender Gender;
    private  String biography;
    private String photo;

    @OneToMany(mappedBy = "artist")
    private List<Song>songs = new ArrayList<>();

    public Artist() {
    }

    public Artist(String name, Integer debutYear) {
        this.name = name;
        this.debutYear = debutYear;
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

    public Integer getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(Integer debutYear) {
        this.debutYear = debutYear;
    }

    public com.enigma.excercise.spotify.enums.Gender getGender() {
        return Gender;
    }

    public void setGender(com.enigma.excercise.spotify.enums.Gender gender) {
        Gender = gender;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", debutYear=" + debutYear +
                ", Gender=" + Gender +
                ", biography='" + biography + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return id.equals(artist.id) &&
                name.equals(artist.name) &&
                debutYear.equals(artist.debutYear) &&
                Gender == artist.Gender &&
                biography.equals(artist.biography) &&
                photo.equals(artist.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, debutYear, Gender, biography, photo);
    }
}
