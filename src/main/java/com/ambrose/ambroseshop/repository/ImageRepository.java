package com.ambrose.ambroseshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambrose.ambroseshop.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
