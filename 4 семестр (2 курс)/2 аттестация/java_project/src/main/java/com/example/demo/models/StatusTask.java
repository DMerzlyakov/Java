package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "S_STATUS_WORK")
public class StatusTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    @Column(nullable = false)
    private String name;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "statusTask")
    private Set<Task> task;

    public StatusTask(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusTask() {

    }

    @Override
    public String toString() {
        return "StatusTask{" +
                "rowId=" + rowId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", task=" + task +
                '}';
    }
}