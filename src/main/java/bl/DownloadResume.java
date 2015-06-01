/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entity.Recruit;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author johnson3yo
 */
@WebServlet("/downloadResume")
public class DownloadResume extends HttpServlet {

    @EJB GeneralEJB gEJB;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rec_id = req.getParameter("recruit_id");
     byte[]img =   gEJB.viewResume(Integer.parseInt(rec_id));
    
     resp.setHeader("Content-Disposition","attachment; filename = "+rec_id+".docx");
     resp.getOutputStream().write(img);
     resp.getOutputStream().flush();
    
        
    }
    
    
    
}


//FacesContext context = FacesContext.getCurrentInstance(); 
//   try { 
//     HttpServletRequest request   = 
//                   (HttpServletRequest) context.getExternalContext().getRequest();
//     HttpServletResponse response = 
//                   (HttpServletResponse) context.getExternalContext().getResponse();
//     RequestDispatcher dispatcher = 
//                   request.getRequestDispatcher("/GetName");
//     dispatcher.forward(request, response);
//   }
//   catch (Exception e) { 
//     e.printStackTrace(); 
//   } 