package com.github.RafaMiura.ms_pedido.entities;

import com.github.RafaMiura.ms_pedido.Repository.ItemDoPedidoRepository;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Status status;

    //Relacionamento
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<ItemDoPedido> items = new ArrayList<>();
}
