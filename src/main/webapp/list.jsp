<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Mặt Bằng</title>
</head>
<body>
<h1>Danh Sách Mặt Bằng</h1>
<table border="1">
    <thead>
    <tr>
        <th>Mã mặt bằng</th>
        <th>Trạng thái</th>
        <th>Diện tích</th>
        <th>Tầng</th>
        <th>Loại mặt bằng</th>
        <th>Giá tiền</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="rentalSpace" items="${rentalSpaces}">
        <tr>
            <td><c:out value="${rentalSpace.code}"/></td>
            <td><c:out value="${rentalSpace.status}"/></td>
            <td><c:out value="${rentalSpace.area}"/></td>
            <td><c:out value="${rentalSpace.floor}"/></td>
            <td><c:out value="${rentalSpace.type}"/></td>
            <td><c:out value="${rentalSpace.price}"/></td>
            <td><c:out value="${rentalSpace.startDate}"/></td>
            <td><c:out value="${rentalSpace.endDate}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
