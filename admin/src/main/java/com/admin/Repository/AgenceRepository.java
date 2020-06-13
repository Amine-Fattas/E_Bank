package com.admin.Repository;

import com.admin.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {

    Agence findByNomAgence(String id);
    Optional<Agence> findById(Integer id);

    @Query(value="SELECT num_agence from agence order by num_agence desc LIMIT 1",nativeQuery=true)
    public Integer lastcodeguichet();

    @Query(value="select * from agence a where a.nom_agence like %:keyword% ",nativeQuery=true)
    List<Agence> findByKeyword(@Param("keyword") String keyword);

}