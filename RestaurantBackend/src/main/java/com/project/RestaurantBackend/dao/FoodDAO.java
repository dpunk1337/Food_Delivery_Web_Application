package com.project.RestaurantBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.RestaurantBackend.entity.Food_Dish;

public interface FoodDAO extends JpaRepository<Food_Dish, Integer> {

}
