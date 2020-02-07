<%-- Document : header Created on : 30/11/2019, 02:11:20 PM Author : Maicol
Rodrigo --%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Transporte UTP</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="icon" type="image/png" href="utils/img/utp.png" />

    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />

    <link rel="stylesheet" href="utils/css/style_header.css" />
  </head>
  <body>
    <div class="menu">
      <div class="nav-side-menu">
        <div class="brand">
          <img
            style="width: 50px; height: 50px; padding: 10px;"
            src="utils/img/utp.png"
            alt=""
          />
        </div>
        <i
          class="fa fa-bars fa-2x toggle-btn"
          data-toggle="collapse"
          data-target="#menu-content"
        ></i>

        <div class="menu-list">
          <ul id="menu-content" class="menu-content collapse out">
            <li>
              <a href="Rutas">
                <i class="fa fa-dashboard fa-lg"></i> Dashboard
              </a>
            </li>

            <li>
              <a href="Cliente"> <i class="fa fa-user fa-lg"></i> Cliente </a>
            </li>

            <li>
              <a href="Pasaje"> <i class="fa fa-plane fa-lg"></i> Pasaje </a>
            </li>

            <li>
              <a href="#"> <i class="fa fa-money fa-lg"></i> Pago </a>
            </li>

            <li>
              <a href="#"> <i class="fa fa-print fa-lg"></i> Boleto </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </body>
</html>
