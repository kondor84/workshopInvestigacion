package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contrato {

    private Long numeroContrato;
    private Cliente cliente;
    private int cupos;
    private Date fechaAlta;
    private Date fechaVencimiento;

    public Contrato(Long idContrato) {
        this.numeroContrato = idContrato;
    }
}
