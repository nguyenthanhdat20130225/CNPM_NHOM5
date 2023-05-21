package Product;

import com.fasterxml.jackson.databind.ObjectMapper;
import untils.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public abstract  class Controller extends HttpServlet {
    /*
     * Xử lý yêu cầu HTTP GET, POST, PUT, DELETE
     *
     * @param req  Đối tượng HttpServletRequest chứa yêu cầu từ client
     * @param resp Đối tượng HttpServletResponse để trả về kết quả cho client
     * @throws ServletException Nếu có lỗi xảy ra trong quá trình xử lý yêu cầu
     * @throws IOException      Nếu có lỗi xảy ra trong quá trình xử lý I/O
     */
    @Override
    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected abstract void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;



    @Override
    protected abstract void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;


}
