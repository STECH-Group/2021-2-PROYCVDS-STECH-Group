package edu.eci.cvds.samples.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
	private String user;
	private String passwd;
	public boolean logeado = false;
	
	public void login() {
		Subject userActual = SecurityUtils.getSubject();
		UsernamePasswordToken uPToken = new UsernamePasswordToken(getUser(), new Sha256Hash(getPasswd()).toHex());
		try{
			userActual.login(uPToken);
			userActual.getSession().setAttribute("mail", user);
			redirect();
			setLogeado(true);
		} catch (UnknownAccountException ex) {
			FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no se encuentra registrado", null);
			FacesContext.getCurrentInstance().addMessage("formulario_login:javaText", errorMessage);
            error("Unknown account");
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
            error("Wrong password");
            log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
            error("Locked account");
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
            error("Unknown error: "+ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public boolean isLogeado() {
		return logeado;
	}
	
	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}
	
	private void error(String message) {
        FacesContext.getCurrentInstance().addMessage("Shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "error"));
    }

	public void logOut() {
		setLogeado(false);
		SecurityUtils.getSubject().logout();
		try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
		} catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void redirect() {
		try {
			Subject user = SecurityUtils.getSubject();
			if (user.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrador.xhtml");
			} else if (user.hasRole("Estudiante")) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/estudiante.xhtml");
			} else if (user.hasRole("Administrativo")) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrativo.xhtml");
			} else if (user.hasRole("Egresado")) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/egresado.xhtml");
			} else if (user.hasRole("Profesor")) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/profesor.xhtml");
			}
		} catch (IOException ex) {
        	error("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
		}
	}
	
}