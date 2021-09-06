package com.project.RestaurantBackend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.RestaurantBackend.entity.Restaurant;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Integer> {
}
