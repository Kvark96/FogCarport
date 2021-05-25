package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("customCarport", new CommandProtectedPage("customCarport","customer"));
        commands.put("previousorders", new PreviousordersCommand("previousorders","customer"));
        commands.put("orderlist", new OrderlistCommand("orderlist", "employee"));
        commands.put("orderpage", new ViewOrderCommand("orderpage", "employee"));
        commands.put("requestReceivedPage", new CustomCarportCommand("requestReceivedPage","customer"));
        commands.put("requestConfirmedPage", new ConfirmRequestCommand("requestConfirmedPage","customer"));
        commands.put("requestlist", new RequestListCommand("requestlist", "employee"));
        commands.put("bomPage", new BomCommand("bomPage", "employee"));
        commands.put("standardCarportPage", new CommandProtectedPage("standardCarportPage", "customer"));
        commands.put("drawing", new ShowSVGCommand("drawing"));
        commands.put("CartCommand",new CartCommand("cartPage","customer"));
        commands.put("cartConfirmed", new ConfirmCartCommand("cartConfirmed","customer"));


    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands();
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException, SQLException, NoSuchFieldException;

}
