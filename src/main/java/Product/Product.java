package Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
/*
* @Data
@AllArgsConstructor
@NoArgsConstructor
* giúp tự động sinh ra các phương thức cần thiết như getters, setters, constructors và các phương thức khác
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private String image;
    private Integer quantity;
    private String importDate;
    private String description;
}

