package ru.carSales.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import ru.carSales.models.Offer;
import ru.carSales.storage.ValidateCarService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $Id$.
 * Date: 16.09.2020.
 */
public class GetByTypeServlet extends HttpServlet {
    private final static ValidateCarService VS = ValidateCarService.getInstance();

    /**
     * Get offers from DB where type equals type of req.
     *
     * @param req - req.
     * @param resp - resp.
     * @throws IOException - IOException.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*"); // Cros
        String type = req.getParameter("type");
        List<Offer> cars = VS.findByType(type);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cars);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print(json);
        writer.flush();
    }

    /**
     * Close ValidateCarService and destroy GetAllCarsServlet.
     */
    @Override
    public void destroy() {
        VS.close();
        super.destroy();
    }
}
