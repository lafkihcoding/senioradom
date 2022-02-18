package com.test.senioradom.senioradom.dao;

import lombok.*;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "LATITUDE")
    private double latitude;

    @NotNull
    @Column(name = "LONGITUDE")
    private double longitude;

    @NotNull
    @Column(name = "CHECKED")
    private boolean checked;

}
