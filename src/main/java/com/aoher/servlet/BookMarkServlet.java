package com.aoher.servlet;

import com.aoher.domain.BookMark;
import com.aoher.factory.ConnectionFactory;
import com.aoher.services.BookMarkService;
import com.aoher.services.impl.BookMarkServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark")
public class BookMarkServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(BookMarkServlet.class);


    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookMarkService service = new BookMarkServiceImpl();
        BookMark bookMark = null;
        try {
            bookMark = service.getBookMark(Long.parseLong(request.getParameter("accountid")));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        ObjectMapper mapper = new ObjectMapper();

        String completeBookMark = mapper.writeValueAsString(bookMark);

        JSONObject jsonObject = new JSONObject(completeBookMark);
        JSONObject jsonKey = new JSONObject();
        jsonKey.put("bookmark", jsonObject);

        log.info("json key: {}", jsonKey);

        response.getWriter().write(jsonKey.toString());
        response.getWriter().flush();
        response.getWriter().close();

    }
}
