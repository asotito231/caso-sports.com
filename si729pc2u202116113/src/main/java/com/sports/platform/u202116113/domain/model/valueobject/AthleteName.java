package com.sports.platform.u202116113.domain.model.valueobject;


import jakarta.persistence.Embeddable;


@Embeddable
public record AthleteName(String firstName, String lastName){
    public AthleteName(){
        this(null, null);
    }
    public AthleteName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

}
