package com.dev.projeto.controle;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.projeto.modelos.Insumo;
import com.dev.projeto.modelos.ItensProtocolo;
import com.dev.projeto.modelos.Permissao;
import com.dev.projeto.modelos.Protocolo;
import com.dev.projeto.repositorio.InsumoRepositorio;
import com.dev.projeto.repositorio.ItensProtocoloRepositorio;
import com.dev.projeto.repositorio.ProtocoloRepositorio;

import jakarta.validation.Valid;

@Controller
public class ProtocoloControle{
	List<ItensProtocolo> itensProtocolo = new ArrayList<ItensProtocolo>();
	private Protocolo protocolo = new Protocolo();
	List<Insumo> listaInsumo = new ArrayList<Insumo>();
	@Autowired
	private InsumoRepositorio repositorioInsumo ;
	@Autowired
	private ProtocoloRepositorio repositorioProtocolo;
	@Autowired
	private ItensProtocoloRepositorio repositorioItensProtocolo;
	
	
	
	@GetMapping("/cliente/protocolo/cadastrar")
	public ModelAndView cadastrar(ItensProtocolo itensProtocolo) {
		ModelAndView mv = new ModelAndView("cliente/protocolo/cadastro");
		listaInsumo=repositorioInsumo.findAll();
		
		mv.addObject("protocolo", protocolo);
		mv.addObject("itemProtocolo", itensProtocolo);
		mv.addObject("listaInsumos",listaInsumo);
		
		return mv;
	}
	@GetMapping("/cliente/protocolo/confirmar")
	public ModelAndView confirmar() {
		ModelAndView mv = new ModelAndView("");
		
		repositorioProtocolo.saveAndFlush(protocolo);

		for (ItensProtocolo c : itensProtocolo) {
			c.setProtocolo(protocolo);
			repositorioItensProtocolo.saveAndFlush(c);
		}
		itensProtocolo = new ArrayList<>();
		protocolo = new Protocolo();
		return mv;
	}
	
	@GetMapping("/cliente/protocolo/adicionar")
	public ModelAndView adicionaItemProtocolo(@Valid ItensProtocolo itensProtocolo, BindingResult result){
		
		ModelAndView mv = new ModelAndView("cliente/protocolo/cadastro");
		List<ItensProtocolo> itensProtocolo2 = new ArrayList<ItensProtocolo>();
		
		if(result.hasErrors()) {
			return cadastrar(itensProtocolo);
		}
		itensProtocolo2.add(itensProtocolo);
	    
		
		mv.addObject("listaItens2",itensProtocolo2);
				
		return mv;
	}
	@GetMapping("/removerItemProtocolo/{id}")
	public String removerInsumoProtocolo(@PathVariable Long id) {

		for (ItensProtocolo it : itensProtocolo) {
			if (it.getInsumo().getId().equals(id)) {
				itensProtocolo.remove(it);
				break;
			}
		}

		return "redirect:/pacote";
	}
	

	@PostMapping("/cliente/protocolo/salvar")
	public ModelAndView salvar(@Valid ItensProtocolo itemProtocolo, BindingResult result) {
		
		
		
		return cadastrar(new ItensProtocolo());
	}
	
	
	
	

}

	
	

