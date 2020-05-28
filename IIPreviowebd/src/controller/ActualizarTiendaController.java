package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TiendaDao;
import entities.Tienda;

/**
 * Servlet implementation class ActualizarTiendaController
 */
@WebServlet("/ActualizarTiendaController")
public class ActualizarTiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("email"))
				&& esValido(request.getParameter("clave"))) {

			Tienda t = new Tienda();
			TiendaDao td = new TiendaDao();

			String nombre = request.getParameter("nombre");
			String lema = request.getParameter("lema");
			String descripcion = request.getParameter("descripcion");
			String clave = request.getParameter("clave");
			String propietario = request.getParameter("propietario");
			String email = request.getParameter("email");
			String facebook = request.getParameter("facebook");
			String web = request.getParameter("web");
			String imagen = request.getParameter("imagen");

			t.setNombre(nombre);
			t.setLema(lema);
			t.setDescripcion(descripcion);
			t.setClave(clave);
			t.setPropietario(propietario);
			t.setEmail(email);
			t.setFacebook(facebook);
			t.setWeb(web);
			t.setImagen(imagen);

			td.update(t);
			
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
