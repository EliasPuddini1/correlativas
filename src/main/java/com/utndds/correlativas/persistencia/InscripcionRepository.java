package com.utndds.correlativas.persistencia;

import com.utndds.correlativas.modelos.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InscripcionRepository extends JpaRepository<Inscripcion,Long> {
}
