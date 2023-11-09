package com.sports.platform.u202116113.application.internal.commandservices;

import com.sports.platform.u202116113.domain.model.aggregates.Athlete;
import com.sports.platform.u202116113.domain.model.commands.CreateAthleteCommand;
import com.sports.platform.u202116113.domain.model.valueobject.AthleteName;
import com.sports.platform.u202116113.domain.service.AthleteCommandService;
import com.sports.platform.u202116113.infrastructure.persistence.jpa.repositories.AthleteRepository;
import org.springframework.stereotype.Service;

@Service
public class AthleteCommandServiceImpl implements AthleteCommandService {

    private final AthleteRepository athleteRepository;

    public AthleteCommandServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public Long handle(CreateAthleteCommand command) {
        var fullName = new AthleteName(command.firstName(), command.lastName());

        athleteRepository.findByNameAndBirthDateAndSport(fullName, command.birthDate(), command.sport()).map(athlete -> {
            throw new IllegalArgumentException("Athlete already exists");
        });

        athleteRepository.findByAddress(command.address()).map(athlete -> {
            throw new IllegalArgumentException("Address already exists");
        });

        var athlete = new Athlete(
                command.firstName(),
                command.lastName(),
                command.birthDate(),
                command.sport(),
                command.address(),
                command.city()
        );
        athleteRepository.save(athlete);
        return athlete.getId();
    }


}
