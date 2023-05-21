<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 4/27/2023
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="Product.Product" %>
<%@ page import="Product.Dao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Sửa sản phẩm</title>
    <script
            src="https://code.jquery.com/jquery-3.6.4.js"
            integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
            crossorigin="anonymous"></script>
</head>
<body>
<style>
    form {
        display: flex;
        flex-direction: column;
        max-width: 500px;
        margin: 0 auto;
    }

    label {
        margin-top: 10px;
    }

    input[type="text"],
    input[type="number"],
    textarea,
    select {
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        margin-top: 5px;
        width: 100%;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 10px;
        margin-top: 10px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #3e8e41;
    }

</style>
<form method="POST" action="/editProduct">
    <%
        String id = (String)request.getParameter("id");
        Dao dao = new Dao();
        Product product = dao.getProductById(id);



    %>

    <label for="product-id">ID sản phẩm:</label>
    <input type="text" id="product-id" value="<%=product.getId()%>" name="id" readonly>

    <label for="product-name">Tên sản phẩm:</label>
    <input type="text" id="product-name" name="product-name" value="<%=product.getName()%>" required>

    <label for="unit-price">Đơn giá:</label>
    <input type="number" id="unit-price" name="unit-price" value="<%=product.getPrice()%>" required>

    <label for="image">Link Hình ảnh:</label>
    <input type="text" id="image" name="image" value="<%=product.getImage()%>" required>

    <label for="description">Thông tin:</label>
    <textarea id="description" name="description"><%=product.getDescription()%></textarea>


    <label for="quantity">Số lượng tồn:</label>
    <input type="number" id="quantity" name="quantity" value="<%=product.getQuantity()%>" required>
    <input type="submit" value="Lưu sản phẩm">

</form>
</br>
<a href="http://localhost:8080/index.jsp">Trở về trang chủ</a>
<script>
    // function updateProduct(id) {
    //     var product = {
    //         id: id,
    //         name: $('#product-name').val(),
    //         price: $('#unit-price').val(),
    //         image: $('#image').val(),
    //         description: $('#description').val(),
    //         quantity: $('#quantity').val()
    //     };
    //     $.ajax({
    //         type: 'POST',
    //         url: '/editProduct',
    //         data: {product: JSON.stringify(product)},
    //         success: function(response) {
    //             $('#result').html(response);
    //         }
    //     });
    // }
</script>
</body>
</html>
