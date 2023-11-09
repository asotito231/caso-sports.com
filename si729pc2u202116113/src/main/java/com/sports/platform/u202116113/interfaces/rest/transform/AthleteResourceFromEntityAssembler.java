package com.sports.platform.u202116113.interfaces.rest.transform;

import com.sports.platform.u202116113.domain.model.aggregates.Athlete;
import com.sports.platform.u202116113.interfaces.rest.resources.AthleteResource;

public class AthleteResourceFromEntityAssembler {
    public static AthleteResource toResourceFromEntity(Athlete athlete) {
        return new AthleteResource(athlete.getId(), athlete.getName(), athlete.getBirthDate(), athlete.getSport(), athlete.getAddress(), athlete.getCity());
    }
}
