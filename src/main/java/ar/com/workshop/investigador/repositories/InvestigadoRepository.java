package ar.com.workshop.investigador.repositories;

import ar.com.workshop.investigador.models.Investigado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigadoRepository extends JpaRepository<Investigado, Long> {
}
