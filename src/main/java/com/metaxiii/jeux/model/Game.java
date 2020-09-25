package com.metaxiii.jeux.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @OneToOne
    @JoinColumn(name = "SUPPORT")
    private Support support;

    private boolean available;

    private boolean ended;

    private boolean progress;
}
