<header class="container-fluid">
  <nav class="navbar navbar-expand-lg">
    <ul class="navbar-nav primary">
      <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Incicio</a></li>
      <li class="nav-item"><a class="nav-link"
          href="${pageContext.request.contextPath}/${URL_BASE}/ConveniosControlador?opcao=cancelar">Convenios</a> </li>
      <li class="nav-item"><a class="nav-link"
          href="${pageContext.request.contextPath}/${URL_BASE}/EquipamentosControlador?opcao=cancelar">Equipamentos</a>
      </li>
      <li class="nav-item"><a class="nav-link"
          href="${pageContext.request.contextPath}/${URL_BASE}/ExamesControlador?opcao=cancelar">Exames</a></li>
      <li class="nav-item"><a class="nav-link"
          href="${pageContext.request.contextPath}/${URL_BASE}/RemediosControlador?opcao=cancelar">Remedios</a></li>
      <li class="nav-item"><a class="nav-link"
          href="${pageContext.request.contextPath}/${URL_BASE}/SalasControlador?opcao=cancelar">Salas</a></li>
      <li class="nav-item"><a class="nav-link"
          href="${pageContext.request.contextPath}/${URL_BASE}/TipopacienteControlador?opcao=cancelar">Tipopaciente</a>
      </li>
      <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/Login.jsp">LOGIN</a></li>
      <li class="nav-item"><a class="nav-link"
          href="${pageContext.request.contextPath}/${URL_BASE}/LogOutControlador">LOGOUT</a></li>
    </ul>
  </nav>
  <%-- ${pageContext.request.contextPath} ${URL_BASE} --%>
</header>
