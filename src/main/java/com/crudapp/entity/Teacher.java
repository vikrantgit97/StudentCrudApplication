package com.crudapp.entity;

import jakarta.persistence.*;

/**
 * @author Vikrant on 12-09-2023
 * @Project StudentRegistrationApplication
 */
@Entity
@Table(name="teacher_tbl")
public class Teacher {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="gender")
    private String gender;

    @Column(name="mobile")
    private String mobile;

    @Column(name="note")
    private String note;

    @Column(name="photo_location")
    private String photoLoc;

    //----------Association Mapping------------------
    @ManyToOne
    @JoinColumn(name="course_id_fk_col")
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhotoLoc() {
        return photoLoc;
    }

    public void setPhotoLoc(String photoLoc) {
        this.photoLoc = photoLoc;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher() {
    }

    public Teacher(Long id, String firstName, String lastName, String email, String address, String gender, String mobile, String note, String photoLoc, Course course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.mobile = mobile;
        this.note = note;
        this.photoLoc = photoLoc;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", note='" + note + '\'' +
                ", photoLoc='" + photoLoc + '\'' +
                ", course=" + course +
                '}';
    }
}
