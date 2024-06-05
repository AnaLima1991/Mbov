package com.dev.projeto.controle;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;


import com.dev.projeto.modelos.Funcionario;

@Controller
public class LoginControle {
	

	@GetMapping("/login")
	public ModelAndView cadastrar(Funcionario Funcionario) {
		ModelAndView mv =  new ModelAndView("/login");
		
		return mv;
	}
	
	

}
