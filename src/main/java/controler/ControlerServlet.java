package controler;

import comands.Comand;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControlerServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(ControlerServlet.class);
    private ComandResolver commandResolver = ComandResolver.getInstance();

    @Override
    public void init() throws ServletException {
        BasicConfigurator.configure();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionRequestContent content = new SessionRequestContent(req);
        log.info(content);
        Comand command = commandResolver.getComand(req);
        ExecutionResult result = command.execute(content);
        if (result.isInvalidated())
            req.getSession(false).invalidate();
        result.updateRequest(req);
        if (result.getDirection() == Direction.FORWARD)
            req.getRequestDispatcher(result.getPage()).forward(req, resp);
        if (result.getDirection() == Direction.REDIRECT) {
            resp.sendRedirect(result.getPage());
        }
    }
}
