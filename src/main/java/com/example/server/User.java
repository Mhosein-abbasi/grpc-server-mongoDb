package com.example.server;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String name;
    private String family;
    private Date updatedAt;
    private Date createAt;
    private Boolean isDeleted;

    public User(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }
}
