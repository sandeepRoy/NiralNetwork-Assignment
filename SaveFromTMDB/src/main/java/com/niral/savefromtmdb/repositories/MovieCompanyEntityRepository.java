package com.niral.savefromtmdb.repositories;

import com.niral.savefromtmdb.entities.MovieCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCompanyEntityRepository extends JpaRepository<MovieCompanyEntity, Integer> {
}
