package DAO.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class EntityVote {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer ID;
    @Column(name="app.Artist.id")
    private Integer Singers;
    @Column(name="app.Jenre.id")
    private Integer Jenres;
    @Column(name="infarmation-mail")
    private String Information;
    public  EntityVote(){};

    public Integer getID() {
        return ID;
    }

    public Integer getSingers() {
        return Singers;
    }

    public Integer getJenres() {
        return Jenres;
    }

    public String getInformation() {
        return Information;
    }
}
