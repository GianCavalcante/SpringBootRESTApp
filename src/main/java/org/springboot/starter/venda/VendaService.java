package org.springboot.starter.venda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
	
	@Autowired
	VendaRepository vendaRepository;
	
	/*private List<Venda> vendas = new ArrayList<>(Arrays.asList(
			new Venda("Spring", "Spring Framework", "Spring Framework Description"),
			new Venda("Java", "Java Programming", "Java Programming Description"),
			new Venda("JavaScript", "JavaScript Framework", "JavaScript Framework Description")			
			));*/
	
	public List<Venda> getAllVendas() {
		List<Venda> vendas = new ArrayList<Venda>();
		vendaRepository.findAll().forEach(vendas::add);
		return vendas;
	}
	
	public Optional<Venda> getVenda(String id) {
		return vendaRepository.findById(id);
	}
	
	public void addVenda(Venda venda) {
		vendaRepository.save(venda);
	}
	
	public void updateVenda(String id, Venda venda) {
		vendaRepository.save(venda);
	}
	
	public void deleteVenda(String id) {
		vendaRepository.deleteById(id);
	}
	
	/*public Venda getVenda(String id) {
		return vendas.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addVenda(Venda venda) {
		vendas.add(venda);
	}

	public void updateVenda(String id, Venda venda) {

		for(int i = 0; i < vendas.size(); i++) {
			
			Venda t = vendas.get(i);
			if(t.getId().equals(id)) {
				System.out.println("ID is -> " + t.getId());
				vendas.set(i, venda);
				return;
			}
		}
		
	}

	public void deleteVenda(String id) {
		vendas.removeIf(t -> t.getId().equals(id));
		
	}*/

}
