package my.ohrem.servlet;
import my.ohrem.model.CarEntity;
import my.ohrem.repository.CarEntityDaoImpl;
import my.ohrem.service.service.SearchCarService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/search.do")
public class SearchServlet extends HttpServlet {

    private SearchCarService searchService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        searchService = new SearchCarService(new CarEntityDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Read input from HTTP request
        final String pname = req.getParameter("pname");
        // Handle input data with business service
        final List<CarEntity> searchResult = searchService.search(pname);
        // Save output for view/UI (JSP)
        req.setAttribute("searchResult", searchResult);
        getServletContext().getRequestDispatcher("/jsp/searchResult.jsp")
                .forward(req, resp);
    }

    public void setSearchService(SearchCarService searchService) {
        this.searchService = searchService;
    }
}