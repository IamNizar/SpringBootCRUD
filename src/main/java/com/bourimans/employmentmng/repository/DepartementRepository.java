package com.bourimans.employmentmng.repository;

import com.bourimans.employmentmng.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartementRepository extends JpaRepository<Departement,Integer> {
    @Query(value = "select * from Departement", nativeQuery = true)
    List<Departement> LoadDeptList();

   /* @Query(value = "select d from Departement d where d.id=:dept_id")
    Departement DepartementByEmployeeId(@Param("dept_id") int id);*/

}