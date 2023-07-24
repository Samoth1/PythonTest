package com.tingeso.pythontestservice.repositories;

import com.tingeso.pythontestservice.entities.PythonTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PythonTestRepository extends JpaRepository<PythonTestEntity, Integer> {
    @Query("select p.ident from PythonTestEntity p where p.dificultad = :dificultad")
    ArrayList<Integer> findIdsByDificultad(@Param("dificultad") String dificultad);

    PythonTestEntity findByDificultadEquals(String dificultad);
    PythonTestEntity findByIdent(Integer id);

}
