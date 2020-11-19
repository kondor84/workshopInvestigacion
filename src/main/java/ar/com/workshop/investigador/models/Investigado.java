package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investigado {

    private Long id;
    private String nombre;
    private String apellido;
    private TipoIdentificador tipoIdentificador;
    private String numeroIdentificador;

}
