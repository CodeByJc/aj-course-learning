package org.example.servlet;

import org.example.dao.BookDAO;
import org.example.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookDAO dao = new BookDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "create";

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String isbn = req.getParameter("isbn");
        String yearStr = req.getParameter("publishedYear");
        Integer year = (yearStr == null || yearStr.isEmpty()) ? null : Integer.parseInt(yearStr);

        if ("create".equals(action)) {
            Book book = new Book(title, author, isbn, year);
            dao.save(book);
        } else if ("update".equals(action)) {
            Long id = Long.parseLong(req.getParameter("id"));
            Book book = dao.findById(id);
            if (book != null) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setIsbn(isbn);
                book.setPublishedYear(year);
                dao.update(book);
            }
        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(req.getParameter("id"));
            dao.delete(id);
        }

        resp.sendRedirect(req.getContextPath() + "/books");
    }
}
