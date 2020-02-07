<%-- Document : index Created on : 30/11/2019, 02:22:26 PM Author : Maicol Rodrigo --%>
<%@page import="Entidad.Rutas"%>
<%@page import="java.util.List"%>
<%@include file="templates/header.jsp" %>

<div class="contenido">
    <a class="btn btn-success" href="RutasAdd" role="button">Agregar</a>
    <div id="somediv"></div>
    <%
        List<Rutas> rut = (List<Rutas>) request.getAttribute("rutas");
        for (Rutas aux : rut) {
    %>

    <!--<img class="img-home" src="utils/img/utp.png" alt="" sizes="" srcset="" />-->
    <div class="card">
        <div class="card-header">
            <%= aux.getProvinciaByPartida().getProvinciaNombre() %> - <%= aux.getProvinciaByDestino().getProvinciaNombre() %>
        </div>
        <div class="card-body">
            <h5 class="card-title"> <%= aux.getProvinciaByDestino().getProvinciaNombre() %> </h5>
            <p class="card-text">
                <%= aux.getPrecio()%>
            </p>
            <a href="Cliente?ruta=<%= aux.getIdRuta() %>" class="btn btn-primary">Comprar</a>
            <a href="RutasEdit?ruta=<%= aux.getIdRuta() %>" class="btn btn-secondary">Editar</a>
            <a href="RutasDelete?ruta=<%= aux.getIdRuta() %>" class="btn btn-danger">Eliminar</a>
        </div>
    </div>

    <% } %>
</div>
<%@include file="templates/footer.jsp" %>