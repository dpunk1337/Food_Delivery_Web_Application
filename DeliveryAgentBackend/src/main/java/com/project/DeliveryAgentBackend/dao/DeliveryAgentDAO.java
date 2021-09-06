package com.project.DeliveryAgentBackend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.DeliveryAgentBackend.entity.DeliveryAgent;

@Repository
public interface DeliveryAgentDAO extends JpaRepository<DeliveryAgent, Integer> {
}
