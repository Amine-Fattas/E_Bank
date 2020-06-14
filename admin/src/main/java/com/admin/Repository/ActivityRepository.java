package com.admin.Repository;

import com.admin.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

    List<Activity> findFirst20ByOrderByIdDesc();
}
