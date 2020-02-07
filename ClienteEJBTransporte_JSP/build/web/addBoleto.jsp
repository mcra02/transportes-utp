<%-- Document : index Created on : 30/11/2019, 02:22:26 PM Author : maicol --%>

<%@page import="Entidad.Cliente"%>
<%@page import="Entidad.Rutas"%> 
<%@page import="java.util.List"%> 
<%@include file="templates/header.jsp" %>

<div class="contenido">

    <%
        Rutas rut = (Rutas) request.getAttribute("ruta");
        Cliente cli = (Cliente) request.getAttribute("cliente");
        List<Rutas> rutas = (List<Rutas>) request.getAttribute("rutas");
    %>

    <form action="Pasaje" method="post">   
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Cliente</label>                
            </div>
        </div>
        <%
            if (cli != null) {
        %>
        <input id="prodId" name="cliente" type="hidden" value="<%= cli.getDni()%>">
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Nombre</label>
                <input
                    type="text"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="<%= cli.getNombres()%>"
                    name="precio"
                    required
                    disabled
                    />              
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Dni</label>
                <input
                    type="number"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="<%= cli.getDni()%>"
                    name="precio"
                    required
                    disabled
                    />              
            </div>
        </div>
        <% } else { %>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Dni</label>
                <input
                    type="number"
                    class="form-control is-valid"
                    id="validationServer02"
                    name="cliente"
                    required
                    />              
            </div>
        </div>
        <% }
            if (rut != null) {
        %>
        <input id="prodId" name="ruta" type="hidden" value="<%= rut.getIdRuta()%>">
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Partida</label>
                <input
                    type="text"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="<%= rut.getProvinciaByPartida().getProvinciaNombre()%>"
                    name="precio"
                    required
                    disabled
                    />              
            </div>
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Destino</label>
                <input
                    type="text"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="<%= rut.getProvinciaByDestino().getProvinciaNombre()%>"
                    name="precio"
                    required
                    disabled
                    />              
            </div>                    
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Precio</label>
                <input
                    type="number"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="<%= rut.getPrecio()%>"
                    name="bus"
                    required
                    disabled
                    />              
            </div>
        </div>
        <% } else { %>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Rutas</label>
                <select multiple class="form-control" id="exampleFormControlSelect2" name="ruta">
                    <% for (Rutas aux : rutas) {%>
                    <option value="<%= aux.getIdRuta()%>"><%= aux.getProvinciaByPartida().getProvinciaNombre()%> - <%=  aux.getProvinciaByDestino().getProvinciaNombre()%> - <%= aux.getPrecio()%></option>
                    <% } %>
                </select>              
            </div>
        </div>
        <% }%>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Bus</label>
                <input
                    type="text"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="V7X-115"
                    name="bus"
                    required
                    disabled
                    />              
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Fecha Partida</label>
                <input
                    type="date"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="1"
                    name="fechaPartida"
                    required
                    disabled
                    />              
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Fecha Llegada</label>
                <input
                    type="date"
                    class="form-control is-valid"
                    id="validationServer02"
                    value="1"
                    name="fechaLlegada"
                    required
                    disabled
                    />              
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Asiento (PAR = VENTANA - IMPAR = PASILLO)</label>
                <select multiple class="form-control" id="exampleFormControlSelect2" name="asiento">
                    <%
                        int num = 0;
                        while (num < 60) { %>
                        <option value="num">num</option>
                    <% num += 1;
                        }%>
                </select>            
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Pagar</button>
    </form>
</div>
<%@include file="templates/footer.jsp" %>