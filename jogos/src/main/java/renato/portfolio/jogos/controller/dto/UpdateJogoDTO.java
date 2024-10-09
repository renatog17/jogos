package renato.portfolio.jogos.controller.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateJogoDTO(
		String nome, 
		String plataforma,
	    @Positive(message = "Horas jogadas devem ser um número positivo.") 
		Integer horasJogadas, 
		LocalDate dataCompra,
	    LocalDate ultimaVezJogado,
	    Boolean finalizado,
	    String nota, 
		String desenvolvedor,
	    String genero) {

}
