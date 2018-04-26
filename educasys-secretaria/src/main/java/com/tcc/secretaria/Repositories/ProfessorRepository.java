package com.tcc.secretaria.Repositories;

import com.tcc.secretaria.DTO.ProfessorDTO;
import com.tcc.secretaria.DTO.ProfessorListDTO;
import com.tcc.secretaria.database.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long>{
}
