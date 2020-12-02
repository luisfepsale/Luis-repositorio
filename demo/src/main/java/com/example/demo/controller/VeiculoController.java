package com.example.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.example.demo.dto.VeiculoDTO;
import com.example.demo.model.Veiculo;
import com.example.demo.service.VeiculoService;
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
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> getVeiculos(){
        return service.getVeiculos();
    }
    @PostMapping
    public ResponseEntity<Veiculo> salvar(@RequestBody Veiculo veiculo, HttpServletRequest request, UriComponentsBuilder builder) {
        veiculo = service.save(veiculo);
    UriComponents uriComponents = builder.path(request.getRequestURI()+ "/"+veiculo.getCodigo()).build();
    return ResponseEntity.created(uriComponents.toUri()).build(); 
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable int codigo) {
        Veiculo veiculo = service.getVeiculoByCodigo(codigo);
        return ResponseEntity.ok(veiculo);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Veiculo> atualizar(@RequestBody VeiculoDTO veiculoDTO,@PathVariable int codigo)
    {
    Veiculo veiculo = service.fromDTO(veiculoDTO);
    veiculo.setCodigo(codigo);
    veiculo = service.update(veiculo);
    return ResponseEntity.ok(veiculo);   
    }
    @PostMapping("/{codigo}/veiculos")
    public ResponseEntity<Void> salvar(@PathVariable int codigo, @RequestBody Veiculo veiculo, HttpServletRequest request, UriComponentsBuilder builder)
    {
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + veiculo.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();  
    }   
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo)
    {
    service.removerByCodigo(codigo);
    return ResponseEntity.noContent().build();
    } 
}
    
