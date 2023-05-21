            package Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
//địa chỉ Servlet
            @WebServlet("/editProduct")
public class EditProductController extends Controller{
                /*
                 * Xử lý yêu cầu HTTP GET để hiển thị trang chỉnh sửa sản phẩm
                 *
                 * @param req  Đối tượng HttpServletRequest chứa yêu cầu từ client
                 * @param resp Đối tượng HttpServletResponse để trả về kết quả cho client
                 * @throws ServletException Nếu có lỗi xảy ra trong quá trình xử lý yêu cầu
                 * @throws IOException      Nếu có lỗi xảy ra trong quá trình xử lý I/O
                 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("id",id);
       req.getRequestDispatcher("editProduct.jsp").forward(req,resp);



    }
    /*
     * Xử lý yêu cầu HTTP POST để cập nhật thông tin sản phẩm
     *
     * @param req  Đối tượng HttpServletRequest chứa yêu cầu từ client
     * @param resp Đối tượng HttpServletResponse để trả về kết quả cho client
     * @throws ServletException Nếu có lỗi xảy ra trong quá trình xử lý yêu cầu
     * @throws IOException      Nếu có lỗi xảy ra trong quá trình xử lý I/O
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = (String) req.getParameter("id");
        String name = (String) req.getParameter("product-name");
        int price = Integer.parseInt(req.getParameter("unit-price"));
        String image = (String) req.getParameter("image");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = (String) req.getParameter("description");
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();

        Dao dao = new Dao();
        Product product = dao.getProductById(id);
        System.out.println(product.toString());
        product.setId(Integer.parseInt(id));
        product.setName(name);
        product.setPrice(price);
        product.setImage(image);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setImportDate(timestamp);
        System.out.println(product.toString());
        dao.update(product);

        resp.sendRedirect("http://localhost:8080/editProduct?id="+id);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
