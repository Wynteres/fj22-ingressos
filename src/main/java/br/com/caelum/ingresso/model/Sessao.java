package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Sala sala;

	@ManyToOne
	private Filme filme;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime horario;

	private BigDecimal preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Sessao(Sala sala, Filme filme, LocalTime horario) {
		super();
		this.sala = sala;
		this.filme = filme;
		this.horario = horario;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public Sessao() {
	}

	@Override
	public String toString() {
		return "Sessao [id=" + id + ", sala=" + sala + ", filme=" + filme + ", horario=" + horario + "]";
	}

}
