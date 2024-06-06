<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>
<div class="d-flex justify-content-between ">
    <a class="btn btn-info" href="/shopaaa?page=QuanLyKhachHang"> <<< Quay lại</a>
    <h3 class="text-center">Sửa khách hàng</h3>
    <h2></h2>
</div>

<form:form action="/shopaaa/suaKhachHang?page=suaKhachHang" method="post" modelAttribute="khachhang">
    <div class="my-3">
        ID:<form:input path="id" readonly="true"/>
    </div>
    <div class="mb-3">
        Tên:<form:input path="ten"/>
        <form:errors path="ten"/>
    </div>
    <div class="mb-3">
        Số điện thoại:<form:input path="sdt"/>
        <form:errors path="sdt"/>
    </div>
    <div class="mb-3">
        Mã KH:<form:input path="maKH"/>
        <form:errors path="maKH"/>
    </div>
    <div class="mb-3">
        Trạng thái:<form:radiobutton path="trangThai" value="true" label="Hoạt động"/>
        <form:radiobutton path="trangThai" value="false" label="Ngừng hoạt động"/>
    </div>

    <button class="btn btn-success">Sửa</button>
</form:form>

</body>
</html>