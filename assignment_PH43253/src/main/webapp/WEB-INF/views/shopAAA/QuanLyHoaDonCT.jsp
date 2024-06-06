<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>
<h3>Quản Lý Hóa Đơn Chi Tiết</h3>
<div class="d-flex  justify-content-between my-2">
    <a class="btn btn-info" href="/shopaaa?page=QuanLyHoaDon"><<< Quay lại trang hóa đơn</a>
    <form action="/shopaaa/sanphamct" method="get" >
        <input style="width: 400px" name="search" placeholder="Nhập id cần tìm..." >
        <input type="hidden" name="page" value="QuanLyHoaDonCT">
        <input type="hidden" name="pt" value="${page}">
        <input type="hidden" name="id" value="${idsp}">
        <button>Tìm</button>
    </form>
</div>
<div class="row">
    <div class="col-4">
        <form action="/shopaaa/suaHD" method="post" >
            <div class="my-3">
                <p>ID hóa đơn: ${hd.id}</p>
            </div>
            <input type="hidden" name="id" value=" ${hd.id}">
            <div class="mb-3">
                <p>Tên nhân viên bán: ${hd.nhanVien.ten}</p>
            </div>
            <div class="mb-3">
                <p>Tên khách hàng: ${hd.khachHang.ten}</p>
            </div>
            <div class="mb-3">
                <p>SĐT khách hàng: ${hd.khachHang.sdt}</p>
            </div>
            <div class="mb-3">
                <p>Ngày mua: ${hd.ngayMuaHang}</p>
            </div>
            <div class="mb-3">
                <p>Tổng tiền hóa đơn: ${tongTien}</p>
            </div>

            <div class="mb-3">
                Trạng thái: <input type="radio" name="trangThai" value="true" ${hd.trangThai?"checked":""} />Thành công
                <input type="radio" name="trangThai" value="false" ${!hd.trangThai?"checked":""} />Hủy đơn<br>
            </div>
            <button>Cập nhật</button>
        </form>
    </div>
    <div class="col-8">
        <table class="table table-dark table-hover">
            <thead>
            <tr>

                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Trạng Thái</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHDCT.content}" var="nv" varStatus="loop">
                <tr>

                    <td>${nv.id}</td>
                    <td>${nv.thongTinSP}</td>
                    <td>${nv.soLuong}</td>
                    <td>${nv.donGia}</td>

                    <td>${nv.trangThai?"Hoạt động":"Không hoạt động"}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach var="i" begin="0" end="${listHDCT.totalPages-1==-1?0:listHDCT.totalPages-1}">
                        <li class="page-item ${i == page ? 'active' : ''}">
                            <a class="page-link" href="/shopaaa/sanphamct?page=QuanLyHoaDonCT&&id=${idsp}&&pt=${i}">${i+1}</a>
                        </li>

                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>