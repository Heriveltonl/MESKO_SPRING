package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.entity.Pedido;
import br.com.maddytec.cliente.service.ClienteService;
import br.com.maddytec.cliente.service.ItemService;
import br.com.maddytec.cliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import DTO.PedidoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;
import javax.persistence.Tuple;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido salvar(@RequestBody Pedido pedido) throws AttributeNotFoundException {
        Cliente cliente = clienteService.buscarPorId(pedido.getCliente().getId_customer())
                .orElseThrow(() -> new AttributeNotFoundException("Cliente não encontrado."));
        br.com.maddytec.cliente.entity.Item item = itemService.buscarPorId(pedido.getItem().getId_item())
                .orElseThrow();

        pedido.setCliente(cliente);
        pedido.setItem(item);

        return pedidoService.salvar(pedido);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> listaPedidos() {
        return pedidoService.listaPedidos();
    }

    @GetMapping("/{id_pedido}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido buscarPedidoPorId(@PathVariable("id_pedido") Long id_pedido) {
        return pedidoService.buscarPorId(id_pedido)
                .orElseThrow();
    }

    @DeleteMapping("/{id_pedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPedido(@PathVariable("id_pedido") Long id_pedido) {
        pedidoService.removerPorId(id_pedido);
    }

    @PutMapping("/{id_pedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPedido(@PathVariable("id_pedido") Long id_pedido, @RequestBody Pedido pedido) throws AttributeNotFoundException {
        Cliente cliente = clienteService.buscarPorId(pedido.getCliente().getId_customer())
                .orElseThrow(() -> new AttributeNotFoundException("Cliente não encontrado."));
        br.com.maddytec.cliente.entity.Item item = itemService.buscarPorId(pedido.getItem().getId_item())
                .orElseThrow(() -> new AttributeNotFoundException("Item não encontrado."));

        pedido.setCliente(cliente);
        pedido.setItem(item);

        pedidoService.buscarPorId(id_pedido)
                .map(pedidoBase -> {
                    pedidoBase.setQuantidade(pedido.getQuantidade());
                    pedidoBase.setCliente(pedido.getCliente());
                    pedidoBase.setItem(pedido.getItem());
                    pedidoService.salvar(pedidoBase);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new AttributeNotFoundException("Pedido não encontrado."));
    }
    
    
    	
    }
       
    


