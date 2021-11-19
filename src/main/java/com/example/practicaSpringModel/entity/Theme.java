package com.example.practicaSpringModel.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Them")
public class Theme extends Content{
}
