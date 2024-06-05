package com.dev.projeto.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;


import com.dev.projeto.modelos.Bovino;

import com.dev.projeto.modelos.ItensLote;
import com.dev.projeto.modelos.Lote;
import com.dev.projeto.repositorio.BovinoRepositorio;
import com.dev.projeto.repositorio.ItensLoteRepositorio;
import com.dev.projeto.repositorio.LoteRepositorio;

@Controller
public class ControleLote {
	private List<ItensLote> itensLote = new ArrayList<ItensLote>();
	private Lote lote = new Lote();
	
	@Autowired
	private BovinoRepositorio repositorioBovino;
	@Autowired
	private LoteRepositorio repositorioLote;
	@Autowired
	private ItensLoteRepositorio repositorioItensLote;
	
	private void calcularTotal() {
		lote.setValorTotal(0);
		for (ItensLote it : itensLote) {
			lote.setValorTotal(lote.getValorTotal() + it.getQuantidade());
		}
	}
	
	@GetMapping("/pacote")
	public ModelAndView chamarPacote() {
		ModelAndView mv = new ModelAndView("cliente/bovinos/pacote");
		calcularTotal();
		mv.addObject("lote", lote);
		mv.addObject("listaBovinos",itensLote);
		
		return mv;
	}
	@GetMapping("/finalizar/confirmar")
	public ModelAndView confirmar(String forma) {
		ModelAndView mv = new ModelAndView("cliente/bovinos/formarLote2");
		
		repositorioLote.saveAndFlush(lote);

		for (ItensLote c : itensLote) {
			c.setLote(lote);
			repositorioItensLote.saveAndFlush(c);
		}
		itensLote = new ArrayList<>();
		lote = new Lote();
		return mv;
	}
	
	@GetMapping("/adicionarLote/{id}")
	public ModelAndView adicionaLote(@PathVariable Long id) {
		
		ModelAndView mv = new ModelAndView("cliente/bovinos/pacote");
		Optional<Bovino> bov=repositorioBovino.findById(id);
		Bovino bovino=bov.get();
		int controle = 0;
		for (ItensLote it : itensLote) {
			
			if (it.getBovino().getId().equals(bovino.getId())) {
				
				controle = 1;
				break;
			}
				}
		if (controle == 0) {
			
		ItensLote item= new ItensLote();
		item.setBovino(bovino);
		
		itensLote.add(item);
		}
		mv.addObject("listaItens",itensLote);
		calcularTotal();
		
		return mv;
	}
	@GetMapping("/removerBovino/{id}")
	public String removerBovinoLote(@PathVariable Long id) {

		for (ItensLote it : itensLote) {
			if (it.getBovino().getId().equals(id)) {
				itensLote.remove(it);
				break;
			}
		}

		return "redirect:/pacote";
	}
	
	
	
	

}
