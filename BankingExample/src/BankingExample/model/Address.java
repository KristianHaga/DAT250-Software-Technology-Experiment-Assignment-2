package BankingExample.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String street;
    private int number;

    @ManyToMany
    @JoinTable(name = "joined_person_address",
            joinColumns = @JoinColumn(name = "address_fk"),
            inverseJoinColumns = @JoinColumn(name = "person_fk"))
    private List<Person> people;

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
