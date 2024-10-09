package renato.portfolio.jogos.domain;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import renato.portfolio.jogos.controller.dto.CreateJogoDTO;
import renato.portfolio.jogos.controller.dto.UpdateJogoDTO;

@Entity
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String plataforma;
	private Integer horasJogadas;
	private LocalDate dataCompra;
	private LocalDate ultimaVezJogado;
	private Boolean finalizado;
	private String nota;
	private String desenvolvedor;
	private String genero;

	public Jogo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jogo(String nome, String plataforma, int horasJogadas, LocalDate dataCompra, LocalDate ultimaVezJogado,
			boolean finalizado, String nota, String desenvolvedor, String genero) {
		super();
		this.nome = nome;
		this.plataforma = plataforma;
		this.horasJogadas = horasJogadas;
		this.dataCompra = dataCompra;
		this.ultimaVezJogado = ultimaVezJogado;
		this.finalizado = finalizado;
		this.nota = nota;
		this.desenvolvedor = desenvolvedor;
		this.genero = genero;
	}

	public Jogo(CreateJogoDTO createJogoDTO) {
		this.nome = createJogoDTO.nome();
		this.plataforma = createJogoDTO.plataforma();
		this.horasJogadas = createJogoDTO.horasJogadas();
		this.dataCompra = createJogoDTO.dataCompra();
		this.ultimaVezJogado = createJogoDTO.ultimaVezJogado();
		this.finalizado = createJogoDTO.finalizado();
		this.nota = createJogoDTO.nota();
		this.desenvolvedor = createJogoDTO.desenvolvedor();
		this.genero = createJogoDTO.genero();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getHorasJogadas() {
		return horasJogadas;
	}

	public void setHorasJogadas(int horasJogadas) {
		this.horasJogadas = horasJogadas;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public LocalDate getUltimaVezJogado() {
		return ultimaVezJogado;
	}

	public void setUltimaVezJogado(LocalDate ultimaVezJogado) {
		this.ultimaVezJogado = ultimaVezJogado;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nome=" + nome + ", plataforma=" + plataforma + ", horasJogadas=" + horasJogadas
				+ ", dataCompra=" + dataCompra + ", ultimaVezJogado=" + ultimaVezJogado + ", finalizado=" + finalizado
				+ ", nota=" + nota + ", desenvolvedor=" + desenvolvedor + ", genero=" + genero + "]";
	}

	public void atualizar(UpdateJogoDTO jogoAtualizado) {
		if(jogoAtualizado.nome() != null) this.nome = jogoAtualizado.nome();
		if(jogoAtualizado.plataforma() != null) this.plataforma = jogoAtualizado.plataforma();
		if(jogoAtualizado.horasJogadas() != null) this.horasJogadas = jogoAtualizado.horasJogadas();
		if(jogoAtualizado.dataCompra() != null) this.dataCompra = jogoAtualizado.dataCompra();
		if(jogoAtualizado.ultimaVezJogado() != null) this.ultimaVezJogado = jogoAtualizado.ultimaVezJogado();
		if(jogoAtualizado.finalizado() != null) this.finalizado = jogoAtualizado.finalizado();
		if(jogoAtualizado.nota() != null) this.nota = jogoAtualizado.nota();
		if(jogoAtualizado.desenvolvedor() != null) this.desenvolvedor = jogoAtualizado.desenvolvedor();
		if(jogoAtualizado.genero() != null) this.genero = jogoAtualizado.genero();
		
	}

}
