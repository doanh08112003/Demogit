<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" action="/dat-phong/update/${dp.id}"
           modelAttribute="dp">
    <p>Mã:
        <form:input path="maDatPhong"/>
        <form:errors path="maDatPhong"/>
    </p>
    <p>Ngày đặt:
        <form:input path="ngayGioDat"/>
        <form:errors path="ngayGioDat"/>
    </p>
    <p>Số lượng khách:
        <form:input path="soLuongKhach"/>
        <form:errors path="soLuongKhach"/>
    </p>
    <p>Số lượng phòng:
        <form:input path="soLuongPhongDat"/>
        <form:errors path="soLuongPhongDat"/>
    </p>
    <p>Khách hàng:
        <form:select path="khachHang">
            <form:option value="">---</form:option>
            <form:options items="${dsKH}" itemLabel="tenKhachHang" itemValue="id"/>
        </form:select>
        <form:errors path="khachHang"/>
    </p>
    <button>Update</button>
</form:form>