package ar.com.workshop.investigador.controllers;

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
    @Autowired
    private static IPedidosService iPedidosService;

    @PostMapping("crear-pedidos/")
    private ResponseEntity<Pedido> crearPedido(@RequestParam(required = false) Long id_investigador,
                                               @RequestParam Long id_cliente,
                                               @RequestParam Long id_contrato,
                                               @RequestParam Date fecha_carga,
                                               @RequestParam Date fecha_entrega,
                                               UriComponentsBuilder builder) throws NotFoundException {
        Pedido pedidoNew = iPedidosService.crearPedido(id_investigador,id_cliente,id_contrato,fecha_carga,fecha_entrega);

        return ResponseEntity
                .created(builder.path("{id}").buildAndExpand(pedidoNew.getId_pedido()).toUri())
                .body(pedidoNew);
    }

}
