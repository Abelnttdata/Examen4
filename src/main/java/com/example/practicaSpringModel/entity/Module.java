package com.example.practicaSpringModel.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mod")
public class Module  extends Content{

}
