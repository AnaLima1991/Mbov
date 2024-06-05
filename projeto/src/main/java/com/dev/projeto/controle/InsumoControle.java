package com.dev.projeto.controle;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.dev.projeto.modelos.Insumo;
import com.dev.projeto.repositorio.InsumoRepositorio;

import jakarta.validation.Valid;

@Controller
public class InsumoControle {
	
	@Autowired
	private InsumoRepositorio insumoRepositorio;
	
	
	
	
	@GetMapping("/administrativo/insumos/cadastrar")
	public ModelAndView cadastrar(Insumo insumo) {
		ModelAndView mv =  new ModelAndView("administrativo/insumos/cadastro");
		mv.addObject("insumo",insumo);
		return mv;
	}
	
	@GetMapping("/administrativo/insumos/listar")
	public ModelAndView listar() {
		ModelAndView mv=new ModelAndView("administrativo/insumos/lista");
		mv.addObject("listaInsumos", insumoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/insumos/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Insumo> insumo = insumoRepositorio.findById(id);
		return cadastrar(insumo.get());
	}
	
	@GetMapping("/administrativo/insumos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Insumo> insumo = insumoRepositorio.findById(id);
		insumoRepositorio.delete(insumo.get());
		return listar();
	}
	
	@PostMapping("/administrativo/insumos/salvar")
	public ModelAndView salvar(@Valid Insumo insumo, BindingResult result) {
		
		if(result.hasErrors()) {
			return cadastrar(insumo);
		}
		insumoRepositorio.saveAndFlush(insumo);
		
		return cadastrar(new Insumo());
	}
	

}