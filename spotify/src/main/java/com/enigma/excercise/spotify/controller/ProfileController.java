package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Profile;
import com.enigma.excercise.spotify.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile/{id}")
    public Profile getProfileById(@PathVariable String id){
        return profileService.getProfile(id);
    }

    @PostMapping("/profile")
    public void saveProfile(@RequestBody Profile profile){
        profileService.saveProfile(profile);
    }

    @DeleteMapping("profile/{id}")
    public void deletProfile(@PathVariable String id){
        profileService.deletProfile(id);
    }

    @GetMapping("/profile")
    public Page<Profile> searchByTitle(@RequestBody Profile searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return profileService.searchProfile(searchForm, pageable);
    }
}
