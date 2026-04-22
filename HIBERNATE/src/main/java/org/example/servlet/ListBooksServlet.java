package org.example.servlet;

import org.example.dao.BookDAO;
import org.example.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class ListBooksServlet extends HttpServlet {
    private BookDAO dao = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = dao.list();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
