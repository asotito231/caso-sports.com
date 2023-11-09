package com.sports.platform.u202116113.domain.model.aggregates;


import com.sports.platform.u202116113.domain.model.valueobject.AthleteName;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

@Entity
public class Athlete extends AbstractAggregateRoot<Athlete> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Embedded
    private AthleteName name;
    @Getter
    private Date birthDate;
    @Getter
    private String sport;
    @Getter
    private String address;
    @Getter
    private String city;

    public Athlete(AthleteName name, Date birthDate, String sport, String address, String city) {
        this.name = name;
        this.birthDate = birthDate;
        this.sport = sport;
        this.address = address;
        this.city = city;
    }

    public Athlete(String firstName, String lastName, Date birthDate, String sport, String address, String city) {
        this.name= new AthleteName(firstName, lastName);
        this.birthDate = birthDate;
        this.sport = sport;
        this.address = address;
        this.city = city;
    }

    public Athlete(){

    }

    public String getName() {
        return this.name.fullName();
    }
}
