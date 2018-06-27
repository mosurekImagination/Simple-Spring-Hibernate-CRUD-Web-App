import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/testDb")
public class testDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //setup connecion variables
        String user = "springUser";
        String pass = "pass";

        String jdbcUrl= "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        //get connection to database
        try{
            PrintWriter out = resp.getWriter();

            out.println("Connecting to database " + jdbcUrl);
            Class.forName(driver);

            Connection myConnection = DriverManager.getConnection(jdbcUrl,user,pass);

            out.println("Connection Succesfull");

            myConnection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
