package br.com.rpires;

import br.com.exercicio.modelo.Carro;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Um acessório pode pertencer a vários carros
    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;

    public Acessorio() {}

    public Acessorio(String nome) {
        this.nome = nome;
    }

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Carro> getCarros() { return carros; }
    public void setCarros(List<Carro> carros) { this.carros = carros; }
}
