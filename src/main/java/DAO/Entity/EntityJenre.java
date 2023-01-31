package DAO.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="app.Jenre")

public class EntityJenre {
    @Id()
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer ID;

    @Column(name="name")
    private String JenreName;
    public EntityJenre(){};

    public Integer getID() {
        return ID;
    }

    public String getJenreName() {
        return JenreName;
    }

    @Override
    public String toString() {
        return "EntityJenre{" +
                "ID=" + ID +
                ", JenreName='" + JenreName + '\'' +
                '}';
    }

    public void setJenreName(String jenreName) {
        JenreName = jenreName;
    }
}
