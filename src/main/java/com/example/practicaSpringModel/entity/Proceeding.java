package com.example.practicaSpringModel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "proceedings")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proceeding {
    //@OneToMany(cascade = {CascadeType})
    //@Column(name = "course")
    //private List<Course> courseList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String registrationDate;
    private int qualification;
    private String endDate;

    public Proceeding() {

    }

    public Proceeding(Integer id, String registrationDate, int qualification, String endDate) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.qualification = qualification;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
