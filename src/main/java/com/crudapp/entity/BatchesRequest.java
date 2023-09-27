package com.crudapp.entity;

import jakarta.persistence.*;

/**
 * @author Vikrant on 13-09-2023
 * @Project StudentRegistrationApplication
 */

@Entity
@Table(
        name = "batches_req_tbl",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"institute_id_fk", "student_id_fk"})
        })
public class BatchesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "institute_id_fk")
    private Institute institute;

    @OneToOne
    @JoinColumn(name = "student_id_fk")
    private Student student;

    @Column(name = "batch_status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BatchesRequest() {
    }

    public BatchesRequest(Long id, Institute institute, Student student, String status) {
        this.id = id;
        this.institute = institute;
        this.student = student;
        this.status = status;
    }

    @Override
    public String toString() {
        return "BatchesRequest{" +
                "id=" + id +
                ", institute=" + institute +
                ", student=" + student +
                ", status='" + status + '\'' +
                '}';
    }
}
