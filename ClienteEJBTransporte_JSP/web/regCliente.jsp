<%-- Document : index Created on : 30/11/2019, 02:22:26 PM Author : Maicol Rodrigo --%>

<%@page import="Entidad.Cliente"%>
<%@page import="Entidad.Distrito"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="Entidad.Rutas"%>
<%@page import="java.util.List"%>
<%@include file="templates/header.jsp" %>

<div class="contenido">

    <%
        List<Distrito> dis = (List<Distrito>) request.getAttribute("distritos");
        Cliente cli = (Cliente) request.getAttribute("cliente");
    %>

    <form action="ClienteSearch" method="post">
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">REGISTRADO ANTERIORMENTE</label>
            </div>            
        </div>  
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">DNI</label>
                <input type="number" id="disabledTextInput" class="form-control" placeholder="Telefono" name="dni">
            </div>            
        </div>      

        <button class="btn btn-primary" type="submit">Buscar</button>
    </form>
    <br>
    <% if (cli == null) { %>
    <br>
    <form action="Cliente" method="post">
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">NUEVO REGISTRO</label>
            </div>            
        </div> 
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">DNI</label>
                <input type="number" id="disabledTextInput"  class="form-control" placeholder="DNI" name="dni">
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Nombres</label>
                <input type="text" id="disabledTextInput"  class="form-control" placeholder="Nombres" name="nombres">
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Apellidos</label>
                <input type="text" id="disabledTextInput"  class="form-control" placeholder="Apellidos" name="apellidos">
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Direccion</label>
                <input type="text" id="disabledTextInput"  class="form-control" placeholder="Direccion" name="direccion">
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Lugar Nacimiento</label>
                <select id="disabledSelect" class="form-control" name="distrito">

                    <%
                        for (Distrito aux : dis) {

                    %>
                    <option value="<%= aux.getIdDistrito()%>"><%= aux.getDistritoNombre()%></option>
                    <% }%>
                </select>
            </div>

            <div class="col-md-6 mb-3">
                <label for="validationServer01">Nacionalidad</label>
                <input type="text" id="disabledTextInput" class="form-control" placeholder="Nacionalidad" name="nacionalidad">
            </div>             
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Fecha Nacimiento</label>
                <input type="date" id="disabledTextInput" class="form-control" placeholder="Fecha Nacimiento" name="fechaNacimiento">
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Sexo</label>
                <select id="disabledSelect" class="form-control" name="sexo">

                    <option value="1">Hombre</option>
                    <option value="0">Mujer</option>
                </select>
            </div>
            <div class="col-md-6 mb-3">
                <label for="validationServer01">Estado Civil</label>
                <select id="disabledSelect" class="form-control" name="estadoCivil">

                    <option value="1">Casado</option>
                    <option value="0">Soltero</option>
                </select>
            </div>             
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Telefono</label>
                <input type="number" id="disabledTextInput"  class="form-control" placeholder="Telefono" name="telefono">
            </div>            
        </div>
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Correo</label>
                <input type="email" id="disabledTextInput"  class="form-control" placeholder="Correo" name="correo">
            </div>            
        </div>

        <button class="btn btn-primary" type="submit">Registrarse</button>
    </form>
    <% } else { %>
    <div class="card" style="width: 18rem;">
        <div class="card-header">
            Cliente
        </div>
        <ul class="list-group list-group-flush">            
            <li class="list-group-item"><%= cli.getDni() %></li>
            <li class="list-group-item"><%= cli.getNombres() %></li>
            <li class="list-group-item"><%= cli.getApellidos() %></li>
            <li class="list-group-item"><%= cli.getNacionalidad() %></li>
            <li class="list-group-item"><a class="btn btn-primary" href="Pasaje?cliente=<%= cli.getDni() %>" role="button">Comprar Pasaje</a></li>
        </ul>
        
    </div>
    <% }%>
</div>
<%@include file="templates/footer.jsp" %>