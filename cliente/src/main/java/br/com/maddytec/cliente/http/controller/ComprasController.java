package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.entity.Compras;

import br.com.maddytec.cliente.entity.Item;
import br.com.maddytec.cliente.entity.Pedido;
import br.com.maddytec.cliente.service.ComprasService;
import br.com.maddytec.cliente.service.ItemService;
import br.com.maddytec.cliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    private final ComprasService comprasService;

    @Autowired
    public ComprasController(ComprasService comprasService) {
        this.comprasService = comprasService;
    }

    

    
}

