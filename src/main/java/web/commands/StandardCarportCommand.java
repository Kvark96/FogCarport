package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StandardCarportCommand extends Command{
    public String role;
    public String pageToShow;

    public StandardCarportCommand(String role, String pageToShow) {
        this.role = role;
        this.pageToShow = pageToShow;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        return pageToShow;
    }

    public String getRole() {
        return role;
    }
}
