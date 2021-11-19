package com.example.practicaSpringModel.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name = "proceedings")
    private List<Proceeding> proceedingList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String dni;
    private String name;
    private String lastName;
    private String address;
    private String mail;


    public Student(Integer id, String dni, String name, String lastName, String address, String mail) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.mail = mail;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
