package org.example.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="EVENT")
public class Event {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    private String text;
    private Date dtCreate;

    public Event() {
    }

    public Event(String text, Date dtCreate) {
        this.text = text;
        this.dtCreate = dtCreate;
    }

    public String getText() {
        return text;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public Long getId() {
        return id;
    }
}
