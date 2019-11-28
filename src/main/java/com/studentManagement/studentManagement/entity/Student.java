package com.studentManagement.studentManagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.File;

//Student Id, name, surname, mobile phone number, city, district and description fields are enough for registration
@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    @Setter
    @Size(min=2,max=25,message = "Minimum name length: 2 characters and maximum 25 characters")
    @Column(nullable = false)
    private String name;

    @Size(min=2,max=20,message = "Minimum surname length: 2 characters and maximum 20 characters")
    @Column(nullable = false)
    private String surname;

    @Size(min=9,max=14,message = "Minimum number length: 10 characters and maximum 13 characters ")
    private String phoneNumber;

    @Size(min=2,max = 30,message = "Minimum city length: 2 characters and maximum 30 characters")
    private String city;


    @Size(min=2,max = 30,message = "Minimum district length: 2 characters and maximum 30 characters")
    private String district;

    private String description;

    private File file;

    public Student(int id,String name,  String surname,   String phoneNumber,  String city, String district, String description) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.district = district;
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
