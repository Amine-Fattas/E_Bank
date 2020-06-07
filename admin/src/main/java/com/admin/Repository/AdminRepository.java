package com.admin.Repository;

import com.admin.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long>{


    Admin findByUserName(String username);
}
