package com.zyapaar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zyapaar.model.ImageData;

@Repository
public interface ImageDataRepository extends JpaRepository<ImageData, Long>{

	Optional<ImageData> findByName(String name);
	
}
