package ar.com.workshop.investigador.services.implementacion;

import ar.com.workshop.investigador.exceptions.ApiExceptions;
import ar.com.workshop.investigador.models.Investigado;
import ar.com.workshop.investigador.models.Pedido;
import ar.com.workshop.investigador.repositories.ClienteRepository;
import ar.com.workshop.investigador.repositories.ContratoRepository;
import ar.com.workshop.investigador.repositories.InvestigadoRepository;
import ar.com.workshop.investigador.repositories.PedidoRepository;
import ar.com.workshop.investigador.services.IPedidosService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PedidoService implements IPedidosService {

    private final PedidoRepository pedidoRepository;
    private final InvestigadoRepository investigadoRepository;
    private final ClienteRepository clienteRepository;
    private final ContratoRepository contratoRepository;

    @Autowired
    public PedidoService(InvestigadoRepository investigadoRepository, PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository, ContratoRepository contratoRepository) {
        this.investigadoRepository = investigadoRepository;
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.contratoRepository = contratoRepository;
    }


    @Override
    public Pedido crearPedido(Investigado investigado, Long idCliente, Long idContrato, Date fechaCarga, Date fechaEntrega) throws NotFoundException {
        validarPedido(investigado, idCliente, idContrato, fechaEntrega);
        Investigado investigadoBD = existeInvestigado(investigado);
        Investigado investigadoPedido = investigadoBD != null ? investigadoBD : investigado;
        fechaCarga = fechaCarga != null ? fechaCarga : new Date();
        return pedidoRepository.save(new Pedido(investigado, idCliente, idContrato, fechaCarga, fechaEntrega));
    }

    private void validarPedido(Investigado investigado, Long idCliente, Long idContrato, Date fechaEntrega) throws NotFoundException {

        if (idCliente == null)
            throw new ApiExceptions("El campo id cliente no puede estar vacio", HttpStatus.BAD_REQUEST);
        else
            clienteRepository.findById(idCliente).orElseThrow(() -> new NotFoundException(String.format("El cliente %s no existe", idCliente)));

        if (idContrato == null)
            throw new ApiExceptions("El campo id contrato no puede estar vacio", HttpStatus.BAD_REQUEST);
        else
            contratoRepository.findByNumeroContrato(idContrato).orElseThrow(() -> new NotFoundException(String.format("El contrato %s no existe", idContrato)));

        if (investigado.getApellido() == null)
            throw new ApiExceptions("El campo apellido es requerido", HttpStatus.CONFLICT);
        if (investigado.getNombre() == null)
            throw new ApiExceptions("El campo nombre es requerido", HttpStatus.CONFLICT);
        if (investigado.getTipoIdentificador() == null)
            throw new ApiExceptions("El campo tipo identificacion es requerido", HttpStatus.CONFLICT);
        if (investigado.getNumeroIdentificador() == null)
            throw new ApiExceptions("El campo numero identificacion es requerido", HttpStatus.CONFLICT);
        if (fechaEntrega == null)
            throw new ApiExceptions("El campo fecha de entrega es requerido", HttpStatus.CONFLICT);
    }

    private Investigado existeInvestigado(Investigado investigado) {
        return investigadoRepository
                .findByTipoIdentificador_IdAndAndNumeroIdentificador(investigado.getTipoIdentificador().getId(),
                        investigado.getNumeroIdentificador());
    }
}
