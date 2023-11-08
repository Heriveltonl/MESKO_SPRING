package br.com.maddytec.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.entity.Compras;


public interface ComprasRepository extends JpaRepository<Compras, Long> {

	
	
	}

	

