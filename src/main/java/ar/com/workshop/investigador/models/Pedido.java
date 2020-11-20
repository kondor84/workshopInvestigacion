package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tipo_empleado")
public class Pedido {

    private Long idPedido;
    private Contrato contrato;
    private Cliente cliente;
    private Empleado empleado;
    private Date fechaCarga;
    private Date fechaEntrega;
    private EstadoPedido estadoPedido;
    private Investigado investigado;


}
