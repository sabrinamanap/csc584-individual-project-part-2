<%-- 
    Document   : editProfile
    Created on : Dec 12, 2025, 11:07:32 AM
    Author     : VivoBook
--%>

<%@page import="java.sql.*"%>
<%
int id = Integer.parseInt(request.getParameter("id"));
Connection conn = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/student_profiles","root","");
PreparedStatement ps =
conn.prepareStatement("SELECT * FROM profile WHERE id=?");
ps.setInt(1,id);
ResultSet rs = ps.executeQuery();
rs.next();
%>

<html>
<head>
    <title>Edit Profile</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="card">
    <h2 class="page-title">Edit Profile</h2>

    <form action="UpdateProfileServlet" method="post" class="edit-form">
        <input type="hidden" name="id" value="<%=id%>">

        <input name="student_id" value="<%=rs.getString("student_id")%>">
        <input name="full_name" value="<%=rs.getString("full_name")%>">
        <input name="programme" value="<%=rs.getString("programme")%>">
        <input name="hobby" value="<%=rs.getString("hobby")%>">
        <input name="email" value="<%=rs.getString("email")%>">

        <button class="btn-pink">
            Update 
        </button>
    </form>

    <a href="ProfileServlet" class="btn-back"> Back</a>
</div>

</body>
</html>
