package com.example.preproject231.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    //2. Должен быть класс User с произвольными полями (id, name и т.п.).
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String tp;

    public User() {
    }

    public User(int id, String name, String tp) {
        this.id = id;
        this.name = name;
        this.tp = tp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

}
