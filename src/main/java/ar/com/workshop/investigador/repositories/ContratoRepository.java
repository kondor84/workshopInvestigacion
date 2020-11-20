package ar.com.workshop.investigador.repositories;

import ar.com.workshop.investigador.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato,Long> {

    Optional<Contrato> findByNumeroContrato(@Param("numeroContrato")Long numeroContrato);
}
