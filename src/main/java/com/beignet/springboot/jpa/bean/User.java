package com.beignet.springboot.jpa.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @NotEmpty
    private  String UserName;
    private Integer age;
    @Column(columnDefinition = "enum('男','女')")
    private  String sex;
}
