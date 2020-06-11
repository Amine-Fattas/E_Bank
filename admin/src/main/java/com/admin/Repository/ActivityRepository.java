package com.admin.Repository;

import com.admin.models.Activity;
import com.admin.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

}
