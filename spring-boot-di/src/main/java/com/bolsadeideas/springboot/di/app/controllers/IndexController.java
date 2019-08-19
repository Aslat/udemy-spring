package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier("miServicioSimple")
	private IServicio servicio;
	
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		
		return "index";
	}

	//El constructor lo inyecta automaticamente, no hace falta el autowired
	//@Autowired
//	public IndexController(IServicio servicio) {
//		super();
//		this.servicio = servicio;
//	}

//	@Autowired
//	public void setServicio(IServicio servicio) {
//		this.servicio = servicio;
//	}
	
	
	
}
