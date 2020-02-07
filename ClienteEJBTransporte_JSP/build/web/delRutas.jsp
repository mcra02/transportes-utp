<%-- Document : index Created on : 30/11/2019, 02:22:26 PM Author : maicol --%>
<%@page import="Entidad.Provincia"%>
<%@page import="Entidad.Departamento"%>
<%@page import="Entidad.Rutas"%> 
<%@page import="java.util.List"%> 
<%@include file="templates/header.jsp" %>

<div class="contenido">

    <%
        Rutas ruta =  (Rutas) request.getAttribute("ruta");
    %>

    <form action="RutasDelete" method="post">
        <input id="prodId" name="ruta" type="hidden" value="<%= ruta.getIdRuta() %>">
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Partida</label>
            </div>            
        </div>
        <div class="form-row">
            
            <div class="col-md-6 mb-3">
                <label for="validationServer02">Provincia</label>
                <select id="disabledSelect" class="form-control" name="partida" disabled>
                    
                    <option><%= ruta.getProvinciaByPartida().getProvinciaNombre() %></option>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Destino</label>
            </div>            
        </div>
        <div class="form-row">            
            <div class="col-md-6 mb-3">
                <label for="validationServer02">Provincia</label>
                <select id="disabledSelect" class="form-control" name="destino" disabled>
                    
                    <option><%= ruta.getProvinciaByDestino().getProvinciaNombre() %></option>
                    
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Precio</label>
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <input
                    type="number"
                    class="form-control is-valid"
                    id="validationServer02"
                    step="0.01"
                    name="precio"
                    value="<%=  ruta.getPrecio() %>"
                    required
                    disabled
                    />
            </div>
        </div>
        <button class="btn btn-danger" type="submit">Eliminar</button>
    </form>
</div>
<%@include file="templates/footer.jsp" %>
