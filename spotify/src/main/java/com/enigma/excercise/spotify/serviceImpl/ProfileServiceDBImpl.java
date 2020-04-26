package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Profile;
import com.enigma.excercise.spotify.repository.ProfileRepository;
import com.enigma.excercise.spotify.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceDBImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;


    @Override
    public void saveProfile(Profile profile) {
    profileRepository.save(profile);
    }

    @Override
    public Profile getProfile(String id) {
        Profile profile = profileRepository.findById(id).get();
        return profile;
    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public void deletProfile(String id) {
    profileRepository.deleteById(id);
    }
}
