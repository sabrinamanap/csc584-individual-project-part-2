/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 *
 * @author VivoBook
 */

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {

protected void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {

try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/student_profiles","root","");

PreparedStatement ps = conn.prepareStatement(
"UPDATE profile SET student_id=?, full_name=?, programme=?, hobby=?, email=? WHERE id=?");

ps.setString(1, req.getParameter("student_id"));
ps.setString(2, req.getParameter("full_name"));
ps.setString(3, req.getParameter("programme"));
ps.setString(4, req.getParameter("hobby"));
ps.setString(5, req.getParameter("email"));
ps.setInt(6, Integer.parseInt(req.getParameter("id")));

ps.executeUpdate();
res.sendRedirect("ProfileServlet");

} catch(Exception e){
e.printStackTrace();
}
}
}
