package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.interfacesService.IpersonaService;
import com.crud.modelo.Persona;


@Controller
@RequestMapping
public class ControladorPersona {
	
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas = service.listar();
		model.addAttribute("personas",personas);
		
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		
		return "form";
		
	}
	
	@PostMapping("/save")
	public String save( Persona p,Model model) {
		service.save(p);
		
		return "redirect:/listar";
		
	}
	
	@GetMapping("/editar/{idPersona}")
	public String editar(@PathVariable int idPersona,Model model) {
		Optional<Persona>persona = service.listarId(idPersona);
		model.addAttribute("persona",persona);
		
		return "form";
	}
	
	
	@GetMapping("/eliminar/{idPersona}")
	public String eliminar(Model model, @PathVariable int idPersona) {
		
		service.delete(idPersona);
		
		return "redirect:/listar";
	}
	
	

}
