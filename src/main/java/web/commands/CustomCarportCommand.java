package web.commands;

import business.persistence.Database;
import business.persistence.RequestMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomCarportCommand extends Command
{
    public String role;
    public String pageToShow;

    public CustomCarportCommand(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        int user_id = (int) request.getSession().getAttribute("user_id");


        request.getSession().setAttribute("user_id", user_id);
        request.getSession().setAttribute("length",length);
        request.getSession().setAttribute("width",width);

        return pageToShow;

    }

    public String getRole()
    {
        return role;
    }
}
