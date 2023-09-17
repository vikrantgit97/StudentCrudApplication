package com.crudapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Vikrant on 12-09-2023
 * @Project StudentRegistrationApplication
 */
@Entity
@Table(name="course_tbl")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(
            name="code",
            length = 10,
            nullable = false,
            unique = true)
    private String courseCode;

    @Column(
            name="name",
            length = 60,
            nullable = false,
            unique = true)
    private String courseName;

    @Column(
            name="note",
            length = 250,
            nullable = false)
    private String courseNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNote() {
        return courseNote;
    }

    public void setCourseNote(String courseNote) {
        this.courseNote = courseNote;
    }

    public Course() {
    }

    public Course(Long id, String courseCode, String courseName, String courseNote) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseNote = courseNote;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseNote='" + courseNote + '\'' +
                '}';
    }
}
