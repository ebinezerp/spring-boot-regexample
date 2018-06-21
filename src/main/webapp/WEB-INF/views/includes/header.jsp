<nav class="navbar sticky-top navbar-dark bg-primary" id="mainnav">
<h1><a href="#">Organisation Logo</a></h1>
<ul>
 <c:if test="${userAccount==null}">
	<li><a href="${contextPath}/signup">Sign Up</a></li>
	<li><a href="${contextPath}/login">Login</a></li>
</c:if>

  <c:if test="${userAccount!=null}">
  <li><a href="${contextPath}/logout">Logout</a></li>
  </c:if>

</ul>
</nav>