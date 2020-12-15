package com.sem.demo.model;

import javax.persistence.*;

@Entity
@Table(name="questions")

public class Question extends AuditModel{
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 100
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void  setDescription(String description){
        this.description = description;
    }

    public  void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return "Question{"+
                "id=" + id +
                ", description='"+description+'\''+"}";
    }
}
