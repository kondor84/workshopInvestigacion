package ar.com.workshop.investigador.services;

import ar.com.workshop.investigador.models.Pedido;
import javassist.NotFoundException;

import java.util.Date;

public interface IPedidosService {
    Pedido crearPedido(Long investigador, Long idCliente, Long idContrato, Date fechaCarga, Date fechaEntrega) throws NotFoundException;
}
