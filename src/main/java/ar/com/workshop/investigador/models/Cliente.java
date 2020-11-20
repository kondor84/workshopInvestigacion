package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    private Long idCliente;
    private String nombre;
    private String apellido;
    private TipoIdentificador tipoIdentificador;
    private String numeroIdentificador;

    public Cliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
