package br.grupo01.springboot01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.springboot01.dto.ClienteDTO;
import br.grupo01.springboot01.model.Cliente;
import br.grupo01.springboot01.repository.ClienteRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired // injeção de dependência
    private ClienteRepo repo;

    @GetMapping
    public List<Cliente> listarTodos() {
        List<Cliente> lista = (List<Cliente>) repo.findAll(); // casting

        return lista;
    }

    @GetMapping("/codigo/{codigo}") // busca um cliente em particular
    public ResponseEntity<Cliente> buscarCliente(@PathVariable int codigo) {
        // busca um cliente com este codigo, e se não encontrar, preenche com null
        Cliente cliente = repo.findById(codigo).orElse(null);

        if(cliente != null) { // achou o cliente
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build(); // notFound = status 404, sem conteudo
    }
    @GetMapping("/cod/{codigo}") // busca um cliente em particular
    public ResponseEntity<ClienteDTO> buscarClienteResumo(@PathVariable int codigo) {
        
        Cliente cliente = repo.findById(codigo).orElse(null);

        if(cliente != null) { 
            ClienteDTO clienteDTO = new ClienteDTO(cliente);
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.notFound().build(); 
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente novoCliente) {  // Inserir Novocliente atraves do Postmam.

        Cliente cliente = repo.save(novoCliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> apagar(@PathVariable int codigo) { // Apagar um cliente
        Cliente cliente = repo.findById(codigo).orElse(null);

        if(cliente != null) {
            repo.delete(cliente);
            return ResponseEntity.noContent().build(); 
            //return ResponseEntity.status(204).build(); // posso usar um dos dois
        }

        return ResponseEntity.notFound().build(); // notFound = status 404, sem conteudo
    }
    @GetMapping("/cpf")
    public ResponseEntity<Cliente> buscarPorCpf(@RequestBody Cliente clienteProcurado) {
        Cliente clienteEncontrado = repo.findByCpf(clienteProcurado.getCpf());

        if(clienteEncontrado != null) { 
            return ResponseEntity.ok(clienteEncontrado);
        }
        return ResponseEntity.notFound().build();
    }

}
