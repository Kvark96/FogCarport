package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String zipcode = request.getParameter("zipcode");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (email.contains("@")) {
            if (!password1.equals("")) {
                if (password1.equals(password2)) {
                    String role = "customer";
                    User user = userFacade.createUser(email, password1, role, name, phonenumber, address, zipcode);

                    HttpSession session = request.getSession();

                    session.setAttribute("name", name);
                    session.setAttribute("email", email);
                    session.setAttribute("user", user);
                    session.setAttribute("user_id", user.getUser_id());
                    session.setAttribute("role", user.getRole());
                    return user.getRole() + "page";
                } else {
                    request.setAttribute("error", "the two passwords did not match");
                    return "registerpage";
                }

            } else {
                request.setAttribute("error", "user needs a password");
                return "registerpage";

            }
        } else {
            request.setAttribute("error", "the email must be valid!");
            return "registerpage";
        }
    }

}
