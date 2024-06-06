<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>Document</title>
</head>
<body>
<c:choose>
    <c:when test="${nv !=null}">
        <nav class="navbar navbar-expand-lg bg-dark text-white">
            <div class="container-fluid px-5 ">
                <a class="navbar-brand" href="#!/">

                    <img src="https://scontent.fhan2-4.fna.fbcdn.net/v/t39.30808-6/444894348_122112041918313064_7585704985368427311_n.png?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=8pl6LNXRyQUQ7kNvgHQOWdr&_nc_ht=scontent.fhan2-4.fna&oh=00_AYBrlhisxC-oJZpSQsCxqcFnwe-svooU6gRfPIOesTJZcw&oe=66564854" alt="" style="width: 80px; height: 40px;">
                </a>

                <div class="d-flex align-items-center ">
                    <div class="d-flex me-3">
                        <p >${nv.ten}</p>
                        <div class=" vr m-2 "></div>
                        <p >${nv.vaiTro?"Admin":"Nhân viên"}</p>
                    </div>

                        <%--            <img class="ms-3 rounded-5" style="max-width: 80px; max-height: 60px;" src="/assignnment/img/avtMe.jpg"--%>
                        <%--                 alt="">--%>
                </div>
            </div>
            </div>
        </nav>

        <div class=" container-fluid d-flex p-0">
            <div style="width: 220px; min-height: calc(100vh - 59px);" class=" container bg-dark border-end p-1 m-0">
                <ul class="nav flex-column ">
                    <li class="nav-item py-3 " style="border: 1px solid rgb(0, 242, 255);">
                        <a class=" nav-link active text-white" aria-current="page" href="/shopaaa?page=QuanLySanPham">QUẢN LÝ SẢN PHẨM<i
                                class="fa-solid fa-table-list ps-3"></i></a>
                    </li>
                    <li class="nav-item py-3 " style="border: 1px solid rgb(0, 242, 255);">
                            <%--                <a class="nav-link text-white" href="">QUẢN LÝ THUỘC TÍNH SẢN PHẨM <i--%>
                            <%--                        class="fa-brands fa-product-hunt ps-3"></i></a>--%>
                        <div class="dropdown">
                            <a class="btn  dropdown-toggle text-white" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                                QUẢN LÝ THUỘC TÍNH
                            </a>

                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <li><a class="dropdown-item" href="/shopaaa?page=QuanLyMauSac">MÀU SẮC</a></li>
                                <li><a class="dropdown-item" href="/shopaaa?page=QuanLySize">SIZE</a></li>

                            </ul>
                        </div>
                    </li>
                    <c:if test="${nv.vaiTro}">
                        <li class="nav-item py-3 " style="border: 1px solid rgb(0, 242, 255);">
                            <a class="nav-link text-white" href="/shopaaa?page=QuanLyHoaDon">QUẢN LÝ HÓA ĐƠN<i
                                    class="fa-solid fa-truck-fast ps-3"></i></a>
                        </li>
                    </c:if>
                    <li class="nav-item py-3 " style="border: 1px solid rgb(0, 242, 255);">
                        <a class="nav-link text-white" href="/shopaaa?page=QuanLyKhachHang">QUẢN LÝ KHÁCH HÀNG<i class="fa-solid fa-user ps-3"></i></a>
                    </li>
                    <c:if test="${nv.vaiTro}">
                    <li class="nav-item py-3 " style="border: 1px solid rgb(0, 242, 255);">
                        <a class="nav-link text-white" href="/shopaaa?page=QuanLyNhanVien">QUẢN LÝ NHÂN VIÊN<i class="fa-solid fa-user ps-3"></i></a>
                    </li>
                    </c:if>
                    <li class="nav-item py-3 " style="border: 1px solid rgb(0, 242, 255);">
                        <a class="nav-link text-white" href="/shopaaa?page=QuanLyBanHang">BÁN HÀNG TẠI QUẦY<i class="fa-solid fa-user ps-3"></i></a>
                    </li>
                    <li class="nav-item py-3 " style="border: 1px solid rgb(0, 242, 255);">
                        <a class="nav-link text-white" href="/shopaaa/logout">ĐĂNG XUẤT <i
                                class="fa-solid fa-right-from-bracket ps-3"></i></i></a>
                    </li>
                </ul>
            </div>
            <div class="pt-4 ps-2" style="width: calc(100% - 250px);">

                <c:choose>
                    <c:when test="${param.page =='QuanLySanPham'}">
                        <%@include file="QuanLySanPham.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLySanPhamCT'}">
                        <%@include file="QuanLySanPhamCT.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLyNhanVien'}">
                        <%@include file="QuanLyNhanVien.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLyKhachHang'}">
                        <%@include file="QuanLyKhachHang.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLyBanHang'}">
                        <%@include file="QuanLyBanHang.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLyBanHang'}">
                        <%@include file="QuanLySanPham.jsp"%>
                    </c:when>
                    <%--                <c:when test="${param.page =='QuanLyThuocTinhSanPham'}">--%>
                    <%--                    <%@include file="QuanLyThuov.jsp"%>--%>
                    <%--                </c:when>--%>
                    <c:when test="${param.page =='QuanLyHoaDon'}">
                        <%@include file="QuanLyHoaDon.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLyHoaDonCT'}">
                        <%@include file="QuanLyHoaDonCT.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLySize'}">
                        <%@include file="QuanLySize.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLyMauSac'}">
                        <%@include file="QuanLyMauSac.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='QuanLyHoaDon'}">
                        <%@include file="QuanLyHoaDon.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='themNhanVien'}">
                        <%@include file="formThemNhanVien.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='themKhachHang'}">
                        <%@include file="formThemKhachHang.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='suaNhanVien'}">
                        <%@include file="formSuaNhanVien.jsp"%>
                    </c:when>
                    <c:when test="${param.page =='suaKhachHang'}">
                        <%@include file="formSuaKhachHang.jsp"%>
                    </c:when>
                    <c:otherwise>
                        <h1>Chào mừng bạn đến với trang quan lý shop AAA</h1>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </c:when>
    <c:when test="${nv == null}">
        <%@include file="login.jsp"%>
    </c:when>
</c:choose>
<!-- nav -->


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>