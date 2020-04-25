package com.enigma.excercise.spotify.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mst_account")
public class Account {

    @Id
    @GeneratedValue(generator = "account_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "account_uuid", strategy = "uuid")
    private String id;
    private Boolean isActive;

    @OneToMany(mappedBy = "author")
    @JsonBackReference
    private List<Playlist> playlists = new ArrayList<>();

    @OneToOne(mappedBy = "account")
    private Profile profile;

    @OneToOne(mappedBy = "owner")
    private Wallet wallet;


    public Account(Boolean isActive) {
        this.isActive = isActive;
    }

    public Account() {
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
