package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfileService {
    public void saveProfile(Profile profile);
    public Profile getProfile(String id);
    public List<Profile> getAllProfile();
    public void deletProfile(String id);
    public Page<Profile> searchProfile(Profile profile, Pageable pageable);


}
