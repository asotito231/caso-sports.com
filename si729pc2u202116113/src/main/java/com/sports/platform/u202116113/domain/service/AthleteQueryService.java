package com.sports.platform.u202116113.domain.service;

import com.sports.platform.u202116113.domain.model.aggregates.Athlete;
import com.sports.platform.u202116113.domain.model.queries.GetAthleteByIdQuery;

import java.util.Optional;

public interface AthleteQueryService {
    Optional<Athlete> handle(GetAthleteByIdQuery query);
}
