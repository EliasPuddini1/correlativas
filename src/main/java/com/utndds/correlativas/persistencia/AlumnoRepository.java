package com.utndds.correlativas.persistencia;

import com.utndds.correlativas.modelos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
}
