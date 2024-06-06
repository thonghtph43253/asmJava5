<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>
<h3>Quản Lý Khách Hàng</h3>
<div class="d-flex  justify-content-between my-2">
    <a href="?page=themKhachHang" class="btn btn-success ">Thêm khách hàng</a>
    <form action="/shopaaa" method="get" >
        <input style="width: 400px" name="search" placeholder="Nhập tên cần tìm..." >
        <input type="hidden" name="page" value="QuanLyKhachHang">
        <input type="hidden" name="pt" value="${page}">
        <button>Tìm</button>
    </form>
</div>
<table class="table table-dark table-hover">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Tên</th>
        <th>SĐT</th>
        <th>Mã KH</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKH.content}" var="kh" varStatus="loop">
        <tr>
            <td>${loop.count +(page)*5}</td>
            <td>${kh.id}</td>
            <td>${kh.ten}</td>
            <td>${kh.sdt}</td>
            <td>${kh.maKH}</td>
            <td>${kh.trangThai?"Hoạt động":"Không hoạt động"}</td>
            <td>
                <a class="btn btn-warning" href="/shopaaa/suaKhachHang?page=suaKhachHang&id=${kh.id}">Sửa</a>
                <a class="btn btn-danger" href="/shopaaa/deleteKH/${kh.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:forEach var="i" begin="0" end="${listKH.totalPages-1==-1?0:listKH.totalPages-1}">
                <li class="page-item ${i == page ? 'active' : ''}">
                    <a class="page-link" href="?page=QuanLyKhachHang&&pt=${i}">${i+1}</a>
                </li>

            </c:forEach>
        </ul>
    </nav>
</div>



</body>
