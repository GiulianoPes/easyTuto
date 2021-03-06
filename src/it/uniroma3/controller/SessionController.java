package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;
import it.uniroma3.model.UtenteFacade;

@ManagedBean
@SessionScoped
public class SessionController{

	Utente utenteLogged;
	String username;
	String password;

	@EJB
	private UtenteFacade utenteFacade;

	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.utenteLogged = utenteFacade.findByCredentials(username, password);
		if(this.utenteLogged != null){
			context.getExternalContext().getSessionMap().put("utenteLogged", utenteLogged);			
		}
		return "index.xhtml";
	}
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.utenteLogged = null;
		context.getExternalContext().getSessionMap().remove("utenteLogged");
		System.out.println("LOGOUT------------------------------");
		return "index.xhtml";
	}
	
	public void addFollowing(){
		System.out.println("------ID------");
		//this.utenteLogged.addFollowing(utente);
		//System.out.println("aggiungo follow "+utente.getUsername());
		//this.utenteLogged = utenteFacade.update(utenteLogged);
		
	}
	//Get & Set

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Utente getUtenteLogged() {
		return utenteLogged;
	}
	
	public void setUtenteLogged(Utente utenteLogged) {
		this.utenteLogged = utenteLogged;
	}
}
