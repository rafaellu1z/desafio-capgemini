package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Anuncio {
	
	private Long id;
	private String nomeDoAnuncio;
	private Date dataDeInicio;
	private Date dataDeTermino;
	private Double investimentoPorDia;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Cliente cliente;

	public Anuncio() {
	}
	
	public Anuncio(Long id, String nomeDoAnuncio, Date dataDeInicio, Date dataDeTermino, Double investimentoPorDia,
			Cliente cliente) {
		this.id = id;
		this.nomeDoAnuncio = nomeDoAnuncio;
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.investimentoPorDia = investimentoPorDia;
		this.cliente = cliente;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoAnuncio() {
		return nomeDoAnuncio;
	}

	public void setNomeDoAnuncio(String nomeDoAnuncio) {
		this.nomeDoAnuncio = nomeDoAnuncio;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeTermino() {
		return dataDeTermino;
	}

	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}

	public Double getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	public void setInvestimentoPorDia(Double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public long totalDeDias() {
		long diff = dataDeTermino.getTime() - dataDeInicio.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);	
	}
	
	public double totalInvestido() {
		return (double) totalDeDias() * investimentoPorDia;
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Anuncio #" + id + "\n");
		sb.append("Nome do Anuncio: " + nomeDoAnuncio + "\n");
		sb.append("Cliente: " + cliente.getNome() + "\n");
		sb.append("Data de Inicio: " + sdf.format(dataDeInicio) + "\n");
		sb.append("Data de Termino: " + sdf.format(dataDeTermino) + "\n");
		sb.append("Numero de Dias da Campanha: " + totalDeDias() + "\n");
		sb.append("Valor de Investimento diário R$ " + String.format("%.2f%n", investimentoPorDia));
		sb.append("Total investido R$ " + String.format("%.2f", totalInvestido()));
		return sb.toString();
	}
}
