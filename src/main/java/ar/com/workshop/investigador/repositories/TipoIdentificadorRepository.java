package ar.com.workshop.investigador.repositories;

import ar.com.workshop.investigador.models.TipoIdentificador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoIdentificadorRepository extends JpaRepository<TipoIdentificador, Long> {
}
