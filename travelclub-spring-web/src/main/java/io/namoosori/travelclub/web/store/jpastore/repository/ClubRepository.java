package io.namoosori.travelclub.web.store.jpastore.repository;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {
    List<TravelClubJpo> findAllByName(String name);
}
