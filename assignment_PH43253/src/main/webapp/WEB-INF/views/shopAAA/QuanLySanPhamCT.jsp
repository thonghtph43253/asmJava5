<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>
<h3>Quản Lý Sản Phẩm Chi Tiết</h3>
<div class="d-flex  justify-content-between my-2">
    <a class="btn btn-info" href="/shopaaa?page=QuanLySanPham"><<< Quay lại trang sản phẩm</a>
    <form action="/shopaaa/sanphamct" method="get" >
        <input style="width: 400px" name="search" placeholder="Nhập tên cần tìm..." >
        <input type="hidden" name="page" value="QuanLySanPhamCT">
        <input type="hidden" name="pt" value="${page}">
        <input type="hidden" name="id" value="${idsp}">
        <button>Tìm</button>
    </form>
</div>
<div class="row">
    <div class="col-4">
        <form:form action="/shopaaa/addSanPhamCT?page=QuanLySanPhamCT&id=${sp.id}" method="post" modelAttribute="sanphamct">
            <div class="my-3">
                <p>Tên sản phẩm: ${sp.ten}</p>
            </div>
            <input name="idSanPham" value="${sp.id}" type="hidden">
            <div class="mb-3">
                Mã SPCT: <form:input path="maSPCT"/><br>
                <form:errors path="maSPCT"/>
            </div>
            <div class="mb-3">
                Màu sắc: <form:select path="mauSac">
                        <form:options items="${mausacs}" itemValue="id" itemLabel="ten"/>
            </form:select><br>
            </div>
            <div class="mb-3">
                Kích thước: <form:select path="kichThuoc">
                <form:options items="${kichthuocs}" itemValue="id" itemLabel="ten"/>
            </form:select><br>
            </div>
            <div class="mb-3">
                Số lượng: <form:input path="soLuong"/><br>
                <form:errors path="soLuong"/>
            </div>
            <div class="mb-3">
                Giá bán: <form:input path="donGia"/><br>
                <form:errors path="donGia"/>
            </div>

            <div class="mb-3">
                Trạng thái: <form:radiobutton path="trangThai" value="true" label="Hoạt động" />
                <form:radiobutton path="trangThai" value="false" label="Không hoạt động"/><br>
            </div>
            <button>Thêm</button>
            <button type="submit" formaction="/shopaaa/updateSPCT?page=QuanLySanPhamCT&id=${sanphamct.id}" formmethod="post" >Sửa</button>
        </form:form>
    </div>
    <div class="col-8">
        <table class="table table-dark table-hover">
            <thead>
            <tr>

                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Màu</th>
                <th>Kích thước</th>
                <th>Số lượng</th>
                <th>Giá bán</th>
                <th>Trạng Thái</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSPCT.content}" var="nv" varStatus="loop">
                <tr onclick="location.href='/shopaaa/detailSPCT?page=QuanLySanPhamCT&id=${idsp}&idspct=${nv.id}'">

                    <td>${nv.id}</td>
                    <td>${nv.maSPCT}</td>
                    <td>${nv.sanPham.ten}</td>
                    <td>${nv.mauSac.ten}</td>
                    <td>${nv.kichThuoc.ten}</td>
                    <td>${nv.soLuong}</td>
                    <td>${nv.donGia}</td>

                    <td>${nv.trangThai?"Hoạt động":"Không hoạt động"}</td>
                    <td>
                        <a class="btn btn-danger" href="/shopaaa/deleteSPCT/${nv.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach var="i" begin="0" end="${listSPCT.totalPages-1==-1?0:listSPCT.totalPages-1}">
                        <li class="page-item ${i == page ? 'active' : ''}">
                            <a class="page-link" href="/shopaaa/sanphamct?page=QuanLySanPhamCT&&id=${idsp}&&pt=${i}">${i+1}</a>
                        </li>

                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>