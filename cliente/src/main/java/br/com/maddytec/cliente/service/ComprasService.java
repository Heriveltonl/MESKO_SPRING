package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.entity.Compras;
import br.com.maddytec.cliente.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    private final ComprasRepository comprasRepository;

    @Autowired
    public ComprasService(ComprasRepository comprasRepository) {
        this.comprasRepository = comprasRepository;
    }

   
   
}
