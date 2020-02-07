/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Administrador.Global;
import Entidad.Cliente;
import Entidad.Departamento;
import Entidad.Distrito;
import Servicios.ClienteServicioLocal;
import Servicios.DepartamentoServicioLocal;
import Servicios.DistritoServicioLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maicol Rodrigo
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/Cliente"})
public class ServletCliente extends HttpServlet {

    @EJB
    private DistritoServicioLocal distritoServicio;

    @EJB
    private ClienteServicioLocal clienteServicio;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String ruta = request.getParameter("ruta");
        if (ruta != null) {
            Global.ruta = Integer.parseInt(ruta);
        }
        List<Distrito> lista = listDistrtito();
        request.setAttribute("distritos", lista);
        request.getRequestDispatcher("regCliente.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String ec = request.getParameter("estadoCivil");
        String sex = request.getParameter("sexo");
        String fn = request.getParameter("fechaNacimiento");
        String distrito = request.getParameter("distrito");
        Distrito dis = this.distritoServicio.getById(Integer.parseInt(distrito));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(fn);
        } catch (ParseException ex) {
            Logger.getLogger(ServletCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean estCiv = false;
        boolean sexo = false;
        if (ec == "1") {
            estCiv = true;
        }
        if (sex == "1") {
            sexo = true;
        }
        Cliente cli = new Cliente();
        cli.setDni(request.getParameter("dni"));
        cli.setNombres(request.getParameter("nombres"));
        cli.setApellidos(request.getParameter("apellidos"));
        cli.setCorreoElectronico(request.getParameter("correo"));
        cli.setDireccion(request.getParameter("direccion"));
        cli.setDistrito(dis);
        cli.setEstadoCivil(estCiv);
        cli.setSexo(sexo);
        cli.setTelefono(request.getParameter("telefono"));
        cli.setNacionalidad(request.getParameter("nacionalidad"));
        cli.setFechaNacimiento(date);
        clienteServicio.crear(cli);
        Global.dni = request.getParameter("dni");
        request.getRequestDispatcher("addBoleto.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public List<Distrito> listDistrtito() {
        List<Distrito> lista = null;
        try {
            lista = this.distritoServicio.getAll();
        } catch (EJBException ex) {
            System.out.println(ex.getCause());
        }
        return lista;
    }

}
