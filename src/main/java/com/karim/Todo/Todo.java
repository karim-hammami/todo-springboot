package com.karim.Todo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public  class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESC")
    private String desc;
    @Column(name = "STATUS")
    private String status;

    public Todo() {
    }

    public Todo(int id, String title, String desc, String status) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = status;
    }
   
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
       int hash = 7;
       hash = 79 * hash + Objects.hashCode(this.id);
       hash = 79 * hash + Objects.hashCode(this.title);
       hash = 79 * hash + Objects.hashCode(this.desc);
       hash = 79 * hash + Objects.hashCode(this.status);
       return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Todo other = (Todo) obj;

        if(!Objects.equals(this.title, other.title)) {
            return false;
        }

        if(!Objects.equals(this.desc, other.desc)) {
            return false;
        }

        if(!Objects.equals(this.status, other.status)) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
       final StringBuilder sb = new StringBuilder("Todo{");
       sb.append("id=").append(id);
       sb.append(", title='").append(title).append('\'');
       sb.append(", desc='").append(desc).append('\'');
       sb.append(", status'").append(status).append('\'');
       sb.append('}');
       return sb.toString();
    }
}
