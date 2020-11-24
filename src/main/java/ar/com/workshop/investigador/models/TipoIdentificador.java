package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tipos_de_identificadores")
public class TipoIdentificador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo_documento", nullable = false, length = 100)
    private String tipoDocumento;
    @OneToOne(mappedBy = "tipoIdentificador")
    private Empleado empleado;

}
