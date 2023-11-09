package com.sports.platform.u202116113.interfaces.rest.resources;

import java.util.Date;

public record CreateAthleteResource(String firstName, String lastName, Date birthDate, String sport, String address, String city) {

}
