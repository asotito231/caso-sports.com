package com.sports.platform.u202116113.interfaces.rest.transform;

import com.sports.platform.u202116113.domain.model.commands.CreateAthleteCommand;
import com.sports.platform.u202116113.interfaces.rest.resources.CreateAthleteResource;

public class CreateAthleteCommandFromResourceAssembler {
    public static CreateAthleteCommand toCommandFromResource(CreateAthleteResource resource) {
        return new CreateAthleteCommand(resource.firstName(), resource.lastName(), resource.birthDate(), resource.sport(), resource.address(), resource.city());
    }
}
