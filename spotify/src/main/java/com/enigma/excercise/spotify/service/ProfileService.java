package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Profile;

import java.util.List;

public interface ProfileService {
    public void saveProfile(Profile profile);
    public Profile getProfile(String id);
    public List<Profile> getAllProfile();
    public void deletProfile(String id);


}
