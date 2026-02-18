package com.dante.flames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dante.flames.dto.ApiResponse;
import com.dante.flames.dto.RelationshipRequest;
import com.dante.flames.dto.RelationshipResponse;
import com.dante.flames.service.FlamesService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FlamesController {

    @Autowired
    private FlamesService flamesService;

@PostMapping("/relationship")
public ApiResponse<RelationshipResponse> calculate(
        @RequestBody RelationshipRequest request) {

    RelationshipResponse response = flamesService.getRelationship(
            request.getName1(),
            request.getName2(),
            request.getMode()
    );

    return new ApiResponse<>(true, response);
}

}
