package br.ifsul.object_finder_api.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@Table(name = "categorias")
@Entity
@Getter
@Setter
public class Category {
    @Column(name = "codcat", columnDefinition = "INTEGER")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomecat", length = 200, columnDefinition = "DEFAULT NULL")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<LostObject> lostObjects;
}