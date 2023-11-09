package com.sports.platform.u202116113.interfaces.rest.resources;

import java.util.Date;

public record AthleteResource(Long id, String name, Date birthDate, String sport, String address, String city) {
}
