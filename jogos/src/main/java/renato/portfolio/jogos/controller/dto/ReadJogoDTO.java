package renato.portfolio.jogos.controller.dto;

import java.time.LocalDate;

import renato.portfolio.jogos.domain.Jogo;

public record ReadJogoDTO(
		Long id,
		String nome,
		String plataforma,
		int horasJogadas,
		LocalDate dataCompra,
		LocalDate ultimaVezJogado,
		boolean finalizado,
		String nota,
		String desenvolvedor,
		String genero) {
		
	public ReadJogoDTO(Jogo jogo) {
		this(jogo.getId(),
				jogo.getNome(),
				jogo.getPlataforma(),
				jogo.getHorasJogadas(),
				jogo.getDataCompra(),
				jogo.getUltimaVezJogado(),
				jogo.isFinalizado(),
				jogo.getNota(),
				jogo.getDesenvolvedor(),
				jogo.getGenero());
	}
}
