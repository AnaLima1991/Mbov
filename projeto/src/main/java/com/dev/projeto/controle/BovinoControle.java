package com.dev.projeto.controle;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.dev.projeto.modelos.Bovino;

import com.dev.projeto.repositorio.BovinoRepositorio;


import jakarta.validation.Valid;

@Controller
public class BovinoControle {
	
	@Autowired
	private BovinoRepositorio bovinoRepositorio;
	
	
	
	
	@GetMapping("/cliente/bovinos/cadastrar")
	public ModelAndView cadastrar(Bovino bovino) {
		ModelAndView mv =  new ModelAndView("cliente/bovinos/cadastro");
		mv.addObject("bovino",bovino);
		
		return mv;
	}
	
	@GetMapping("/cliente/bovinos/listar")
	public ModelAndView listar() {
		ModelAndView mv=new ModelAndView("cliente/bovinos/lista");
		mv.addObject("listaBovinos", bovinoRepositorio.findAll());
		return mv;
	}
	@GetMapping("/cliente/bovinos/formarLote2")
	public ModelAndView listarBovinosLote() {
		ModelAndView mv=new ModelAndView("cliente/bovinos/formarLote2");
		mv.addObject("listaBovinos", bovinoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/cliente/bovinos/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Bovino> bovino = bovinoRepositorio.findById(id);
		return cadastrar(bovino.get());
	}
	
	
	@GetMapping("/cliente/bovinos/adicionar/{id}")
	 public ModelAndView adicionar(@PathVariable("id") Long id) {
		Optional<Bovino> bovino = bovinoRepositorio.findById(id);
		ModelAndView mv =  new ModelAndView("pacote2");
		mv.addObject("bovino",bovino);
		
		return mv;
	}
	
	@GetMapping("/cliente/bovinos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Bovino> bovino = bovinoRepositorio.findById(id);
		bovinoRepositorio.delete(bovino.get());
		return listar();
	}
	
	@PostMapping("/cliente/bovinos/salvar")
	public ModelAndView salvar(@Valid Bovino bovino, BindingResult result) {
		
		if(result.hasErrors()) {
			return cadastrar(bovino);
		}
		bovinoRepositorio.saveAndFlush(bovino);
		
		return cadastrar(new Bovino());
	}

}