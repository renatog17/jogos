package renato.portfolio.jogos.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import renato.portfolio.jogos.controller.dto.CreateJogoDTO;
import renato.portfolio.jogos.domain.Jogo;
import renato.portfolio.jogos.repository.JogoRepository;

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
	
	@Mock
    private JogoRepository jogoRepository; // Mock do repositório

    @InjectMocks
    private JogoController jogoController;

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
		CreateJogoDTO createJogoDTONullName = new CreateJogoDTOBuilder().withNomeNull().build();
		CreateJogoDTO createJogoDTOEmptyName = new CreateJogoDTOBuilder().withNomeEmpty().build();
		CreateJogoDTO createJogoDTONullPlataforma = new CreateJogoDTOBuilder().withPlataforma(null).build();
		CreateJogoDTO createJogoDTOHorasJogadasMenorQZero = new CreateJogoDTOBuilder().withHorasJogadas(-1).build();
		CreateJogoDTO createJogoDTONullDataCompra = new CreateJogoDTOBuilder().withDataCompra(null).build();
		CreateJogoDTO createJogoDTONullDesenvolvedor = new CreateJogoDTOBuilder().withDesenvolvedor(null).build();

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTOEmptyName)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullName)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullPlataforma)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTOHorasJogadasMenorQZero)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullDataCompra)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createJogoDTONullDesenvolvedor)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	// O proximo teste precisa ser forçando algum erro, posso mockar isso
	//acabo de descobrir que os erros precisam ser tratados
//	to-fix
	//@Test
//	public void testPostSQLError() throws JsonProcessingException, Exception {
//		//Arrange
//		CreateJogoDTO createJogoDTO = new CreateJogoDTOBuilder().build();
//		
//		when(jogoRepository.save(any(Jogo.class)))
//        .thenThrow(new DataIntegrityViolationException("Simulação de falha de acesso a dados"));
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/jogos").contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString(createJogoDTO)))
//				.andExpect(MockMvcResultMatchers.status().isInternalServerError());
//	}
}
