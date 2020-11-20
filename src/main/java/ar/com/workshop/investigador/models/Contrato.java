package ar.com.workshop.investigador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_CONTRATO")
    private Long numeroContrato;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "id_Cliente")
    private Cliente cliente;
    private int cupos;
    private Date fechaAlta;
    private Date fechaVencimiento;
    @OneToMany(mappedBy = "contrato")
    private Set<Pedido> pedidos;

    public Contrato(Long idContrato) {
        this.numeroContrato = idContrato;
    }
}
