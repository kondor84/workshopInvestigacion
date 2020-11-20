package ar.com.workshop.investigador.services.implementacion;

import ar.com.workshop.investigador.models.Pedido;
import ar.com.workshop.investigador.repositories.PedidoRepository;
import ar.com.workshop.investigador.services.IPedidosService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PedidoService implements IPedidosService {
    @Autowired
    private static PedidoRepository pedidoRepository;
    @Override
    public Pedido crearPedido(Long investigador, Long idCliente, Long idContrato, Date fechaCarga, Date fechaEntrega) throws NotFoundException {
         validarPedido(investigador,idCliente,idContrato,fechaCarga,fechaEntrega);
        return pedidoRepository.save(new Pedido(investigador,idCliente,idContrato,fechaCarga,fechaEntrega));
    }


    private void validarPedido(Long investigador, Long idCliente, Long idContrato, Date fechaCarga, Date fechaEntrega) throws NotFoundException {
    //TODO implementar
        if (idCliente == null){
            throw new NotFoundException("El campo id cliente no puede estar vacio");
        }
    }
}
