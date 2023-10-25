package com.smhrd.dream.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.dream.entity.PlantList;

@Repository
public interface PlantListRepository extends JpaRepository<PlantList, Long>{

	List<Optional<PlantList>> findAllById(Long id);

}
