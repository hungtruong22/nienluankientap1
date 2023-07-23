<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản Lý Tài Khoản</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="./css/manager.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link href="/App_Themes/Home/common.css" rel="stylesheet"
	type="text/css" />
<link href="/assets/100006/js/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all">
<link href="/assets/100006/js/nivo-slider/nivo-slider.css"
	rel="stylesheet" type="text/css" media="all">
<link href="/assets/100006/js/owl.carousel/owl.carousel.css"
	rel="stylesheet" type="text/css" media="all">
<link href="/assets/100006/css/settings.css" rel="stylesheet"
	type="text/css" media="all">
<link href="http://static.runtime.vn/App_Themes/RUN006/style.css"
	rel="stylesheet" type="text/css" />
<link href="http://static.runtime.vn/App_Themes/RUN006/responsive.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../css/style.css">


<!------ Include the above in your HEAD tag ---------->

<style>
img {
	width: 200px;
	height: 120px;
}

.mw-600 {
	max-width: 600px;
	width: 500px;
}

.feature {
	display: flex;
	justify-content: space-around;
}

.nav-flex-1 {
	display: flex;
	justify-content: center;
	align-items: center;
}

.navbar-toggle {
	color: #fff !important;
}

.logo-main {
	width: 100%;
	height: 70px;
	background-size: cover;
}

.can_nav {
	width: 100%;
	height: 100px;
}

.product-item .image img {
	max-width: 100%;
	max-height: 100%;
	box-sizing: border-box;
	z-index: -1;
	right: 0px;
	left: 0px;
	top: 0px;
	bottom: 0px;
	margin: auto;
	display: block;
	width: 100%;
	height: 120px;
}

.product-item .name {
	padding-top: 10px;
	padding-bottom: 4px;
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 1;
}

.active {
	background: #d74b33 !important;
	color: white !important;
}

.child:hover a {
	background: #d74b33;
	color: white !important;
	transition: 0.5s;
}

.newfood {
	background-color: #d74b33;
	color: #ffffff;
	font-size: 14px;
	font-weight: bold;
	padding: 15px 10px;
	text-transform: uppercase;
	margin: 0;
	position: relative;
}

.card-body {
	background: #f6f6f6;
	padding: 8px 6px;
}

.top-link ul li a {
	color: #fff;
	display: block;
	padding: 7px 10px;
	font-size: 12px;
	float: left;
}

.top-link ul {
	display: block;
}

.navbar-nav .nav-link {
	padding-right: 10px;
	padding-left: 0;
}

.bg-head {
	background: #d74b33 !important;
	color: white;
}

.td-light {
	background: #343a40;
	color: white;
	z-index: 6;
}

.link-hov {
	font-weight: 500;
}

.link-hov:hover {
	background: #d74b33;
	color: white !important;
	transition: 0.4s;
}

.logo-main {
	width: 100%;
	height: 70px;
	background-size: cover;
}

.flex-nav {
	display: flex;
	justify-content: space-between;
}

.but-change {
	-webkit-appearance: button;
	margin: 6px 0;
	padding: 0 10px;
	width: 89px;
	cursor: pointer;
	background: white;
	transition: 0.4s;
}

.but-change:hover {
	background: #d74b33;
	color: white;
}

.bg-table {
	background: #343a40;
	color: white;
}

.heading-food_name {
	width: 1100px;
	text-align: center;
	margin: auto;
	padding: 10px 0;
	font-weight: bold;
}

.nav-link:hover {
	background: #eee;
	color: #d74b33;
}

.top-link ul li a:hover {
	background: #eee;
	color: #d74b33;
}

.can-nut {
	width: 50px;
	height: 30px;
}

