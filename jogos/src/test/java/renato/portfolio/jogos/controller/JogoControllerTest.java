package renato.portfolio.jogos.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import renato.portfolio.jogos.controller.dto.CreateJogoDTO;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JogoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testPostJogo() throws JsonProcessingException, Exception {
		// Arrange
		CreateJogoDTO createJogoDTO = new CreateJogoDTO("Teste", "Nintendo Teste", 40, LocalDate.now().minusDays(7),
				LocalDate.now(), false, "NOta boa", "Ação", "Aventura");

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTO)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/jogos/1"));
	}

	@Test
	public void testPostJogoCamposInvalidos() throws JsonProcessingException, Exception {
		// Arrange
		CreateJogoDTO createJogoDTONullName = new CreateJogoDTOBuilder().nome(null).build();
		CreateJogoDTO createJogoDTONullPlataforma = new CreateJogoDTOBuilder().plataforma(null).build();
		CreateJogoDTO createJogoDTOHorasJogadasMenorQZero = new CreateJogoDTOBuilder().horasJogadas(-1).build();
		CreateJogoDTO createJogoDTONullDataCompra = new CreateJogoDTOBuilder().dataCompra(null).build();
		CreateJogoDTO createJogoDTONullDesenvolvedor = new CreateJogoDTOBuilder().desenvolvedor(null).build();

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullName)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullPlataforma)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTOHorasJogadasMenorQZero)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullDataCompra)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullDesenvolvedor)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

//		CreateJogoDTO createJogoDTONullPlataforma = new CreateJogoDTO(null, null, 0, null, null, false, null, null, null);
//		CreateJogoDTO createJogoDTOHorasJogadasMenorQZero = new CreateJogoDTO(null, null, 0, null, null, false, null, null, null);
//		CreateJogoDTO createJogoDTONullDataCompra = new CreateJogoDTO(null, null, 0, null, null, false, null, null, null);
//		CreateJogoDTO createJogoDTONullDesenvolvedor = new CreateJogoDTO(null, null, 0, null, null, false, null, null, null);
		// as declarações acima dentro deste método serão substituídas pelo builder
	}
}
