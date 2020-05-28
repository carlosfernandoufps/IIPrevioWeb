package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cliente;
import dao.ClienteDao;


@WebServlet("/RegClienteController")
public class RegClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegClienteController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("email"))
				&& esValido(request.getParameter("clave"))) {

			Cliente c = new Cliente();
			ClienteDao cd = new ClienteDao();

			String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			String clave = request.getParameter("clave");

			c.setNombre(nombre);
			c.setEmail(email);
			c.setClave(clave);

			cd.insert(c);
			
			response.sendRedirect("index.jsp?estado=Success");
		} else {
			response.sendRedirect("index.jsp?estado=Fail");
		}
	}

	public <T> boolean esValido(T valor) {
		if (valor == null) {
			return false;
		}
		return valor != "";
	}
}
