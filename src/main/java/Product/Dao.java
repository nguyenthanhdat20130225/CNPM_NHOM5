package Product;

import db.JDBiConnector;
import org.jdbi.v3.core.Handle;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Dao {
    /*
     * Lấy danh sách tất cả sản phẩm từ cơ sở dữ liệu
     *
     * @return Danh sách các đối tượng Product
     */
    public  List<Product> getAll(){
       return  JDBiConnector.get().withHandle( handle -> {
            return handle.createQuery("select * from product" ).mapToBean(Product.class).list();
        } );
    }

    /*
     * Lưu một sản phẩm vào cơ sở dữ liệu
     *
     * @param p Đối tượng Product cần lưu
     * @return ID của sản phẩm đã lưu
     */
    public int save(Product p){
        String q = "insert into product(`name`,price,`image`,quantity,`importDate`,`description`) values ("+"\""+p.getName()+"\","+p.getPrice() +",\""+p.getImage()+"\","+p.getQuantity() + ",\""+p.getImportDate() + "\",\""+p.getDescription() + "\" )";

        return  JDBiConnector.get().withHandle( handle -> {
            Object o= handle.createUpdate(q).executeAndReturnGeneratedKeys("id").mapToMap().findOnly().get("generated_key");
       return( (BigInteger)o).intValue();
        } );
    }



    /*
     * Cập nhật thông tin của một sản phẩm trong cơ sở dữ liệu dua vào id
     *
     * @param p Đối tượng Product cần cập nhật
     */
    public void update(Product p){
        String q = "UPDATE product SET name = ?, price = ?, image = ?, quantity = ?, importDate = ?, description = ? WHERE id = ?";
        JDBiConnector.get().useHandle(handle -> {
            handle.createUpdate(q)
                    .bind(0, p.getName())
                    .bind(1, p.getPrice())
                    .bind(2, p.getImage())
                    .bind(3, p.getQuantity())
                    .bind(4, p.getImportDate())
                    .bind(5, p.getDescription())
                    .bind(6, p.getId())
                    .execute();
        });

    }
    /*
     * Xóa một sản phẩm khỏi cơ sở dữ liệu dựa trên ID
     *
     * @param String id ID của sản phẩm cần xóa
     */
    public void delete(String id){
        String q = "delete from product where id="+id;
        JDBiConnector.get().useHandle( handle -> {
            handle.createUpdate(q).execute();
        } );
    }
    /*
     * Lấy thông tin của một sản phẩm từ cơ sở dữ liệu dựa trên ID
     *
     * @param id ID của sản phẩm cần lấy
     * @return Đối tượng Product tương ứng với ID
     */
    public Product getProductById(String id) {
        String q = "SELECT * FROM product WHERE id = :id";
        return JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery(q)
                    .bind("id", id)
                    .mapToBean(Product.class)
                    .findOnly();
        });
    }



}
