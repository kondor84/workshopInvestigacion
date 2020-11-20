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
@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private String apellido;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_IDENTIFICADOR", referencedColumnName = "id")
    private TipoIdentificador tipoIdentificador;
    private String numeroIdentificador;

    public Cliente(Long idCliente) {
        this.idCliente = idCliente;
    }

}
