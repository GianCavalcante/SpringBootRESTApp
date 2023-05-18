package org.springboot.starter.vendedor;

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
public class VendedorController {
	
	@Autowired
	VendedorService vendedorService;
	final Logger logger = LoggerFactory.getLogger(VendedorController.class);

	@RequestMapping("/vendedores")
	public List<Vendedor> getAllVendedores() {
		logger.debug("I am in getAllVendedores");
		return vendedorService.getAllVendedores();
	}
	
	/*@RequestMapping("/vendedores/{foo}")
	public Vendedor getVendedores(@PathVariable("foo") String id) {
		
		return vendedorService.getVendedor(id);
	}*/
	
	@RequestMapping("/vendedores/{id}")
	public Optional<Vendedor> getVendedores(@PathVariable String id) {
		return vendedorService.getVendedor(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/vendedores")
	public void addVendedor(@RequestBody Vendedor vendedor) {
		vendedorService.addVendedor(vendedor);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/vendedores/{id}")
	public void updateVendedor(@RequestBody Vendedor vendedor, @PathVariable String id) {
		logger.debug("I am in updateVendedor");
		vendedorService.updateVendedor(id, vendedor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/vendedores/{id}")
	public void deleteVendedor(@PathVariable String id) {
		vendedorService.deleteVendedor(id);
	}

}
