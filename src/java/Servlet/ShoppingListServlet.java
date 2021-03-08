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
        String logout = request.getParameter("logout");
        if(user == null || user.equals(""))
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
        }
        
        if(user != null)
        {
            session.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response); 
        }
        
        if(logout != null)
        {
            items.clear();
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        String itemName = request.getParameter("itemName");
        if(action.equals("register"))
        {
            String user =(String)session.getAttribute("user");
            session.setAttribute("user", user);
        }
        if(action.equals("add"))
        {
            String item = request.getParameter("item");
            items.add(item);
            session.setAttribute("items", items);
        }
        if(action.equals("delete"))
        {
            if(itemName != null)
            {
               items.remove(itemName);
            }
            session.setAttribute("items", items);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
    }

}