.can-ngang {
	display: flex;
	align-items: revert;
}
</style>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="header">
					<section class="top-link clearfix">
						<div class="">
							<div class="">
								<div class="col-md-12 can_nav flex-nav">
									<a class="navbar-brand" href="htsanpham"> <img
										class="logo-main" alt="logocang" src="./anhcang/cang.jpg">
									</a>
									<ul
										class="nav navbar-nav navbar-right topmenu  hidden-xs hidden-sm">
										<c:if test="${dn.lanhanvien == true }">
											<li class="nav-item"><a class="nav-link" href="#">Tài
													khoản Nhân Viên</a></li>
											<li class="order-cart"><a href="htgio"><i
													class="fa fa-shopping-cart"></i> Đặt món</a></li>
											<li class="order-cart"><a
												href="htdoimatkhau?mtk=${dn.matk}&&mk=${dn.matkhau}">
												 Đổi MK</a></li>
										</c:if>

										<c:if test="${dn.laquanly == true}">
											<li class="nav-item"><a class="nav-link" href="#">Tài
													khoản Quản lý</a></li>
											<li class="order-cart"><a href="htgio"><i
													class="fa fa-shopping-cart"></i> Đặt món</a></li>
											<li class="nav-item"><a class="nav-link" href="quanlytaikhoanController">
													Quản lý TK</a></li>
											<li class="nav-item"><a class="nav-link" href="quanlyloaiController">
													Quản lý Loại</a></li>
											<li class="nav-item"><a class="nav-link"
												href="quanlymonanController"> Quản lý MA</a></li>
											<li class="nav-item"><a class="nav-link" href="quanlyhoadonController">
													Quản lý HD</a></li>
											<li class="nav-item"><a class="nav-link" href="#">
													Thống kê</a></li>
											<li class="order-cart"><a
												href="htdoimatkhau?mtk=${dn.matk}&&mk=${dn.matkhau}">
												 Đổi MK</a></li>
										</c:if>


										<c:if test="${dn != null}">
											<li class="nav-item"><a class="nav-link" href="#">Hello
													${dn.tendn}</a></li>
											<li class="nav-item"><a class="nav-link"
												href="dangxuatController">Đăng xuất</a></li>
										</c:if>
										<c:if test="${dn == null}">
											<li class="account-login"><a href="dangnhapController"><i
													class="fa fa-sign-in"></i> Đăng nhập </a></li>


											<li class="account-register"><a href="dangkyController"><i
													class="fa fa-key"></i> Đăng ký </a></li>
										</c:if>

									</ul>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>
		<div class="container">
		<div class="table-wrapper">
			<div class="table-title bg-table">
				<div class="row">
					<div class="col-sm-6">
						<h1 class="heading-food_name">Danh Sách Tài Khoản</h1>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><span class="custom-checkbox"> <input
								type="checkbox" id="selectAll"> <label for="selectAll"></label>
						</span></th>
						<th>Mã TK</th>
						<th>Tên TK</th>
						<th>Mật Khẩu</th>
						<th>Chức Vụ</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dstrang}" var="s">
					
						<tr>
							<td><span class="custom-checkbox"> <input
									type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
							</span></td>
							<td>${s.matk}</td>
							<td>${s.tendn}</td>
							<td>${s.matkhau}</td>
							<c:if test="${s.lanhanvien == true}">
								<td>Nhân Viên</td>
							</c:if>
							<c:if test="${s.laquanly == true}">
								<td>Quản Lý</td>
							</c:if>

							<td><a href="suataikhoanController?mataikhoan=${s.matk}"
								class="edit" data-toggle="modal"> <i class="material-icons"
									title="Edit">&#xE254;</i></a> <a
								href="xoataikhoanController?mataikhoan=${s.matk}" class="delete"
								data-toggle="modal"> <i class="material-icons"
									title="Delete">&#xE872;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav class="nav-flex-1" aria-label="Page navigation example">
				<ul class="pagination">
					<c:forEach begin="1" end="${endPage}" var="i">
						<c:if test="${tag==i}">
							<li class="page-item active"><a class="page-link"
								href="quanlytaikhoanController?trang=${i}">${i}</a></li>
						</c:if>
						<c:if test="${tag != i}">
							<li class="page-item"><a class="page-link"
								href="quanlytaikhoanController?trang=${i}">${i}</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</nav>
		</div>
		<div class="feature">
			<!-- Edit Modal HTML -->
			<div id="addEmployeeModal" class="">
				<div class="modal-dialog mw-600">
					<div class="modal-content">
						<form action="themtaikhoanController" method="post">
							<div style="background-color: #28a745" class="modal-header">
								<h4 class="modal-title">Thêm Tài Khoản</h4>
								<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label>Tên Tài Khoản</label> <input name="tentaikhoan"
										type="text" class="form-control" required>
										<p class="text-danger">${tbloidk}</p>
								</div>
								<div class="form-group">
									<label>Mật Khẩu</label> <input name="matkhautaikhoan"
										type="text" class="form-control" required>
								</div>
								<div class="form-group">
									<label>Nhập Lại Mật Khẩu</label> <input name="nhaplaimatkhautaikhoan"
										type="text" class="form-control" required>
									<p class="text-danger">${tbloi}</p>
								</div>
							</div>
							<div class="modal-footer can-ngang">
								<input type="button" class="btn btn-default can-nut"
									data-dismiss="modal" value="Hủy"> <input type="submit"
									class="btn btn-success can-nut" value="Thêm">
							</div>
						</form>
					</div>
				</div>
			</div>


			<!-- Edit Modal HTML -->
			<div id="editEmployeeModal" class="">
				<div class="modal-dialog mw-600">
					<div class="modal-content">
						<form action="edittaikhoanController" method="post">
							<div style="background-color: #FFC107" class="modal-header">
								<h4 class="modal-title">Chỉnh sửa tài khoản</h4>
								<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label>Mã Tài Khoản</label> <input name="matk"
										value="${account.matk}" type="text" class="form-control"
										readonly required>
								</div>
								<div class="form-group">
									<label>Tên Tài Khoản</label> <input name="tentk"
										value="${account.tendn}" type="text" class="form-control"
										required>
								</div>
								<div class="form-group">
									<label>Mật Khẩu</label> <input name="matkhautk"
										value="${account.matkhau}" type="text" class="form-control"
										required>
								</div>
								<div class="form-group">
									<label>Chức vụ</label> 
									<c:if test="${account.lanhanvien == true}">
										<input name="chucvutk"
										value="NhanVien" type="text" class="form-control"
										required>
									</c:if>
									
									<c:if test="${account.laquanly == true}">
										<input name="chucvutk"
										value="QuanLy" type="text" class="form-control"
										required>
									</c:if>
								</div>
							</div>
							<div class="modal-footer can-ngang">
								<input type="button" class="btn btn-default can-nut"
									data-dismiss="modal" value="Hủy"> <input type="submit"
									class="btn btn-info can-nut" value="Lưu">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="js/manager.js" type="text/javascript"></script>
	<script>
        $(document).ready(function () {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            $("#selectAll").click(function () {
                if (this.checked) {
                    checkbox.each(function () {
                        this.checked = true;
                    });
                } else {
                    checkbox.each(function () {
                        this.checked = false;
                    });
                }
            });
            checkbox.click(function () {
                if (!this.checked) {
                    $("#selectAll").prop("checked", false);
                }
            });
        });

        </script>
</body>
</html>