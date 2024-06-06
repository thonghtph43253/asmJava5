<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>
    <h3>Quản Lý Nhân viên</h3>
    <div class="d-flex  justify-content-between my-2">
        <a href="?page=themNhanVien" class="btn btn-success ">Thêm nhân viên</a>
        <form action="/shopaaa" method="get" >
            <input style="width: 400px" name="search" placeholder="Nhập tên cần tìm..." >
            <input type="hidden" name="page" value="QuanLyNhanVien">
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
                <th>Mã NV</th>
                <th>Tên đăng nhâp</th>
                <th>Mật khẩu</th>
                <th>Vai trò</th>
                <th>Trạng thái</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${listNV.totalElements == 0}">
                <tr>
                    <td colspan="9">Không có nhân viên nào</td>
                </tr>
            </c:if>

            <c:forEach items="${listNV.content}" var="nv" varStatus="loop">
                <tr>
                    <td>${loop.count +(page)*5}</td>
                    <td>${nv.id}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.tenDangNhap}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.maNV}</td>
                    <td>${nv.vaiTro?"ADMIN":"Nhân viên"}</td>
                    <td>${nv.trangThai?"Hoạt động":"Nghỉ việc"}</td>
                    <td>
                        <a class="btn btn-warning" href="/shopaaa/suaNhanVien?page=suaNhanVien&id=${nv.id}">Sửa</a>
                        <a class="btn btn-danger" href="/shopaaa/deleteNV/${nv.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
        <c:forEach var="i" begin="0" end="${listNV.totalPages-1==-1?0:listNV.totalPages-1}">
            <li class="page-item ${i == page ? 'active' : ''}">
                <a class="page-link" href="?page=QuanLyNhanVien&&pt=${i}">${i+1}</a>
            </li>

        </c:forEach>
        </ul>
    </nav>
    </div>



</body>
</html>