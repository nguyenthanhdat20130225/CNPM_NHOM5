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

@WebServlet(urlPatterns = {"/api/product"})
public class HomeController extends Controller {
    /*
     * Xử lý yêu cầu HTTP GET để lấy danh sách sản phẩm từ cơ sở dữ liệu và trả về dưới dạng JSON
     *
     * @param req  Đối tượng HttpServletRequest chứa yêu cầu từ client
     * @param resp Đối tượng HttpServletResponse để trả về kết quả cho client
     * @throws ServletException Nếu có lỗi xảy ra trong quá trình xử lý yêu cầu
     * @throws IOException      Nếu có lỗi xảy ra trong quá trình xử lý I/O
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();


        req.setCharacterEncoding("UTF-8");

        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getOutputStream(),new Dao().getAll());

    }
    /*
     * Xử lý yêu cầu HTTP POST để tạo mới một sản phẩm
     *
     * @param req  Đối tượng HttpServletRequest chứa yêu cầu từ client
     * @param resp Đối tượng HttpServletResponse để trả về kết quả cho client
     * @throws ServletException Nếu có lỗi xảy ra trong quá trình xử lý yêu cầu
     * @throws IOException      Nếu có lỗi xảy ra trong quá trình xử lý I/O
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = (String) req.getParameter("product-name");
        Integer price = Integer.parseInt(req.getParameter("unit-price"));
        String image = (String) req.getParameter("image");
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = (String) req.getParameter("description");
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        Product product = new Product(null,name,price,image,quantity,timestamp,description);
        new Dao().save(product);
        resp.sendRedirect("http://localhost:8080");
    }
    /*
     * Xử lý yêu cầu HTTP PUT để cập nhật thông tin sản phẩm
     *
     * @param req  Đối tượng HttpServletRequest chứa yêu cầu từ client
     * @param resp Đối tượng HttpServletResponse để trả về kết quả cho client
     * @throws ServletException Nếu có lỗi xảy ra trong quá trình xử lý yêu cầu
     * @throws IOException      Nếu có lỗi xảy ra trong quá trình xử lý I/O
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String name = (String) req.getParameter("product-name");
        Integer price = Integer.parseInt(req.getParameter("unit-price"));
        String image = (String) req.getParameter("image");
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = (String) req.getParameter("description");
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        Product product = new Product(null,name,price,image,quantity,timestamp,description);
        new Dao().update(product);
        resp.sendRedirect("http://localhost:8080");






    }
    /*
     * Xử lý yêu cầu HTTP DELETE để xóa sản phẩm
     *
     * @param req  Đối tượng HttpServletRequest chứa yêu cầu từ client
     * @param resp Đối tượng HttpServletResponse để trả về kết quả cho client
     * @throws ServletException Nếu có lỗi xảy ra trong quá trình xử lý yêu cầu
     * @throws IOException      Nếu có lỗi xảy ra trong quá trình xử lý I/O
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        new Dao().delete(id);
    }




}
