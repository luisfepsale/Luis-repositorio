package com.example.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

    @RestController
    @RequestMapping("/clientes")
    public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> getClientes(){
        return service.getClientes();
    }
    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente, HttpServletRequest request, UriComponentsBuilder builder) {
    cliente = service.save(cliente);
    UriComponents uriComponents = builder.path(request.getRequestURI()+ "/"+cliente.getCodigo()).build();
    return ResponseEntity.created(uriComponents.toUri()).build(); 
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int codigo) {
        Cliente cliente = service.getClienteByCodigo(codigo);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@RequestBody ClienteDTO veiculoDTO,@PathVariable int codigo)
    {
    Cliente cliente = service.fromDTO(veiculoDTO);
    cliente.setCodigo(codigo);
    cliente = service.update(cliente);
    return ResponseEntity.ok(cliente);   
    }
    @PostMapping("/{codigo}/clientes")
    public ResponseEntity<Void> salvar(@PathVariable int codigo, @RequestBody Cliente cliente, HttpServletRequest request, UriComponentsBuilder builder)
    {
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + cliente.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();  
    }  
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo)
    {
    service.removerByCodigo(codigo);
    return ResponseEntity.noContent().build();
    } 
}

