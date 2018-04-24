package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;

@Named
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public String efetuaLogin() {
		System.out.println("Efetuando Login do: " + this.usuario.getEmail());
		boolean existe = new UsuarioDao().existe(usuario);
		FacesContext context = FacesContext.getCurrentInstance();

		if (existe) {
			System.out.println("Existe");
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);

			return "livro?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Usuário não encotrado"));
			return "login?faces-redirect=true";
		}
	}

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}

}
