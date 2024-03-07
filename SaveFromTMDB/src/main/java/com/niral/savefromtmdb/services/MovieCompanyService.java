package com.niral.savefromtmdb.services;

import com.niral.savefromtmdb.constants.MovieCompanyConstants;
import com.niral.savefromtmdb.dtos.MovieCompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieCompanyService {
    @Autowired
    private WebClient movieCompanyClient;

    public MovieCompanyDto getMovieCompany(String apiKey, Integer company_id) {
        String bearer_token = "Bearer " + apiKey;
        MovieCompanyDto movieCompanyDto = movieCompanyClient
                .get()
                .uri(MovieCompanyConstants.GET_COMPANY_DETAILS, company_id)
                .header("Authorization", bearer_token)
                .retrieve()
                .bodyToMono(MovieCompanyDto.class)
                .block();

        return movieCompanyDto;
    }
}
