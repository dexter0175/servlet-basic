package org.mycompany.myname;

/**
 * Created by anon on 1/10/2017.
 */

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class SubmitServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("password_confirmation");
        String agreed = request.getParameter("agreed");

        final File file = new File("D:/UserData/data.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(userName+"\t");
        fileWriter.write(email+"\t");
        fileWriter.write(password+"\t");
        fileWriter.write(passwordConfirmation+"\t");
        fileWriter.write(agreed+"\t \n");
        fileWriter.write(System.lineSeparator() );
        fileWriter.flush();
        fileWriter.close();
        request.setAttribute("username", userName);
        this.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);

        }
        //response.sendRedirect("/");
    }

