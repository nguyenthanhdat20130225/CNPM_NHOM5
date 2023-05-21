package untils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;

@Data
public class HttpUtil {

    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }
    /*
     * Chuyển đổi chuỗi JSON thành đối tượng Java thuộc lớp T
     *
     * @param tClass Kiểu đối tượng đích
     * @param <T>    Kiểu đối tượng
     * @return Đối tượng Java được chuyển đổi từ chuỗi JSON
     */
    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    /*
     * Chuyển đổi dữ liệu JSON thành một mảng đối tượng
     *
     * @param tClass Lớp đối tượng mảng đích
     * @param <T>    Kiểu đối tượng
     * @return Mảng đối tượng chuyển đổi từ dữ liệu JSON
     * @throws JsonProcessingException Nếu có lỗi xử lý JSON
     */

    public <T> T[] listModel(Class<T[]> tClass) throws JsonProcessingException {
        return new ObjectMapper().readValue(value, tClass);

    }
    /*
     - Tạo đối tượng HttpUtil từ BufferedReader

     - @param reader Đối tượng BufferedReader chứa dữ liệu
     - @return Đối tượng HttpUtil
     */

    public static HttpUtil of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return new HttpUtil(sb.toString());
    }


}
