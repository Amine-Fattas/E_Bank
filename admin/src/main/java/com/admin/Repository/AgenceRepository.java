package com.admin.Repository;

import com.admin.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {

    Agence findByNomAgence(String id);

    @Query(value="SELECT num_agence from agence order by num_agence desc LIMIT 1",nativeQuery=true)
    public Integer lastcodeguichet();

}