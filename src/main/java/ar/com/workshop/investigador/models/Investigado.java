package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "investigados")
public class Investigado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Column(name = "APELLIDO", nullable = false, length = 100)
    private String apellido;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_IDENTIFICADOR", referencedColumnName = "id")
    private TipoIdentificador tipoIdentificador;
    @Column(name = "NUMERO_IDENTIFICADOR", nullable = false, length = 50)
    private String numeroIdentificador;
    @OneToMany(mappedBy = "investigado")
    private Set<Pedido> pedidos;

}
