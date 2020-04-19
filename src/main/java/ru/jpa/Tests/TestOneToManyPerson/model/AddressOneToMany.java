package ru.jpa.Tests.TestOneToManyPerson.model;

import ru.helpclasses.Randomizer;

import javax.persistence.*;

@Entity
@Table(name="addressOtM")
public class AddressOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    private String street;
    private String city;
    private String zip;
    private String country;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id",referencedColumnName = "person_id")
    private PersonOneToMany person;

    public AddressOneToMany(){
        street = Randomizer.randomStreet();
        city = Randomizer.randomCity();
        zip = Randomizer.randomZip();
        country = Randomizer.randomCountry();
    }

    public PersonOneToMany getPerson() {
        return person;
    }

    public AddressOneToMany setPerson(PersonOneToMany person) {
        this.person = person;
        return this;
    }

    public int setPerson_id(int person_id) {
        return person_id;
    }

    public int getPerson_id() {
        return person.getPerson_id();
    }

    public int getAddress_id() {
        return address_id;
    }

    public AddressOneToMany setAddress_id(int address_id) {
        this.address_id = address_id;
        return this;
    }

    @Override
    public String toString() {
        return " street = " +street +
                " street = " + street +
                " city = " + city +
                " zip = " + zip +
                " country = " + country;
    }

}
