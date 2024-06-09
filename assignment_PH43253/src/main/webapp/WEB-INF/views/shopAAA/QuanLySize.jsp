<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html >
<head>
    <meta charset="UTF-8">

    <title>Document</title>
</head>
<body>
<h3>Quản Lý Kích Thước</h3>
<div class="d-flex  justify-content-end my-2">

    <form action="/shopaaa" method="get" >
        <input style="width: 400px" name="search" placeholder="Nhập tên cần tìm..." >
        <input type="hidden" name="page" value="QuanLySize">
        <input type="hidden" name="pt" value="${page}">
        <button>Tìm</button>
    </form>
</div>
<div class="row">
    <div class="col">
        <form:form action="/shopaaa/addKichThuoc?page=QuanLySize" method="post" modelAttribute="kichthuoc">
            <div class="my-3">
                Mã: <form:input path="ma"/><br>
                <form:errors path="ma"/><br>
                <span style="color: red">${er}</span><br>
            </div>
            <div class="mb-3">
                Tên: <form:input path="ten"/><br>
                <form:errors path="ten"/><br>
            </div>

            <div class="mb-3">
                Trạng thái: <form:radiobutton path="trangThai" value="1" label="Hoạt động" />
                <form:radiobutton path="trangThai" value="0" label="Không hoạt động"/><br>
            </div>
             <button>Thêm</button>
            <button type="submit" formaction="/shopaaa/updateKT?id=${kichthuoc.id}&page=QuanLySize" formmethod="post" >Sửa</button>
        </form:form>
    </div>
    <div class="col">
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
            <c:forEach items="${listKT.content}" var="nv" varStatus="loop">
                <tr onclick="location.href='/shopaaa/detailKT?page=QuanLySize&id=${nv.id}'">
                    <td>${loop.count +(page)*5}</td>
                    <td>${nv.id}</td>
                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>

                    <td>${nv.trangThai ==1?"Hoạt động":"Không hoạt động"}</td>
                    <td>

                        <a class="btn btn-danger" href="/shopaaa/deleteKT/${nv.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach var="i" begin="0" end="${listKT.totalPages-1==-1?0:listKT.totalPages-1}">
                        <li class="page-item ${i == page ? 'active' : ''}">
                            <a class="page-link" href="?page=QuanLySize&&pt=${i}">${i+1}</a>
                        </li>

                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>




</body>
</html>