package com.sem.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createAt", "updateAt"},
        allowGetters = true
)




public abstract class AuditModel implements Serializable {
    @Column(name="create_at", nullable = false,updatable = false )
    @CreatedDate
    private Date createDate;

    @Column(name="update_at", nullable = false)
    @LastModifiedDate
    private Date updateDate;

    public Date getCreateDate(){
        return createDate;
    }

    public Date getUpdateDate(){
        return updateDate;
    }

}
