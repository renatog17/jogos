package renato.portfolio.jogos.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import renato.portfolio.jogos.controller.dto.CreateJogoDTO;
import renato.portfolio.jogos.domain.Jogo;
import renato.portfolio.jogos.repository.JogoRepository;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository; // Certifique-se de que você tenha esse repositório criado

    // Criar um novo jogo
    @PostMapping
    public ResponseEntity<Jogo> criarJogo(@RequestBody @Valid CreateJogoDTO CreateJogoDTO) {
        Jogo novoJogo = new Jogo (CreateJogoDTO);
    	jogoRepository.save(novoJogo);
        return new ResponseEntity<>(novoJogo, HttpStatus.CREATED);
    }
    
    //terminar de implementar daqui pra baixo
    //e depois escrever os testes
    
    // Listar todos os jogos
    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos() {
        List<Jogo> jogos = jogoRepository.findAll();
        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }

    // Buscar um jogo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarJogo(@PathVariable Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        return jogo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um jogo
    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizarJogo(@PathVariable Long id, @RequestBody Jogo jogoAtualizado) {
        if (!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogoAtualizado.setId(id); // Manter o ID original
        Jogo jogoSalvo = jogoRepository.save(jogoAtualizado);
        return ResponseEntity.ok(jogoSalvo);
    }

    // Deletar um jogo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogo(@PathVariable Long id) {
        if (!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}