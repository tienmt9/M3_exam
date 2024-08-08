<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Mặt Bằng Mới</title>
</head>
<body>
<h1>Thêm Mặt Bằng Mới</h1>
<form action="rentalSpace" method="post">
    <label for="code">Mã mặt bằng:</label>
    <input type="text" id="code" name="code" pattern="[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}" required>
    <br>
    <label for="status">Trạng thái:</label>
    <select id="status" name="status">
        <option value="Trống">Trống</option>
        <option value="Hạ tầng">Hạ tầng</option>
        <option value="Đầy đủ">Đầy đủ</option>
    </select>
    <br>
    <label for="area">Diện tích (m²):</label>
    <input type="number" id="area" name="area" min="20" required>
    <br>
    <label for="floor">Tầng:</label>
    <input type="number" id="floor" name="floor" min="1" max="15" required>
    <br>
    <label for="type">Loại mặt bằng:</label>
    <select id="type" name="type">
        <option value="Văn phòng chia sẻ">Văn phòng chia sẻ</option>
        <option value="Văn phòng trọn gói">Văn phòng trọn gói</option>
    </select>
    <br>
    <label for="price">Giá tiền (VND):</label>
    <input type="number" id="price" name="price" min="1000000" required>
    <br>
    <label for="startDate">Ngày bắt đầu:</label>
    <input type="text" id="startDate" name="startDate" pattern="\d{2}/\d{2}/\d{4}" required>
    <br>
    <label for="endDate">Ngày kết thúc:</label>
    <input type="text" id="endDate" name="endDate" pattern="\d{2}/\d{2}/\d{4}" required>
    <br>
    <input type="submit" value="Thêm Mới">
</form>
</body>
</html>
