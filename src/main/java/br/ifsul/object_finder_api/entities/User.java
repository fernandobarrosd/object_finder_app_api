package br.ifsul.object_finder_api.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuarios")
@Entity
public class User {
    @Column(name = "coduser", columnDefinition = "INTEGER")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 12, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<LostObject> lostObjects;
}