package renato.portfolio.jogos.controller.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateJogoDTO(
		@NotBlank(message = "O nome do jogo não pode ser vazio.") 
		String nome,
	    @NotBlank(message = "A plataforma não pode ser vazia.") 
		String plataforma,
	    @Positive(message = "Horas jogadas devem ser um número positivo.") 
		Integer horasJogadas,
	    @NotNull(message = "A data de compra não pode ser nula.") 
		LocalDate dataCompra,
	    LocalDate ultimaVezJogado,
	    Boolean finalizado,
	    String nota,
	    @NotBlank(message = "O nome do desenvolvedor não pode ser vazio.") 
		String desenvolvedor,
	    String genero) {

}
