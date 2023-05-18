package org.springboot.starter.vendedor;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springboot.starter.venda.Venda;
import org.springboot.starter.venda.VendaRepository;
import org.springboot.starter.venda.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {
	
	@Autowired
	VendedorRepository vendedorRepository;
	@Autowired
	VendaRepository vendaRepository;	
	
	/*private List<Vendedor> vendedores = new ArrayList<>(Arrays.asList(
			new Vendedor("Spring", "Spring Framework", "Spring Framework Description"),
			new Vendedor("Java", "Java Programming", "Java Programming Description"),
			new Vendedor("JavaScript", "JavaScript Framework", "JavaScript Framework Description")			
			));*/
	public double getTotalVendasPorVendedor(String id) {
		List<Venda> vendas = new ArrayList<Venda>();
		vendaRepository.findAll().forEach(vendas::add);
        Map<String, Double> sum = vendas.stream().collect(
                Collectors.groupingBy(Venda::getIdVendedor, Collectors.summingDouble(Venda::getValor)));
        
		return sum.get(id);
	}	
	
	public double getMediaDiariaPorVendedor(String id) {
		List<Venda> vendas = new ArrayList<Venda>();
		vendaRepository.findAll().forEach(vendas::add);
		List<Venda> vendasVendedor = vendas.stream().filter(v -> v.getIdVendedor().equals(id)).collect(Collectors.toList());
		Map<String, Long> counting = vendasVendedor.stream().collect(
				Collectors.groupingBy(Venda::getData, Collectors.counting()));
        Map<String, Double> sum = vendasVendedor.stream().collect(
                Collectors.groupingBy(Venda::getIdVendedor, Collectors.summingDouble(Venda::getValor)));		
		double media = sum.get(id) / counting.size();
		
		return media;
	}		
	
	public List<Vendedor> getAllVendedores() {
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		vendedorRepository.findAll().forEach(vendedores::add);
		for (int i=0; i<vendedores.size(); i++) {
			vendedores.get(i).setTotalVendas(getTotalVendasPorVendedor(vendedores.get(i).getId()));
			vendedores.get(i).setMediaDiariaVendas(getMediaDiariaPorVendedor(vendedores.get(i).getId()));
		}
		
		return vendedores;
	}
	
	public Optional<Vendedor> getVendedor(String id) {
		return vendedorRepository.findById(id);
	}
	
	public void addVendedor(Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}
	
	public void updateVendedor(String id, Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}
	
	public void deleteVendedor(String id) {
		vendedorRepository.deleteById(id);
	}
	
	
	/*public Vendedor getVendedor(String id) {
		return vendedores.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}

	public void updateVendedor(String id, Vendedor vendedor) {

		for(int i = 0; i < vendedores.size(); i++) {
			
			Vendedor t = vendedores.get(i);
			if(t.getId().equals(id)) {
				System.out.println("ID is -> " + t.getId());
				vendedores.set(i, vendedor);
				return;
			}
		}
		
	}

	public void deleteVendedor(String id) {
		vendedores.removeIf(t -> t.getId().equals(id));
		
	}*/

}
