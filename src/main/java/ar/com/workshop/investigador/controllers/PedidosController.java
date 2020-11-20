package ar.com.workshop.investigador.controllers;

import ar.com.workshop.investigador.models.Investigado;
import ar.com.workshop.investigador.models.Pedido;
import ar.com.workshop.investigador.services.IPedidosService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

@RestController
@RequestMapping("pedidos/")
public class PedidosController {
    private final IPedidosService iPedidosService;

    public PedidosController(IPedidosService iPedidosService) {
        this.iPedidosService = iPedidosService;
    }

    @PostMapping("crear-pedidos/")
    private ResponseEntity<Pedido> crearPedido(@RequestBody Investigado investigado,
                                               @RequestParam Long idCliente,
                                               @RequestParam Long idContrato,
                                               @RequestParam Date fechaCarga,
                                               @RequestParam Date fechaEntrega,
                                               UriComponentsBuilder builder) throws NotFoundException {
        Pedido pedidoNew = iPedidosService.crearPedido(investigado,idCliente,idContrato,fechaCarga,fechaEntrega);

        return ResponseEntity
                .created(builder.path("{id}").buildAndExpand(pedidoNew.getIdPedido()).toUri())
                .body(pedidoNew);
    }

}
