package br.unibh.sdm.backend_quarto.entidades;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_quarto")
public class Quarto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  @Column(length = 255)
  private String senha;

  @NotBlank
  @Column(length = 100)
  @Size(min = 3, max = 100)
  private String nome;

  public Quarto() {
    super();
  }

  public Quarto(Long id, String senha, String nome) {
    super();
    this.id = id;
    this.senha = senha;
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "Quarto [id=" + id + ", senha=" + senha + ", nome=" + nome + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((senha == null) ? 0 : senha.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Quarto other = (Quarto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (senha == null) {
      if (other.senha != null)
        return false;
    } else if (!senha.equals(other.senha))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    }
    return true;
  }

}