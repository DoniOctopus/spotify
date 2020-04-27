package com.enigma.excercise.spotify.entity;

import com.enigma.excercise.spotify.enums.Gender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_album")
public class Album {

    @Id
    @GeneratedValue(generator = "album_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "album_uuid", strategy = "uuid")
    private String id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Double discount;
    private String image;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();

    public Album(String title) {
        this.title = title;
    }

    public Album() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return id.equals(album.id) &&
                title.equals(album.title) &&
                description.equals(album.description) &&
                releaseYear.equals(album.releaseYear) &&
                discount.equals(album.discount) &&
                image.equals(album.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, releaseYear, discount, image);
    }
}
