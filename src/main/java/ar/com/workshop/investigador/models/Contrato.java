package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroContrato;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "id")
    private Cliente cliente;
    private int cupos;
    private Date fechaAlta;
    private Date fechaVencimiento;

    public Contrato(Long idContrato) {
        this.numeroContrato = idContrato;
    }
}
