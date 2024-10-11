package renato.portfolio.jogos.controller;

import java.time.LocalDate;

import renato.portfolio.jogos.controller.dto.CreateJogoDTO;

public class CreateJogoDTOBuilder {

	private String nome;
	private String plataforma;
	private Integer horasJogadas;
	private LocalDate dataCompra;
	private LocalDate ultimaVezJogado;
	private Boolean finalizado;
	private String nota;
	private String desenvolvedor;
	private String genero;

	public CreateJogoDTOBuilder() {
		this.nome = "Nome Padrão";
		this.plataforma = "Plataforma Padrão";
		this.horasJogadas = 10;
		this.dataCompra = LocalDate.now();
		this.desenvolvedor = "Desenvolvedor Padrão";
		this.finalizado = false;
		this.genero = "Ação";
		this.ultimaVezJogado = LocalDate.now();
		this.nota = "10";
	}

	public CreateJogoDTOBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}

	public CreateJogoDTOBuilder withNomeNull() {
		this.nome = null;
		return this;
	}

	public CreateJogoDTOBuilder withPlataforma(String plataforma) {
		this.plataforma = plataforma;
		return this;
	}

	public CreateJogoDTOBuilder withPlataformaNull() {
		this.plataforma = null;
		return this;
	}

	public CreateJogoDTOBuilder withHorasJogadas(Integer horasJogadas) {
		this.horasJogadas = horasJogadas;
		return this;
	}

	public CreateJogoDTOBuilder withHorasJogadasNull() {
		this.horasJogadas = null;
		return this;
	}

	public CreateJogoDTOBuilder withDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
		return this;
	}

	public CreateJogoDTOBuilder withDataCompraNull() {
		this.dataCompra = null;
		return this;
	}

	public CreateJogoDTOBuilder withUltimaVezJogado(LocalDate ultimaVezJogado) {
		this.ultimaVezJogado = ultimaVezJogado;
		return this;
	}

	public CreateJogoDTOBuilder withUltimaVezJogadoNull() {
		this.ultimaVezJogado = null;
		return this;
	}

	public CreateJogoDTOBuilder withFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
		return this;
	}

	public CreateJogoDTOBuilder withFinalizadoNull() {
		this.finalizado = null;
		return this;
	}

	public CreateJogoDTOBuilder withNota(String nota) {
		this.nota = nota;
		return this;
	}

	public CreateJogoDTOBuilder withNotaNull() {
		this.nota = null;
		return this;
	}

	public CreateJogoDTOBuilder withDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
		return this;
	}

	public CreateJogoDTOBuilder withDesenvolvedorNull() {
		this.desenvolvedor = null;
		return this;
	}

	public CreateJogoDTOBuilder withGenero(String genero) {
		this.genero = genero;
		return this;
	}

	public CreateJogoDTOBuilder withGeneroNull() {
		this.genero = null;
		return this;
	}

	public CreateJogoDTO build() {
		return new CreateJogoDTO(nome, plataforma, horasJogadas, dataCompra, ultimaVezJogado, finalizado, nota,
				desenvolvedor, genero);
	}
}
