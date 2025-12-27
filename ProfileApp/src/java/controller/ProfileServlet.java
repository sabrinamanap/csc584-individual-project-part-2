package controller;

import model.ProfileBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private final String DB_URL = "jdbc:mysql://localhost:3306/student_profiles";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    // INSERT DATA
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("student_id");
        String fullName = request.getParameter("full_name");
        String programme = request.getParameter("programme");
        String hobby = request.getParameter("hobby");
        String email = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO profile (student_id, full_name, programme, hobby, email) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentId);
            ps.setString(2, fullName);
            ps.setString(3, programme);
            ps.setString(4, hobby);
            ps.setString(5, email);

            ps.executeUpdate();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("ProfileServlet");
    }

    // VIEW + SEARCH BY NAME
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ProfileBean> list = new ArrayList<>();
        String search = request.getParameter("search");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String sql;
            PreparedStatement ps;

            if (search != null && !search.trim().isEmpty()) {
                sql = "SELECT * FROM profile WHERE full_name LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
            } else {
                sql = "SELECT * FROM profile";
                ps = conn.prepareStatement(sql);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProfileBean p = new ProfileBean();
                p.setId(rs.getInt("id"));
                p.setStudentId(rs.getString("student_id"));
                p.setFullName(rs.getString("full_name"));
                p.setProgramme(rs.getString("programme"));
                p.setHobby(rs.getString("hobby"));
                p.setEmail(rs.getString("email"));
                list.add(p);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("profiles", list);
        RequestDispatcher rd = request.getRequestDispatcher("viewProfiles.jsp");
        rd.forward(request, response);
    }
}
