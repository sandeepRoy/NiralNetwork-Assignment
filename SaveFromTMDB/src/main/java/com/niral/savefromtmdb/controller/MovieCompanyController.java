package com.niral.savefromtmdb.controller;

import com.niral.savefromtmdb.dtos.MovieCompanyDto;
import com.niral.savefromtmdb.entities.MovieCompanyEntity;
import com.niral.savefromtmdb.repositories.MovieCompanyEntityRepository;
import com.niral.savefromtmdb.services.MovieCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Hey!!
 * Don't want to generate API Key, No worries, Use this -
 *
 * eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNWE4ZjI4YzQwZjg4NjNhYjM4NjY0OWRlOWJjMTA5NCIsInN1YiI6IjY1YjkxNDU0MmYyNjZiMDE3ZGUxYjFmZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.o9--_gZe49vYGaHmwczZzNOTKEcynChfEyZl_09f1o0
 *
 */

@RestController
public class MovieCompanyController {
    @Autowired
    private MovieCompanyService movieCompanyService;

    @Autowired
    private MovieCompanyEntityRepository movieCompanyEntityRepository;

    @GetMapping("/company/{id}")

    public ResponseEntity<MovieCompanyEntity> getMovieCompany(@RequestParam String apiKey, @RequestParam Integer company_id) {
        MovieCompanyDto movieCompanyDto = movieCompanyService.getMovieCompany(apiKey, company_id);

        MovieCompanyEntity movieCompanyEntity = new MovieCompanyEntity();
        movieCompanyEntity.setDescription(movieCompanyDto.getDescription());
        movieCompanyEntity.setHeadquarters(movieCompanyDto.getHeadquarters());
        movieCompanyEntity.setHomepage(movieCompanyDto.getHomepage());
        movieCompanyEntity.setId(movieCompanyDto.getId());
        movieCompanyEntity.setLogo_path(movieCompanyDto.getLogo_path());
        movieCompanyEntity.setName(movieCompanyDto.getName());
        movieCompanyEntity.setOrigin_country(movieCompanyDto.getOrigin_country());
        movieCompanyEntity.setParent_company(movieCompanyDto.getParent_company());

        MovieCompanyEntity saved = movieCompanyEntityRepository.save(movieCompanyEntity);

        return new ResponseEntity<MovieCompanyEntity>(saved, HttpStatus.OK);
    }
}
