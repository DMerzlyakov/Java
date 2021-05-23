package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "S_STATUS")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    @Column(nullable = false)
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private Set<StatusTask> statusTasks;

    public Status() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "rowId=" + rowId +
                ", name='" + name + '\'' +
                ", statusTasks=" + statusTasks +
                '}';
    }
}