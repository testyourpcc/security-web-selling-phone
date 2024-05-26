<%@ page pageEncoding="utf-8"%>


<div class="container-fluid" style="padding: 0px 80px 0px 80px">
	<h3 class="title">
		<b>GỬI THÔNG TIN PHẢN HỒI</b>
	</h3>
	<div class="ct1">
		<div class="row">
			<br>
			<div class="dang-nhap">
				<form id="fb" class="form-horizontal" action="addFeedBack.htm"
					method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<script src="https://www.google.com/recaptcha/api.js" async defer></script>
					<div class="control-group">
						<label class="control-label" for="inputCountry">Họ và tên
							<span style="color: red;">(*)</span>
						</label>
						<div class="controls">
							<input id="name" name="name" style="width: 100%;"
								placeholder="Họ và tên" type="text" class="form-control"
								value=""><br>

						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPost">Số điện thoại
							<span style="color: red;">(*)</span>
						</label>
						<div class="controls">
							<input id="phone" name="phone" style="width: 100%;"
								placeholder="Số điện thoại" type="text" class="form-control"
								value=""><br>

						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputCountry">Email <span
							style="color: red;">(*)</span>
						</label>
						<div class="controls">
							<input id="email" name="email" style="width: 100%;"
								placeholder="Email" type="text" class="form-control" value=""><br>

						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputPost">Nội dung <span
							style="color: red;">(*)</span>
						</label>
						<div class="controls">
							<textarea id="content" name="content" style="width: 100%;"
								placeholder="Nội dung" type="text" class="form-control" rows="6"></textarea>
							<br>

						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputCountry">Ngày gửi
							phản hồi </label>
						
							<div id="ngayGuiPhanHoi" class="controls"></div>
					
					</div>
					<div class="control-group" hidden="">
						<label class="control-label" for="inputPost">Trạng thái </label>
						<div class="controls">
							<input id="status1" name="status" type="radio" value="false">
							Kích hoạt &nbsp;&nbsp; <input id="status2" name="status"
								checked="true" type="radio" value="true"> Khóa

						</div>
					</div>
					<br />
					<div class="control-group">
					<div id="error"></div>
						<div class="controls text-center">
							<button type="button" class="btn btn-success">Gửi</button>
						</div>
						<div class="g-recaptcha" data-sitekey="6LfjCjYpAAAAANlxTdqYdxy1dFpopgrMaEczYy9x"></div>
					</div>
					<br />
				</form>
				<script src="/static/js/loginCaptcha.js"></script>
			</div>
		</div>
	</div>
</div>

<hr class="soft">

<style>
.dang-nhap {
	background-color: white;
	padding: 30px 120px;
	margin: 0 auto;
	width: 60%;
	margin-bottom: 25px;
}
</style>
<script>
    // Lấy thẻ hiển thị ngày gửi phản hồi bằng id
    var ngayGuiPhanHoiElement = document.getElementById("ngayGuiPhanHoi");

    // Tạo một đối tượng Date đại diện cho ngày và giờ hiện tại
    var ngayHienTai = new Date();

    // Định dạng ngày tháng năm theo định dạng mong muốn (VD: DD/MM/YYYY)
    var ngayGui = ngayHienTai.getDate();
    var thangGui = ngayHienTai.getMonth() + 1;
    var namGui = ngayHienTai.getFullYear();
    var gioGui = ngayHienTai.getHours();
    var phutGui = ngayHienTai.getMinutes();
    var giayGui = ngayHienTai.getSeconds();

    // Hiển thị ngày gửi phản hồi trong thẻ HTML đã chỉ định
    ngayGuiPhanHoiElement.innerHTML = ngayGui + '/' + thangGui + '/' + namGui + ' ' + gioGui + ':' + phutGui + ':' + giayGui;
</script>
