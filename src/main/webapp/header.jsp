
<%@page import="dto.User"%>
<%User user1=(User)session.getAttribute("user");%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom navbarcustom">
	<a class="navbar-brand" href="#">
	<i class="fa fa-book" aria-hidden="true"></i>EcoSphere</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
	<%if(user1==null){%>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="index.jsp"><i
					class="fa fa-home" aria-hidden="true"></i>Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="login.jsp">
			<i class="fa fa-plus" aria-hidden="true"></i>Take Action</a>
			</li>

			<li class="nav-item"><a class="nav-link " href="login.jsp">
			<i class="fa fa-eye" aria-hidden="true"></i>
			show Notes</a></li>
		</ul>
		<%}else{%>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="index.jsp"><i
					class="fa fa-home" aria-hidden="true"></i>Home<span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="myGHGSaving.jsp">
			<i class="fa fa-plus" aria-hidden="true"></i>Take action</a>
			</li>

			<li class="nav-item"><a class="nav-link " href="shownotes?id=<%=user1.getUserId()%>">
			<i class="fa fa-eye" aria-hidden="true"></i>
			history</a></li>
		</ul>
		
		<%}%>
		<%if(user1!=null){%>
		
		<form class="form-inline my-2 my-lg-0">
		 
		<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">User Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
     
       <div class="container text-center">
      
       <i class="fa-regular fa-user"></i>
       <h5><%=user1.getName()%></h5>
       <table class="table">
       <tbody>
       <tr>
       <th>User Id</th>
       <td><%=user1.getUserId()%></td>
       </tr>
       <tr>
       <th>Full name</th>
       <td><%=user1.getName()%></td>
       </tr>
       <tr>
       <th>Email</th>
       <td><%=user1.getEmail()%></td>
       </tr>
       </tbody>
       </table>
       </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
			
		<a class="btn btn-light my-2 my-sm-0 mr-3" type="submit"
				 href="login.jsp" data-toggle="modal" data-target="#exampleModal">
				<i class="fa fa-sign-in" aria-hidden="true"></i><%=user1.getName() %></a>
				 
				<a class="btn btn-light my-2 my-sm-0"
				type="submit" href="logout">
				<i class="fa fa-registered" aria-hidden="true"></i>
				Logout</a>
				
		<%}else{%>
		<a class="btn btn-light my-2 my-sm-0 mr-3" type="submit"
				 href="login.jsp">
				<i class="fa fa-sign-in" aria-hidden="true"></i>Login</a> 
				
				<a class="btn btn-light my-2 my-sm-0"
				type="submit" href="register.jsp">
				<i class="fa fa-registered" aria-hidden="true"></i>
				Register</a>
			
		<%}%>
				
		</form>
	</div>


</nav>
