package com.crudapp.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */


@Entity
@Table(name = "emptbl")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_sal")
    private Double empSal;

    @Column(name = "emp_dept")
    private String empDept;

    @Column(name = "esp_address")
    private String empAddr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr;
    }

    public Employee() {
    }

    public Employee(Integer id, String empName, Double empSal, String empDept, String empAddr) {
        this.id = id;
        this.empName = empName;
        this.empSal = empSal;
        this.empDept = empDept;
        this.empAddr = empAddr;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empSal=" + empSal +
                ", empDept='" + empDept + '\'' +
                ", empAddr='" + empAddr + '\'' +
                '}';
    }
}