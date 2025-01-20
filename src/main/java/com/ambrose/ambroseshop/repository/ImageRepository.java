package com.ambrose.ambroseshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambrose.ambroseshop.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByProductId(Long id);
}
