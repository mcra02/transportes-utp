/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Entidad.Departamento;
import Entidad.Provincia;
import Entidad.Rutas;
import Servicios.DepartamentoServicioLocal;
import Servicios.ProvinciaServicioLocal;
import Servicios.RutasServicioLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "RutasDelete", urlPatterns = {"/RutasDelete"})
public class RutasDelete extends HttpServlet {

    @EJB
    private DepartamentoServicioLocal departamentoServicio;

    @EJB
    private ProvinciaServicioLocal provinciaServicio;

    @EJB
    private RutasServicioLocal rutasServicio;

    
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
            out.println("<title>Servlet RutasDelete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RutasDelete at " + request.getContextPath() + "</h1>");
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
        Rutas ruta = new Rutas();
        String id = request.getParameter("ruta");
        try {
            ruta = this.rutasServicio.getById(Integer.parseInt(id));
            request.setAttribute("ruta", ruta);
            request.getRequestDispatcher("delRutas.jsp").forward(request, response);
        } catch (EJBException ex) {
            System.out.println(ex.getCause());
        }
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
        Rutas ruta = new Rutas();
        String id = request.getParameter("ruta");
        try {
            ruta = this.rutasServicio.getById(Integer.parseInt(id));
            this.rutasServicio.eliminar(ruta);
            request.getRequestDispatcher("Rutas").forward(request, response);
        } catch (EJBException ex) {
            System.out.println(ex.getCause());
        }
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

}
