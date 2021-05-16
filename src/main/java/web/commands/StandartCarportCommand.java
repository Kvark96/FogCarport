package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class StandartCarportCommand extends Command
{
    public String role;
    public String pageToShow;

    public StandartCarportCommand(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
