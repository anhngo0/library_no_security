package com.example.libraryManagement.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = "password", name = "password")
})
@NamedEntityGraph(name = "account", attributeNodes = {
        @NamedAttributeNode("profile"),
        @NamedAttributeNode(value = "role", subgraph = "role_subgraph")
}, subgraphs = @NamedSubgraph(name = "role_subgraph", attributeNodes = @NamedAttributeNode("permissions"))
)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean isEnabled = false;

    public Account(String username, String password, Profile profile, Role role) {
        this.username = username;
        this.password = password;
        this.isEnabled = true;
        this.profile = profile;
        this.role = role;
    }

    @OneToOne
    @JoinColumn(name = "profile_Id", referencedColumnName = "id")
    private Profile profile;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

}
