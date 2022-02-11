package com.test.senioradom.senioradom.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "LATITUDE")
    private double latitude;
    @Column(name = "LONGITUDE")
    private double longitude;

}
