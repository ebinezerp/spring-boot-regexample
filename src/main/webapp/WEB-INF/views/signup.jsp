<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<section id="signupform" class="col-sm-4 offset-sm-4">

<springform:form modelAttribute="userAccount" method="post" action="${contextPath}/signup" class="form">
<span style="color:red">${signup_error}</span>
<div class="form-group">
  <springform:input path="fullName" type="text" name="fullName" id="fullName" class="form-control" placeholder="Full Name" aria-describedby="helpId"/>
  <small id="helpId" class="text-muted"><springform:errors path="fullName"></springform:errors></small>
</div>
<div class="form-group">
    <springform:input path="email" type="email" name="email" id="email" class="form-control" placeholder="Email" aria-describedby="helpId"/>
    <small id="helpId" class="text-muted"><springform:errors path="email"></springform:errors></small>
  </div>
  <div class="form-group">
    <springform:input path="mobile" type="tel" name="mobile" id="mobile" class="form-control" placeholder="Mobile" aria-describedby="helpId"/>
    <small id="helpId" class="text-muted"><springform:errors path="mobile"></springform:errors></small>
  </div>
  <div class="form-group">
    <springform:input path="password" type="password" name="password" id="password" class="form-control" placeholder="Password" aria-describedby="helpId"/>
    <small id="helpId" class="text-muted"><springform:errors path="password"></springform:errors></small>
  </div>
  <div class="form-group">
   <input type="submit" value="SignUp" class="form-control btn btn-primary col-sm-3 offset-md-4">
  </div>
  



</springform:form>

</section>