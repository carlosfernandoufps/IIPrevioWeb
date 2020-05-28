package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Servicio;
import entities.Tienda;
import dao.ServicioDao;


@WebServlet("/RegServicioController")
public class RegServicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegServicioController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("email"))
				&& esValido(request.getParameter("clave"))) {

			Servicio s = new Servicio();
			ServicioDao sd = new ServicioDao();
			Tienda t = new Tienda();

			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			
			String tienda = request.getParameter("tienda");

			t.setNombre(tienda);
			
			s.setNombre(nombre);
			s.setDescripcion(descripcion);
			
			s.setTiendaBean(t);

			sd.insert(s);
			
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
