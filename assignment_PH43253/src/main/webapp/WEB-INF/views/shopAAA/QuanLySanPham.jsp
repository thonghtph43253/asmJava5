<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>

<h3>Quản Lý Sản Phẩm</h3>
<div class="d-flex  justify-content-end my-2">

    <form action="/shopaaa" method="get" >
        <input style="width: 400px" name="search" placeholder="Nhập tên cần tìm..." >
        <input type="hidden" name="page" value="QuanLySanPham">
        <input type="hidden" name="pt" value="${page}">
        <button>Tìm</button>
    </form>
</div>
<div class="row">
    <div class="col-4">
        <form:form action="/shopaaa/addSanPham?page=QuanLySanPham" method="post" modelAttribute="sanpham">
            <div class="my-3">
                Mã: <form:input path="ma"/><br>
                <form:errors path="ma"/>
            </div>
            <div class="mb-3">
                Tên: <form:input path="ten"/><br>
                <form:errors path="ten"/>
            </div>

            <div class="mb-3">
                Trạng thái: <form:radiobutton path="trangThai" value="true" label="Hoạt động" />
                <form:radiobutton path="trangThai" value="false" label="Không hoạt động"/><br>
            </div>

            <button>Thêm</button>
            <button type="submit" formaction="/shopaaa/updateSP?page=QuanLySanPham&id=${sanpham.id}" formmethod="post" >Sửa</button>
        </form:form>
    </div>
    <div class="col-8">
        <table class="table table-dark table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Trạng thái</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSP.content}" var="nv" varStatus="loop">
                <tr onclick="location.href='/shopaaa/detailSP?page=QuanLySanPham&id=${nv.id}'">
                    <td>${loop.count +(page)*5}</td>
                    <td>${nv.id}</td>
                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>

                    <td>${nv.trangThai?"Hoạt động":"Không hoạt động"}</td>
                    <td>
                        <a class="btn btn-info" href="/shopaaa/sanphamct?page=QuanLySanPhamCT&id=${nv.id}">Sản phẩm chi tiết</a>
                        <a class="btn btn-danger" href="/shopaaa/deleteSP/${nv.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach var="i" begin="0" end="${listSP.totalPages-1==-1?0:listSP.totalPages-1}">
                        <li class="page-item ${i == page ? 'active' : ''}">
                            <a class="page-link" href="?page=QuanLySanPham&&pt=${i}">${i+1}</a>
                        </li>

                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>