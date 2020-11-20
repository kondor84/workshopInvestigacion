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
@Entity(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @ManyToOne
    @JoinColumn(name="NUMERO_CONTRATO", nullable=false)
    private Contrato contrato;
    @ManyToOne
    @JoinColumn(name="ID_CLIENTE", nullable=false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="ID_EMPLEADO", nullable=false)
    private Empleado empleado;
    private Date fechaCarga;
    private Date fechaEntrega;
    //private EstadoPedido estadoPedido;
    //private Investigado investigado;

    public Pedido(Investigado investigadoPedido, Long idCliente, Long idContrato, Date fechaCarga, Date fechaEntrega) {
        //this.investigado = investigadoPedido;
        //this.cliente = new Cliente(idCliente);
        //this.contrato = new Contrato(idContrato);
        this.fechaCarga =fechaCarga;
        this.fechaEntrega = fechaEntrega;
    }
}
