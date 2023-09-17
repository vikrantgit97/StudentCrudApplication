package com.crudapp.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Vikrant on 12-09-2023
 * @Project StudentRegistrationApplication
 */

@Entity
@Table(name="institute_tbl")
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="teacher_id_fk")
    private Teacher teacher;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name="date")
    private Date date;

    @Column(name="batches")
    private Integer noOfBatches;

    @Column(name="details")
    private String details;

    @Column(name="fee")
    private Double fee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNoOfBatches() {
        return noOfBatches;
    }

    public void setNoOfBatches(Integer noOfBatches) {
        this.noOfBatches = noOfBatches;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Institute() {
    }

    public Institute(Long id, Teacher teacher, Date date, Integer noOfBatches, String details, Double fee) {
        this.id = id;
        this.teacher = teacher;
        this.date = date;
        this.noOfBatches = noOfBatches;
        this.details = details;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", date=" + date +
                ", noOfBatches=" + noOfBatches +
                ", details='" + details + '\'' +
                ", fee=" + fee +
                '}';
    }
}