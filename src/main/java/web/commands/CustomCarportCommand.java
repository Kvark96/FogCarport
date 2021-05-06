package web.commands;

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


       // int id = (int) request.getSession().getAttribute("user_id");




        // add request to orderline// TODO



        // Parse to jsp customer page for accepted request
        request.getSession().setAttribute("length",length);
        request.getSession().setAttribute("width",width);




        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
