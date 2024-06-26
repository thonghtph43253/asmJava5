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
        <a class="btn btn-info" href="/shopaaa?page=QuanLyNhanVien"> <<< Quay lại</a>
        <h3 class="text-center">Thêm nhân viên</h3>
        <h2></h2>
    </div>
    <form:form action="/shopaaa/addNhanVien?page=themNhanVien" method="post" modelAttribute="nhanvien">
        <div class="my-2">
            Tên: <form:input path="ten" class="form-control"/>
            <form:errors path="ten"/>
            <span style="color: red">${er}</span><br>
        </div>
        <div class="mb-2">
            Mã NV:<form:input path="maNV"  class="form-control" />
            <form:errors path="maNV"/>
        </div>
        <div class="mb-2">
            Tên đăng nhâp:<form:input path="tenDangNhap"  class="form-control"/>
            <form:errors path="tenDangNhap"/>
        </div>

        <div class="mb-2">
            Mật khẩu:<form:password path="matKhau"   class="form-control"/>
            <form:errors path="matKhau"/>
        </div>
        <div class="mb-2">
            Vai trò: <form:radiobutton path="vaiTro" value="true" label="Admin" />
            <form:radiobutton path="vaiTro" value="false" label="Nhân viên"/>
        </div>
        <div class="mb-2">
            Trạng thái: <form:radiobutton path="trangThai" value="true" label="Hoạt động"/>
            <form:radiobutton path="trangThai" value="false" label="Nghỉ làm"/>
        </div>





        <button class="btn btn-success">Thêm</button>
    </form:form>
</body>
</html>