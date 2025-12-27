<%-- 
    Document   : viewProfiles
    Created on : Dec 12, 2025, 11:07:12 AM
    Author     : VivoBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.ProfileBean"%>
<html>
<head>
    <title>Profile List</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="card">
    <h2 class="page-title">Profile List</h2>

    <!-- SEARCH -->
    <form method="get" action="ProfileServlet" class="search-box">
        <input type="text" name="search" placeholder="Search by name">
        <button class="btn-matcha">Search</button>
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Student ID</th>
            <th>Full Name</th>
            <th>Programme</th>
            <th>Hobby</th>
            <th>Email</th>
            <th>Action</th>
        </tr>

<%
ArrayList<ProfileBean> list =
    (ArrayList<ProfileBean>) request.getAttribute("profiles");

for(ProfileBean p : list){
%>
        <tr>
            <td><%=p.getId()%></td>
            <td><%=p.getStudentId()%></td>
            <td><%=p.getFullName()%></td>
            <td><%=p.getProgramme()%></td>
            <td><%=p.getHobby()%></td>
            <td><%=p.getEmail()%></td>
            <td class="actions">

                <a href="editProfile.jsp?id=<%=p.getId()%>" class="btn-matcha small">
                    Edit
                </a>

                <form action="ProfileServlet" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%=p.getId()%>">
                    <button class="btn-pink small">Delete</button>
                </form>

            </td>
        </tr>
<% } %>
    </table>

    <a href="index.html" class="btn-back">Back to Home</a>
</div>

</body>
</html>
