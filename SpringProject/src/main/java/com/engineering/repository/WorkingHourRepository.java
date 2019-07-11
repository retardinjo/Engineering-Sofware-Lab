package com.engineering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engineering.model.WorkingHour;


@Repository
public interface WorkingHourRepository extends JpaRepository<WorkingHour, Integer> {

}
