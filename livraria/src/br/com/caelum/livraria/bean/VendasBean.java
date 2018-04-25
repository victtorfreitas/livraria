package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Venda;

@Named
@ViewScoped
public class VendasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public List<Venda> getVendas(long seed){
		List<Venda> vendas = new ArrayList<Venda>();
		List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
		
		Random random = new Random(seed); 
		for (Livro livro : livros) {
			Integer quantidade = random.nextInt(500);
			vendas.add(new Venda(livro, quantidade));
		}
		return vendas;
	}
	
	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		
		ChartSeries series = new ChartSeries(); 
		
		series.setLabel("Vendas 2018");
		
		List<Venda> vendas = getVendas(1234);
		
		for (Venda venda : vendas) {
			series.set(venda.getLivro().getTitulo(),venda.getQuantidade());
		}
		model.addSeries(series);
		return model;
	}
}
