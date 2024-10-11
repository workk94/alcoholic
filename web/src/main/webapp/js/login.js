$(document).ready(function() {
	$('#loginBtn').on('click', function(e) {
		let userIdInput = $('#user_id').val();
		let userPwInput = $('#user_pw').val();

		if (userIdInput === '') {
			e.preventDefault();
			alert('아이디를 입력하세요');
		} else if (userPwInput === '') {
			e.preventDefault();
			alert('비밀번호를 입력하세요');
		}
	});
});