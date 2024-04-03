package com.utndds.correlativas.persistencia;

import com.utndds.correlativas.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MateriaRepository extends JpaRepository<Materia,Long> {
}
