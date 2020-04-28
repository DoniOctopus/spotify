package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Profile;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.ProfileRepository;
import com.enigma.excercise.spotify.service.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class ProfileServiceDBImplTest {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileService profileService;

    @BeforeEach
    public void cleanUp() {
        profileRepository.deleteAll();
    }

    @Test
    void saveProfile_shouldAdd_1Data_inDB_whenProfileSaved() {
        Profile profile = new Profile("Danila",new Date());
        profileService.saveProfile(profile);
        assertEquals(1,profileRepository.findAll().size());
    }

    @Test
    void getProfile_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            profileService.getProfile("1");
        });
    }

    @Test
    void deleteProfile_shouldDelete_1Data_inDB_whenProfileDeleted() {
        Profile profile = new Profile("Danila",new Date());
        Profile profile1 = new Profile("Duta",new Date());
        profileRepository.save(profile);
        profileRepository.save(profile1);
        profileService.deletProfile(profile1.getId());
        assertEquals(1,profileRepository.findAll().size());
    }

    @Test
    void getAllProfile_shouldBe_2InDB_whenDataInDBIs_2() {
        Profile profile = new Profile("Danila",new Date());
        Profile profile1 = new Profile("Duta",new Date());
        profileRepository.save(profile);
        profileRepository.save(profile1);
        assertEquals(2, profileService.getAllProfile().size());
    }

    @Test
    void getProfileByField_shouldGetProfile_whenGivenSearchValue() {
        Profile profile = new Profile("Danila",new Date());
        Profile profile1 = new Profile("Duta",new Date());
        profileRepository.save(profile);
        profileRepository.save(profile1);
        Profile profile2=new Profile();
        profile2.setFirstName("Danila");
        profile2.setBirthDate(new Date());
        assertEquals(1, profileService.searchProfile(profile2, PageRequest.of(0,5)).getTotalElements());
    }

    @Test
    void searchArtist() {
    }
}