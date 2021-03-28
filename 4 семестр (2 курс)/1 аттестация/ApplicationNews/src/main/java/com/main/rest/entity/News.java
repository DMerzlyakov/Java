package com.main.rest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class News {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfUpdate() {
        return DateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        DateOfUpdate = dateOfUpdate;
    }

    public Date getDateOfCreate() {
        return DateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        DateOfCreate = dateOfCreate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date DateOfUpdate;
    private Date DateOfCreate;
    private String header;
    private String text;
    private String categoryName;

    }
