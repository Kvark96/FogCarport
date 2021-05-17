package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CartCommand extends CommandProtectedPage{
    public CartCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();

        int id = (int) session.getAttribute("id");



        // Ved ikke om den skal returnere hertil, men nu er det sådan.
        return "standardCarportPage";
    }
}
