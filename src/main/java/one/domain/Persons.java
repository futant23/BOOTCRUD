/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author b1050502
 */
@XmlRootElement(name = "persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persons {
    
    @XmlElement(name = "person", type = Person.class)
    private List<Person> persons;

    public Persons() {}

    public Persons(List<Person> persons) {
        this.persons = persons;
    }
    
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
    
    
}
