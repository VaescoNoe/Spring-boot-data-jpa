package com.vaescode.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vaescode.springboot.app.models.dao.IClienteDao;
import com.vaescode.springboot.app.models.entity.Cliente;

@Controller
public class ClienteControllers {
	
	@Autowired
	@Qualifier("ClienteDaoJPA")
	private IClienteDao clienteDao;
	
	@GetMapping("/listar/clientes")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar/clientes";
	}
	
	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		
		return "form";
	}
	
	
	@PostMapping("/form")
	public String guardar(Cliente cliente) {
		return "";
	}
	
}
