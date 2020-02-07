    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Administrador.Global;
import Entidad.Bus;
import Entidad.Cliente;
import Entidad.Pasajes;
import Entidad.Rutas;
import Servicios.BusServicioLocal;
import Servicios.ClienteServicioLocal;
import Servicios.PasajesServicioLocal;
import Servicios.RutasServicioLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maicol Rodrigo
 */
@WebServlet(name = "ServletPasaje", urlPatterns = {"/Pasaje"})
public class ServletPasaje extends HttpServlet {

    @EJB
    private BusServicioLocal busServicio;

    @EJB
    private PasajesServicioLocal pasajesServicio;

    @EJB
    private RutasServicioLocal rutasServicio;

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
            out.println("<title>Servlet ServletPasaje</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPasaje at " + request.getContextPath() + "</h1>");
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
        String dni = request.getParameter("cliente");
        if(dni != null){
            Global.dni = dni;
        }
        Cliente cli = clienteServicio.getById(dni);
        Rutas rut = rutasServicio.getById(Global.ruta);
        request.setAttribute("cliente", cli);
        request.setAttribute("ruta", rut);
        request.getRequestDispatcher("addBoleto.jsp").forward(request, response);
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaLlegada = null;
        Date fechaPartida = null;
        String fll = request.getParameter("fechaLlegada");
        String fpa = request.getParameter("fechaPartida");
        try {
            fechaLlegada = formatter.parse(fll);
            fechaPartida = formatter.parse(fpa);
        } catch (ParseException ex) {
            Logger.getLogger(ServletCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idRuta = request.getParameter("ruta");
        String total = request.getParameter("precio");
        Bus bus = busServicio.getById(1);
        Rutas ruta = rutasServicio.getById(Integer.parseInt(request.getParameter("ruta")));
        Pasajes pas = new Pasajes();
        pas.setAsiento(request.getParameter("asiento"));
        pas.setBus(bus);
        pas.setDni(request.getParameter("dni"));
        pas.setFechaLlegada(fechaLlegada);
        pas.setFechaPartida(fechaPartida);
        pas.setRutas(ruta);
        pas.setTotal(Double.parseDouble(total));
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
