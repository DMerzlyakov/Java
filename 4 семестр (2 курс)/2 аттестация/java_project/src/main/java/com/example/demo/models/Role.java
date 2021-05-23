package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "S_ROLE")
//@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<User> users;


    public Role(String name) {
        this.name = name;
    }

    public Role() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Role{" +
                "rowId=" + rowId +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}