package DAO.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntitySinger {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer ID;
    @Column(name="name")
    private String SingerName;
    public EntitySinger(){};

    public Integer getID() {
        return ID;
    }

    public String getSingerName() {
        return SingerName;
    }

    @Override
    public String toString() {
        return "EntitySinger{" +
                "ID=" + ID +
                ", SingerName='" + SingerName + '\'' +
                '}';
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }
}
