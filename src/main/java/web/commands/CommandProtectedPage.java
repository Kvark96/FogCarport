package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CommandProtectedPage extends Command
{
    public String role;
    public String pageToShow;

    public CommandProtectedPage(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchFieldException {
        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
