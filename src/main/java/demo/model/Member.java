package demo.model;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Meetup meetup;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meetup getMeetup() {
        return meetup;
    }
}
