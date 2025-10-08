package br.com.exercicio.modelo;

import br.com.rpires.Acessorio;
import br.com.rpires.Marca;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private int ano;

    // Muitos carros podem ter a mesma marca
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    // Um carro pode ter vários acessórios
    @ManyToMany
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorios;

    public Carro() {}

    public Carro(String modelo, int ano, Marca marca) {
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
    }

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public List<Acessorio> getAcessorios() { return acessorios; }
    public void setAcessorios(List<Acessorio> acessorios) { this.acessorios = acessorios; }
}
