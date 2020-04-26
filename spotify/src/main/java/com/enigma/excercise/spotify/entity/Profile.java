package com.enigma.excercise.spotify.entity;

import com.enigma.excercise.spotify.enums.Gender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "mst_profile")
public class Profile {

    @Id
    @GeneratedValue(generator = "profile_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "profile_uuid", strategy = "uuid")
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private  String location;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "profile")
    private Account account;


    public Profile(String firstName,  Date birthDate) {
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return id.equals(profile.id) &&
                firstName.equals(profile.firstName) &&
                middleName.equals(profile.middleName) &&
                lastName.equals(profile.lastName) &&
                email.equals(profile.email) &&
                phone.equals(profile.phone) &&
                birthDate.equals(profile.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, email, phone, birthDate);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", location='" + location + '\'' +
                '}';
    }
}
