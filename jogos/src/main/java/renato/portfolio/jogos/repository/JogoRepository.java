package renato.portfolio.jogos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import renato.portfolio.jogos.domain.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

	Page<Jogo> findAll(Pageable pageable);
}
