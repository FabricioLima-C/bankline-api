package com.dio.santander.banklineapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banklineapi.dto.NovaMovimentacao;
import com.dio.santander.banklineapi.model.Correntista;
import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.model.MovimentacaoTipo;
import com.dio.santander.banklineapi.repository.CorrentistaRepository;
import com.dio.santander.banklineapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = novaMovimentacao.getTipo()==MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor()*-1;
		
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setMovimentacaoTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		} 
		movimentacaoRepository.save(movimentacao);
	}
}
