package questao9.util;

import java.util.Arrays;
import java.util.List;

import questao9.model.Produto;

public class ProdutoAleatorio {

	public Produto gerarProduto(Integer index) {

		List<Produto> produtos = Arrays.asList(new Produto("Teclado", "Logitech MK220", 30.00),
				new Produto("Mouse", "Logitech MK220", 20.00), 
				new Produto("Monitor", "Dell P2219H", 210.00),
				new Produto("Monitor", "Logitech P2422H", 270.00), 
				new Produto("Smartphone", "Samsung A32", 300.00),
				new Produto("Smartphone", "Samsung S22", 800.00),
				new Produto("Kit Mouse/Teclado", "Dell Pro KM5221W", 40.00),
				new Produto("Headset", "Logitech H390", 50.00), 
				new Produto("Headset", "JBL Quantum 100", 20.00),
				new Produto("Impressora", "Epson L3150", 100.00), 
				new Produto("Impressora", "HP DeskJet 2774", 75.00),
				new Produto("SmartTV", "Samsung 50AU7700", 230.00),
				new Produto("SmartTV", "LG 4K UHD 50UP7750", 300.00), 
				new Produto("Nobreak", "SMS 1220VA", 120.00),
				new Produto("Nobreak", "Intelbras", 87.00), 
				new Produto("Smartphone", "Poco M4 Pro", 175.00),
				new Produto("SmartTV", "Philco PTV32G70RCH", 270.00),
				new Produto("SmartTV", "AOC Roku 43S5195/78", 410.00), 
				new Produto("Smartphone", "Moto G60", 320.00),
				new Produto("Mouse", "Microsoft Sem fio", 27.00));

		return produtos.get(index);
	}
}
