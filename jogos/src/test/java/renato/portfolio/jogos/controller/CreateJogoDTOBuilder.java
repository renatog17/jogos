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

    public CreateJogoDTOBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public CreateJogoDTOBuilder plataforma(String plataforma) {
        this.plataforma = plataforma;
        return this;
    }

    public CreateJogoDTOBuilder horasJogadas(Integer horasJogadas) {
        this.horasJogadas = horasJogadas;
        return this;
    }

    public CreateJogoDTOBuilder dataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
        return this;
    }

    public CreateJogoDTOBuilder ultimaVezJogado(LocalDate ultimaVezJogado) {
        this.ultimaVezJogado = ultimaVezJogado;
        return this;
    }

    public CreateJogoDTOBuilder finalizado(Boolean finalizado) {
        this.finalizado = finalizado;
        return this;
    }

    public CreateJogoDTOBuilder nota(String nota) {
        this.nota = nota;
        return this;
    }

    public CreateJogoDTOBuilder desenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
        return this;
    }

    public CreateJogoDTOBuilder genero(String genero) {
        this.genero = genero;
        return this;
    }

    public CreateJogoDTO build() {
        return new CreateJogoDTO(nome, plataforma, horasJogadas, dataCompra, ultimaVezJogado, finalizado, nota, desenvolvedor, genero);
    }
}
