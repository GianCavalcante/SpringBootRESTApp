package org.springboot.starter.venda;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {
	
	@Autowired
	VendaService vendaService;
	final Logger logger = LoggerFactory.getLogger(VendaController.class);

	@RequestMapping("/vendas")
	public List<Venda> getAllVendas() {
		logger.debug("I am in getAllVendas");
		return vendaService.getAllVendas();
	}
	
	/*@RequestMapping("/vendas/{foo}")
	public Venda getVendas(@PathVariable("foo") String id) {
		
		return vendaService.getVenda(id);
	}*/
	
	@RequestMapping("/vendas/{id}")
	public Optional<Venda> getVendas(@PathVariable String id) {
		return vendaService.getVenda(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/vendas")
	public void addVenda(@RequestBody Venda venda) {
		vendaService.addVenda(venda);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/vendas/{id}")
	public void updateVenda(@RequestBody Venda venda, @PathVariable String id) {
		logger.debug("I am in updateVenda");
		vendaService.updateVenda(id, venda);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/vendas/{id}")
	public void deleteVenda(@PathVariable String id) {
		vendaService.deleteVenda(id);
	}
}
