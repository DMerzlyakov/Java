package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "S_TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    private String title;
    private String body;


    public Task(){

    }

    public Task(String title, String body){
        this.title = title;
        this.body = body;
    }



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "developer_id", nullable = true)
    private User developer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "analyst_id", nullable = true)
    private User analyst;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tester_id", nullable = true)
    private User tester;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = true)
    private StatusTask statusTask;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Task{" +
                "rowId=" + rowId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", developer=" + developer +
                ", analyst=" + analyst +
                ", tester=" + tester +
                ", statusTask=" + statusTask +
                '}';
    }
}