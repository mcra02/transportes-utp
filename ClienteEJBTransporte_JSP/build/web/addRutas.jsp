<%-- Document : index Created on : 30/11/2019, 02:22:26 PM Author : maicol --%>
<%@page import="Entidad.Provincia"%>
<%@page import="Entidad.Departamento"%>
<%@page import="Entidad.Rutas"%> 
<%@page import="java.util.List"%> 
<%@include file="templates/header.jsp" %>

<div class="contenido">

    <%
        List<Departamento> deps = (List<Departamento>) request.getAttribute("departamentos");
        List<Provincia> pro = (List<Provincia>) request.getAttribute("provincias");
    %>

    <form action="RutasAdd" method="post">
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Partida</label>
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Departamento</label>
                <select id="disabledSelect" class="form-control">
                    <%
                        for (Departamento aux : deps) {
                    %>
                    <option><%= aux.getDepartamentoNombre() %></option>
                    <% }%>
                </select>
            </div>
            <div class="col-md-6 mb-3">
                <label for="validationServer02">Provincia</label>
                <select id="disabledSelect" class="form-control" name="partida">
                    <%
                        for (Provincia auxi : pro) {
                    %>
                    <option value="<%= auxi.getIdProvincia() %>"><%= auxi.getProvinciaNombre() %></option>
                    <% }%>
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
                <label for="validationServer01">Departamento</label>
               <select id="disabledSelect" class="form-control">
                    <%
                        for (Departamento aux : deps) {
                    %>
                    <option><%= aux.getDepartamentoNombre() %></option>
                    <% }%>
                </select>
            </div>
            <div class="col-md-6 mb-3">
                <label for="validationServer02">Provincia</label>
                <select id="disabledSelect" class="form-control" name="destino">
                    <%
                        for (Provincia auxi : pro) {
                    %>
                    <option value="<%= auxi.getIdProvincia() %>"><%= auxi.getProvinciaNombre() %></option>
                    <% }%>
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
                    required
                    />
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Agregar</button>
    </form>
</div>
<%@include file="templates/footer.jsp" %>
