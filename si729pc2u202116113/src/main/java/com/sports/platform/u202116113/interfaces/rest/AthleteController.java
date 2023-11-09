package com.sports.platform.u202116113.interfaces.rest;

import com.sports.platform.u202116113.domain.model.queries.GetAthleteByIdQuery;
import com.sports.platform.u202116113.domain.service.AthleteCommandService;
import com.sports.platform.u202116113.domain.service.AthleteQueryService;
import com.sports.platform.u202116113.interfaces.rest.resources.AthleteResource;
import com.sports.platform.u202116113.interfaces.rest.resources.CreateAthleteResource;
import com.sports.platform.u202116113.interfaces.rest.transform.AthleteResourceFromEntityAssembler;
import com.sports.platform.u202116113.interfaces.rest.transform.CreateAthleteCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/athletes", produces = MediaType.APPLICATION_JSON_VALUE)
public class AthleteController {
    private final AthleteQueryService athletequeryService;
    private final AthleteCommandService athleteCommandService;

    public AthleteController(AthleteQueryService athletequeryService, AthleteCommandService athleteCommandService) {
        this.athletequeryService = athletequeryService;
        this.athleteCommandService = athleteCommandService;
    }

    @PostMapping
    public ResponseEntity<AthleteResource> CreateAthlete(@RequestBody CreateAthleteResource resource) {
        var createAthleteCommand = CreateAthleteCommandFromResourceAssembler.toCommandFromResource(resource);
        var athleteId = athleteCommandService.handle(createAthleteCommand);
        if (athleteId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getAthleteByIdQuery = new GetAthleteByIdQuery(athleteId);
        var athlete = athletequeryService.handle(getAthleteByIdQuery);
        if (athlete.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var athleteResource = AthleteResourceFromEntityAssembler.toResourceFromEntity(athlete.get());
        return new ResponseEntity<>(athleteResource, HttpStatus.CREATED);
    }
}
