package com.sports.platform.u202116113.domain.service;

import com.sports.platform.u202116113.domain.model.commands.CreateAthleteCommand;

public interface AthleteCommandService {
    Long handle(CreateAthleteCommand command);
}
