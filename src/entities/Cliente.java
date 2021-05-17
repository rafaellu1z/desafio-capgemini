package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private Long id;
	private String nome;
	
	private List<Anuncio> anuncios = new ArrayList<>();
	
	public Cliente() {
	}

	public Cliente(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}
	
	public void adicionaAnuncio(Anuncio anuncio) {
		anuncios.add(anuncio);
	}
	
	public void removeAnuncio(Anuncio anuncio) {
		anuncios.remove(anuncio);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: " + nome + "\n");
		sb.append("Número de Anuncios cadastrados: " + anuncios.size() + "\n\n");
		for (Anuncio item : anuncios) {
			sb.append(item + "\n\n");
		}
		return sb.toString();
	}
}
