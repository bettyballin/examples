import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Data {
    // your existing stuff
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
    // getters and setters

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

@Entity
public class Person {
    // your existing stuff
    @OneToOne(mappedBy = "person")
    private Data data;
    // getters and setters

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}