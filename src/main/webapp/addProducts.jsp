<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 4/27/2023
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
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
<form method="POST" action="/api/product">
    <label for="product-name">Tên sản phẩm:</label>
    <input type="text" id="product-name" name="product-name" required>

    <label for="unit-price">Đơn giá:</label>
    <input type="number" id="unit-price" name="unit-price" required>

    <label for="image">Link Hình ảnh:</label>
    <input type="text" id="image" name="image" required>

    <label for="description">Thông tin:</label>
    <textarea id="description" name="description"></textarea>


    <label for="quantity">Số lượng tồn:</label>
    <input type="number" id="quantity" name="quantity" required>


    <input type="submit" value="Lưu sản phẩm">
</form>

</body>
</html>
