package com.smhrd.dream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.dream.entity.PlantList;

@Repository
public interface PlantListRepository extends JpaRepository<PlantList, Long>{

}
