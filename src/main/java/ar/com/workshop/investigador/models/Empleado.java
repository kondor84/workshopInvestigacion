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
@Entity(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long legajo;
    private String nombre;
    private String apellido;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_IDENTIFICADOR", referencedColumnName = "id")
    private TipoIdentificador tipoIdentificador;
    @Column(name = "NUMERO_IDENTIFICADOR")
    private String numeroIdentificador;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_EMPLEADO", referencedColumnName = "id")
    private TipoEmpleado tipoEmpleado;
    @OneToMany(mappedBy = "empleado")
    private Set<Pedido> pedidos;
}
