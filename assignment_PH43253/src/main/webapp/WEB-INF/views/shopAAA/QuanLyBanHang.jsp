<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        .table-container {
            height: 100%;
            overflow-y: auto;
        }
    </style>
    <title>Document</title>
</head>
<body>
    <div>
        <h4>Khách hàng</h4>
        <form action="/shopaaa/taoHoaDon" method="post">
            <input name="idnv" value="${nv.id}" type="hidden">
            <div class="row">
                <div class="col-6">
                    <p>Tên khách hàng</p>
                    <select name="idKhachHang">
                        <c:forEach items="${listKHAll}" var="kh">
                            <option value="${kh.id}">${kh.ten}</option>
                        </c:forEach>

                    </select>
                    <a href="?page=themKhachHang" class="btn btn-success">Thêm khách hàng mới</a>
                </div>
                <div class="col-3">
                    <p>Trạng thái đơn</p>
                    <select name="trangThai">

                        <option value="true">Thành công</option>
                        <option value="false">Hủy</option>

                    </select>
                </div>
                <div class="col-3">
                    <c:if test="${listMua.size()>0}">
                        <button type="submit" class="btn btn-success" style="height: 90px">Tạo hóa đơn</button>
                    </c:if>
                    <c:if test="${listMua.size()==0}">
                        <p>Vui lòng chọn sản phẩm cần mua</p>
                    </c:if>

                </div>
            </div>

        </form>
        <p style="color: red">${erSoLuong}</p>
    </div>
    <div class="row" >

        <div class="col-8" style="height: 300px">
            <h4>Sản phẩm</h4>
            <div class="table-container">
                <table class="table table-striped" >
                    <thead>
                    <tr>
                        <th>Thông tin sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Giá bán</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listSPCT}" var="spct" >
                        <tr>
                            <td>${spct.sanPham.ten}, ${spct.mauSac.ten}, ${spct.kichThuoc.ten}</td>
                            <td>${spct.soLuong}</td>
                            <td>${spct.donGia}</td>
                            <td>
                                <form action="/shopaaa/addGioHang" method="post">
                                    <input type="hidden" name="idspct" value="${spct.id}"> <!-- Thẻ ẩn chứa ID sản phẩm chi tiết -->
                                    <input name="soLuongMua" type="number" min="1" value="1">
                                    <button type="submit" class="btn btn-success">Thêm</button>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>


        </div>
        <div class="col-4" style="height:300px">
            <h4>Giỏ hàng</h4>
            <div class="table-container">
                <table class="table table-striped" >
                    <thead>
                    <tr>
                        <th>Thông tin sản phẩm</th>
                        <th>Số lượng</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listMua}" var="spct" >
                        <tr>
                            <td>${thongTinSP[spct.key]}</td>
                            <td>${spct.value}</td>
                            <td>
                                <a href="/shopaaa/deleteGiohang/${spct.key}" class="btn btn-danger">Xóa khỏi giỏ</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>


</body>
</html>