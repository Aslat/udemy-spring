package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("app")
public class IndexController {

	@GetMapping({"/index", "/","", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring framework!");
		
		return "index";	
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Javier");
		usuario.setApellido("Villegas");
		usuario.setEmail("javier@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {


		
		model.addAttribute("titulo", "Listado de usuarios");
		
		return "listar";
	}
	
	//Sirve para pasar atributos a todas las vistas
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Javier", "Villegas", "javier.villegas@mail.com"), 
				new Usuario("John", "Doe", "john.doe@mail.com"),
				new Usuario("Jane", "Done", "jane.doe@mail.com"));
	
		return usuarios;
	}
	
	
}
