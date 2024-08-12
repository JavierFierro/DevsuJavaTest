package com.example.devsu.controller;

import com.example.devsu.dto.ClienteDTO;
import com.example.devsu.entity.Cliente;
import com.example.devsu.exception.cliente.InvalidBodyPropertiesException;
import com.example.devsu.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllClientes(){

        List<Cliente> clienteList = clienteService.getAllCLientes();
        return new ResponseEntity<>(clienteList, HttpStatus.OK);
    }

    @GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable("id") Integer clienteId) {

        ClienteDTO clienteDTO = clienteService.getClienteById(clienteId);
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @SneakyThrows
    public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody ClienteDTO clienteDTO, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidBodyPropertiesException("Error en las propiedades");
        }
        return new ResponseEntity<>(clienteService.saveCliente(clienteDTO), HttpStatus.OK);
    }

    @SneakyThrows
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> updateCliente(@Valid @RequestBody ClienteDTO clienteDTO, BindingResult result){
        if(result.hasErrors()) {
            throw new InvalidBodyPropertiesException("Error en las propiedades");
        }
        return new ResponseEntity<>(clienteService.updateCliente(clienteDTO), HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public void deleteCliente(@PathVariable("id") Integer clienteId){
        clienteService.deleteCliente(clienteId);
    }
}
