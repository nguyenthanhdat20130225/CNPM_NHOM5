package Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/sign_up"})
public class SignUpController extends Controller{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");

        // Xử lý dữ liệu tại đây, ví dụ: kiểm tra tính hợp lệ, lưu vào cơ sở dữ liệu, vv.
        Account account = new Account(null,username,password,fullname,email,0,0);
        if(!password.equals(confirmPassword)){
            resp.sendRedirect("http://localhost:8080/signUp.jsp");

        }else {
            if (new Dao().getAccountByUsername(username)!=null){
                resp.sendRedirect("http://localhost:8080/signUp.jsp");

            }else{
                new Dao().saveAccount(account);
                req.setAttribute("successMessage", "Tạo tài khoản thành công");
                req.getRequestDispatcher("/index_2.jsp").forward(req, resp);
//                resp.sendRedirect("http://localhost:8080/login");
            }

        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
