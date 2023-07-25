<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="./anhcang/cang.jpg" type="image/gif" sizes="20x20">
<title>Giỏ hàng</title>
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
<script src="/assets/100006/js/jquery.min.1.11.0.js"></script>
<script src="/assets/100006/js/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/100006/js/nivo-slider/jquery.nivo.slider.js"
	type="text/javascript"></script>
<script src="/assets/100006/js/owl.carousel/owl.carousel.js"
	type="text/javascript"></script>
<script src="/assets/100006/js/option_selection.js"
	type="text/javascript"></script>
<script src="/assets/100006/js/api.jquery.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="/assets/100006/fonts/opensans/css/opensans.css">

<script data-target=".products-resize" data-parent=".product-wrapper"
	data-img-box=".image" src="/assets/100006/js/fixheightproduct.js"></script>
<script src="/Scripts/common/common.js" type="text/javascript"></script>
<script src="/Scripts/common/jquery.cookie.js" type="text/javascript"></script>
<script src="/Scripts/common/mycard.js" type="text/javascript"></script>
<script src="/Scripts/lazyLoad/jquery.lazyload.min.js"
	type="text/javascript"></script>

<script src="/Scripts/angularJS/angular.min.js"></script>
<script src="/Scripts/angularJS/angular-sanitize.min.js"></script>
<script type="text/javascript"
	src="/Scripts/angular-loading-spinner/spin.min.js"></script>
<script type="text/javascript"
	src="/Scripts/angular-loading-spinner/angular-spinner.min.js"></script>
<script type="text/javascript"
	src="/Scripts/angular-loading-spinner/angular-loading-spinner.js"></script>
<script src="/app/appMain.js"></script>
<script src="/app/directives/directive.js"></script>
<script src="/app/directives/angular-summernote.js"></script>
<script src="/app/directives/paging.js"></script>
<script src="/app/services/ajaxServices.js"></script>
<script src="/app/services/alertsServices.js"></script>
<link href="http://static.runtime.vn/App_Themes/RUN006/style.css"
	rel="stylesheet" type="text/css" />
<link href="http://static.runtime.vn/App_Themes/RUN006/responsive.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../css/style.css">
</head>
<style>
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

.nav-link:hover {
	background: #eee;
	color: #d74b33;
}

.top-link ul li a:hover {
	background: #eee;
	color: #d74b33;
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
</style>
<body>
	<div class="wrapper page-home">

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
												<li class="nav-item"><a class="nav-link"
													href="quanlytaikhoanController"> Quản lý TK</a></li>
												<li class="nav-item"><a class="nav-link"
													href="quanlyloaiController"> Quản lý Loại</a></li>
												<li class="nav-item"><a class="nav-link"
													href="quanlymonanController"> Quản lý MA</a></li>
												<li class="nav-item"><a class="nav-link"
													href="quanlyhoadonController"> Quản lý HD</a></li>
												<li class="nav-item"><a class="nav-link"
													href="thongkeController"> Thống kê</a></li>
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
		<div class="shopping-cart">
			<div class="px-4 px-lg-0">

				<div class="pb-5">
					<div class="container">
						<div class="row">
							<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

								<!-- Shopping cart table -->
								<div class="table-responsive">
									<form action="suaxoa" method="post">
										<table class="table">
											<thead>
												<tr>
													<th scope="col" class="border-0 td-light">
														<div class="p-2 px-3 text-uppercase">Chọn</div>
													</th>
													<th scope="col" class="border-0 td-light">
														<div class="p-2 px-3 text-uppercase">Mã MA</div>
													</th>
													<th scope="col" class="border-0 td-light">
														<div class="py-2 text-uppercase">Tên MA</div>
													</th>
													<th scope="col" class="border-0 td-light">
														<div class="py-2 text-uppercase">Ảnh</div>
													</th>
													<th scope="col" class="border-0 td-light">
														<div class="py-2 text-uppercase">Giá</div>
													</th>
													<th scope="col" class="border-0 td-light">
														<div class="py-2 text-uppercase">Số lượng</div>
													</th>
													<th scope="col" class="border-0 td-light">
														<div class="p-2 px-3 text-uppercase">Sửa số lượng</div>
													</th>
													<th scope="col" class="border-0 td-light">
														<div class="p-2 px-3 text-uppercase">Thành tiền</div>
													</th>
												</tr>
											</thead>
											<tbody>
												<p style="display: none;">
													<c:out value="gstt"></c:out>
												</p>
												<p style="display: none;">
													<c:out value="demsl"></c:out>
												</p>
												<c:forEach items="${ds}" var="h" varStatus="stt">
													<tr>
														<p style="display: none">${stt.count}</p>
														<p style="display: none" name="stt">${gstt = gstt + stt.count}</p>

														<td><input type="checkbox" name="butcheck"
															value="${h.getMamonan()}"></td>
														<td>${h.getMamonan()}</td>
														<td>${h.getTenmonan()}</td>
														<td><img class="card-img-top" src="${h.anh}"></td>
														<td>${h.getGia()}</td>
														<td>${h.getSoluong()}</td>
														<p style="display: none">${demsl = demsl+ h.getSoluong()}</p>
														<td><input type="number" min="0"
															name="txt${h.getMamonan()}">
															<div>
																<button type="submit" name="butsua" class="but-change"
																	value="${h.getMamonan()}">Cập nhật</button>
																<button type="submit" name="butxoa" class="but-change"
																	value="${h.getMamonan()}">Xóa</button>
															</div></td>
														<td>${h.getThanhtien()}</td>

													</tr>

												</c:forEach>

											</tbody>
										</table>
									</form>
								</div>
								<!-- End -->
							</div>
						</div>

						<div class="row py-5 p-4 bg-white rounded shadow-sm">
							<div class="col-lg-6">
								<div
									class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold bg-head">Thành
									tiền</div>
								<div class="p-4">
									<ul class="list-unstyled mb-4">
										<li class="d-flex justify-content-between py-3 border-bottom"><strong
											class="text-muted">Tổng tiền</strong><strong>${tongtien}
												vnđ</strong></li>
										<li class="d-flex justify-content-between py-3 border-bottom"><strong
											class="text-muted">Tổng số lượng</strong><strong>
												${demsl}</strong></li>
										<!--<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Phí vận chuyển</strong><strong>Free
											ship</strong></li>-->
										<%
										float gantt = 0;
										%>
										<c:if test="${demsl < 3}">
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted">Giá Khuyến mãi</strong><strong>${gantt =0}
													vnđ</strong></li>
										</c:if>
										<c:if test="${demsl >= 3 && demsl <= 10}">
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted">Giá Khuyến mãi</strong> <strong>${gantt = tongtien*(20/100)}
													vnđ</strong></li>
										</c:if>
										<c:if test="${demsl > 10}">
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted">Giá Khuyến mãi</strong> <strong>${gantt = tongtien*(30/100)}
													vnđ</strong></li>

										</c:if>
										<li class="d-flex justify-content-between py-3 border-bottom"><strong
											class="text-muted">Tổng thanh toán</strong>
											<h5 class="font-weight-bold">${tongtien-gantt}vnđ</h5></li>
									</ul>
									<a
										href="datmonanController?tongtien=${tongtien}&thanhtoan=${tongtien-gantt}&giakhuyenmai=${gantt}&nhanvien=${dn.tendn}"
										class="btn btn-dark rounded-pill py-2 btn-block link-hov">Đặt
										món</a>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>