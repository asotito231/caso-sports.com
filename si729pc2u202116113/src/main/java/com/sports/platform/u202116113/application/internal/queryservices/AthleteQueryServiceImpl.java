package com.sports.platform.u202116113.application.internal.queryservices;

import com.sports.platform.u202116113.domain.model.aggregates.Athlete;
import com.sports.platform.u202116113.domain.model.queries.GetAthleteByIdQuery;
import com.sports.platform.u202116113.domain.service.AthleteQueryService;
import com.sports.platform.u202116113.infrastructure.persistence.jpa.repositories.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AthleteQueryServiceImpl implements AthleteQueryService {
    private final AthleteRepository athleteRepository;

    public AthleteQueryServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public Optional<Athlete> handle(GetAthleteByIdQuery query) {
        return athleteRepository.findById(query.id());
    }
}
