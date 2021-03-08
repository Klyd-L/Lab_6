package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author klydm
 */
public class ShoppingListServlet extends HttpServlet {
    
    ArrayList<String> items = new ArrayList<>();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String user = request.getParameter("user");
        session.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        
        String user = request.getParameter("user");
        session.setAttribute("user", user);
        
        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        String itemName = request.getParameter("itemName");
        if(add != null)
        {
            String item = request.getParameter("item");
            items.add(item);
            request.setAttribute("items", items);
        }
        if(delete != null)
        {
            if(itemName != null)
            {
               items.remove(itemName);
            }
            request.setAttribute("items", items);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
    }

}
