package ar.com.workshop.investigador.services;

import ar.com.workshop.investigador.models.Investigado;
import ar.com.workshop.investigador.models.Pedido;
import javassist.NotFoundException;

import java.util.Date;

public interface IPedidosService {
    Pedido crearPedido(Investigado investigado, Long idCliente, Long idContrato, Date fechaCarga, Date fechaEntrega) throws NotFoundException;
}
