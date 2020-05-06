
<%@page import="java.util.ArrayList"%>
<%@page import="com.javabykiran.model.Users"%>

<font color="green"> 
<%
 	ArrayList<Users> namesList = (ArrayList<Users>) request.getAttribute("data");
	
 %></font>

<table border="1">
	<tr>
		<th>Select</th>
		<th>Emp ID</th>
		<th>Emp Name</th>
		<th>Edit Employee</th>
		<th>Delete Employee</th>
	</tr>
	<%
		int i=0;
		for (Users name:namesList) {
			i++;
	%>
	<form action="delete">
	<tr>
		<td><input type="radio" name="id" value="<%=i%>"></td>
		<td>
			<%
				out.println(i);
			%>
		</td>
		<td>
			<%
				out.println(name.getUsername());
			%>
		</td>
		<td><input type="submit" value="edit"></td>
		<td><input type="submit" value="delete"></td>
	</tr>
	</form>
	<%
		}
	%>
</table>

