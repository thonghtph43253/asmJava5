<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>
<h3>Quản Lý Hóa Đơn</h3>
<div class="d-flex  justify-content-end my-2">

    <form action="/shopaaa" method="get" >
        <input style="width: 400px" name="search" placeholder="Nhập tên cần tìm..." >
        <input type="hidden" name="page" value="QuanLyHoaDon">
        <input type="hidden" name="pt" value="${page}">
        <button>Tìm</button>
    </form>
</div>
<div class="row">
<%--    <div class="col-4">--%>
<%--        <form:form action="/shopaaa/addSanPham" method="post" modelAttribute="sanpham">--%>
<%--            <div class="my-3">--%>
<%--                Mã: <form:input path="ma"/><br>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                Tên: <form:input path="ten"/><br>--%>
<%--            </div>--%>

<%--            <div class="mb-3">--%>
<%--                Trạng thái: <form:radiobutton path="trangThai" value="true" label="Hoạt động" />--%>
<%--                <form:radiobutton path="trangThai" value="false" label="Không hoạt động"/><br>--%>
<%--            </div>--%>
<%--            <button>Thêm</button>--%>
<%--            <button type="submit" formaction="/shopaaa/updateSP?id=${sanpham.id}" formmethod="post" >Sửa</button>--%>
<%--        </form:form>--%>
<%--    </div>--%>
    <div class="col">
        <table class="table table-dark table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Nhân viên tạo</th>
                <th>Khách hàng mua</th>
                <th>SĐT</th>
                <th>Ngày mua</th>
                <th>Trạng thái</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHD.content}" var="hd" varStatus="loop">
                <tr>
                    <td>${loop.count +(page)*5}</td>
                    <td>${hd.id}</td>
                    <td>${hd.nhanVien.ten}</td>
                    <td>${hd.khachHang.ten}</td>
                    <td>${hd.khachHang.sdt}</td>
                    <td>${hd.ngayMuaHang}</td>

                    <td>${hd.trangThai?"Thành công":"Hủy"}</td>
                    <td>
                        <a class="btn btn-info" href="/shopaaa/hoadonct?page=QuanLyHoaDonCT&id=${hd.id}">Hóa đơn chi tiết</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <c:forEach var="i" begin="0" end="${listHD.totalPages-1==-1?0:listHD.totalPages-1}">
                        <li class="page-item ${i == page ? 'active' : ''}">
                            <a class="page-link" href="?page=QuanLyHoaDon&&pt=${i}">${i+1}</a>
                        </li>

                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>