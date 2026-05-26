

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/givingauthorizecontroller")
public class givingauthorizecontroller extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pt_id = Integer.parseInt(request.getParameter("pt_id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");

            PreparedStatement pst = conn.prepareStatement(
                "UPDATE patients SET is_authorization='1' WHERE pt_id=?");
            pst.setInt(1, pt_id);
            int rows = pst.executeUpdate();

            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Redirect back to JSP to refresh list
        response.sendRedirect("patientsauthorization.jsp");
    }

	}


