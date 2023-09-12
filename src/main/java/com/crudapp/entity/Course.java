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
}
