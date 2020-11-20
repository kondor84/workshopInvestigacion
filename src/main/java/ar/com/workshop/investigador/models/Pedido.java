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
public class Pedido {

    private Long idPedido;
    private Contrato contrato;
    private Cliente cliente;
    private Empleado empleado;
    private Date fechaCarga;
    private Date fechaEntrega;
    private EstadoPedido estadoPedido;
    private Investigado investigado;

    public Pedido(Investigado investigadoPedido, Long idCliente, Long idContrato, Date fechaCarga, Date fechaEntrega) {
    this.investigado = investigadoPedido;
            this.cliente = new Cliente(idCliente);
            this.contrato = new Contrato(idContrato);
            this.fechaCarga =fechaCarga;
            this.fechaEntrega = fechaEntrega;
    }

}
