package com.dio.santander.banklineapi.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Movimentacao {
	private Integer id;
	private LocalDateTime dataHora;
	private String descricao;
	private Double valor;
	
	private MovimentacaoTipo movimentacaoTipo;

	public Movimentacao() {
	}

	public Movimentacao(LocalDateTime dataHora, String descricao, Double valor, MovimentacaoTipo movimentacaoTipo) {
		this.dataHora = dataHora;
		this.descricao = descricao;
		this.valor = valor;
		this.movimentacaoTipo = movimentacaoTipo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MovimentacaoTipo getMovimentacaoTipo() {
		return movimentacaoTipo;
	}

	public void setMovimentacaoTipo(MovimentacaoTipo movimentacaoTipo) {
		this.movimentacaoTipo = movimentacaoTipo;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
