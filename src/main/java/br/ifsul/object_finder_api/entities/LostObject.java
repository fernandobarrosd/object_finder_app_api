package br.ifsul.object_finder_api.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "objetos")
@Entity
public class LostObject {
    @Column(name = "codobj", columnDefinition = "INTEGER", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeobj", nullable = false)
    private String name;

    @Column(name = "descobj", nullable = false)
    private String description;

    @Column(name = "lugar", nullable = false, length = 200)
    private String locale;

    @Column(name = "data_encontrado", nullable = false, length = 10)
    private String dataEncontrado;

    @Column(name = "data_cadastro", nullable = false, length = 10)
    private String dataCadastro;

    @Column(name = "devolvido", nullable = false, length = 3)
    private String devolvido;

    @ManyToOne
    @JoinColumn(
        nullable = false,
        name = "categorias_codcat",
        columnDefinition = "INTEGER",
        referencedColumnName = "codcat"
    )
    private Category category;

    @ManyToOne
    @JoinColumn(
        nullable = false,
        name = "usuarios_coduser",
        columnDefinition = "int(10) unsigned",
        referencedColumnName = "coduser"
    )
    private User user;
}
