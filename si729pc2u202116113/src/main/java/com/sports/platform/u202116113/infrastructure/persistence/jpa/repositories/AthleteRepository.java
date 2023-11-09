package com.sports.platform.u202116113.infrastructure.persistence.jpa.repositories;

import com.sports.platform.u202116113.domain.model.aggregates.Athlete;
import com.sports.platform.u202116113.domain.model.valueobject.AthleteName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Optional<Athlete> findByNameAndBirthDateAndSport(AthleteName Name, Date birthDate, String sport);
    Optional<Athlete> findByAddress(String address);
}
