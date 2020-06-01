package com.admin.Repository;

import com.admin.models.Client;
import com.admin.models.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Integer> {

}
