/**
 * Created with IntelliJ IDEA.
 * User: eleve
 * Date: 19/04/13
 * Time: 16:09
 * To change this template use File | Settings | File Templates.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    public class Servlet extends HttpServlet {

        protected void doGet(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
            PrintWriter writer = res.getWriter();

            writer.println("Hello World !!!");
        }

    }
