package tn.essat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.essat.dao.IMagasinDao;
import tn.essat.dao.IProduitDao;
import tn.essat.model.Magasin;
import tn.essat.model.Produit;

@Controller
public class AppController {
	@Autowired
	private IMagasinDao daom;
	@Autowired
	private IProduitDao daop;
	public void setDaom(IMagasinDao daom) {
		this.daom = daom;
	}
	public void setDaop(IProduitDao daop) {
		this.daop = daop;
	}

	@GetMapping("/")
	public String get1(Model m) {
		List<Magasin> liste=daom.findAll();
		m.addAttribute("liste", liste);
		return "accueil";
	}
	@GetMapping("/produits/{id}")
	public String get2(Model m ,@PathVariable("id") int id) {
		List<Produit> liste=daop.getProduitsByCat(id);
		m.addAttribute("liste", liste);
		return "produits";
	}
	@GetMapping("/ajoutProduit")
	public String get3(Model m) {
		Produit p=new Produit();
		List<Magasin> liste=daom.findAll();
		m.addAttribute("liste", liste);
		m.addAttribute("p", p);
		return "FormAdd";
	}
	@PostMapping("/saveProduit")
	public String get4(Model m,@ModelAttribute("p") Produit p) {
		daop.save(p);
		return "redirect:/home";
	}
	@GetMapping("/deleteProduit/{id}")
	public String get5(Model m,@PathVariable("id") int id) {
		daop.deleteById(id);
		return "redirect:/";
	}
}
