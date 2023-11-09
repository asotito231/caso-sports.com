package com.sports.platform.u202116113.domain.model.commands;

import java.util.Date;

public record CreateAthleteCommand(String firstName, String lastName, Date birthDate, String sport, String address, String city) {
}
