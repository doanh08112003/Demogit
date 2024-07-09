<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Quản lý đặt phòng</h3>

<%@include file="_form.jsp"%>

<form action="/dat-phong/search">
    <input placeholder="Mã đặt phòng" name="keyword" value="${param.keyword}">
    <button>Tìm</button>
</form>

<table border="1">
    <tr>
        <td>Mã</td>
        <td>Ngày đặt</td>
        <td>Số lượng khách</td>
        <td>Số lượng phòng</td>
        <td>Tên khách hàng</td>
        <td>Hành động</td>
    </tr>
    <c:forEach items="${list}" var="dp">
        <tr>
            <td>${dp.maDatPhong}</td>
            <td>${dp.ngayGioDat}</td>
            <td>${dp.soLuongKhach}</td>
            <td>${dp.soLuongPhongDat}</td>
            <td>${dp.khachHang.tenKhachHang}</td>
            <td><a href="/dat-phong/view-update/${dp.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>
