package renato.portfolio.jogos.controller;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import renato.portfolio.jogos.controller.dto.CreateJogoDTO;
import renato.portfolio.jogos.controller.dto.ReadJogoDTO;
import renato.portfolio.jogos.controller.dto.UpdateJogoDTO;
import renato.portfolio.jogos.domain.Jogo;
import renato.portfolio.jogos.repository.JogoRepository;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    @PostMapping
    public ResponseEntity<Jogo> criarJogo(@RequestBody @Valid CreateJogoDTO CreateJogoDTO, UriComponentsBuilder uriComponentsBuilder) {
        Jogo novoJogo = new Jogo (CreateJogoDTO);
    	jogoRepository.save(novoJogo);
    	URI uri = uriComponentsBuilder.path("/board/{id}").buildAndExpand(novoJogo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public Page<ReadJogoDTO> listarJogos(@PageableDefault(size = 10) Pageable pageable) {
        return jogoRepository.findAll(pageable).map(ReadJogoDTO::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadJogoDTO> buscarJogo(@PathVariable Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if(jogo.isPresent()) {
        	return ResponseEntity.ok(new ReadJogoDTO(jogo.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReadJogoDTO> atualizarJogo(@PathVariable Long id, @RequestBody UpdateJogoDTO jogoAtualizado) {
        Optional<Jogo> optionalJogo = jogoRepository.findById(id);
    	
    	if (optionalJogo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Jogo jogo = optionalJogo.get();
        jogo.atualizar(jogoAtualizado);
        return ResponseEntity.ok(new ReadJogoDTO(jogo));
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