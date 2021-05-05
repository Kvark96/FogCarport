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



        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
