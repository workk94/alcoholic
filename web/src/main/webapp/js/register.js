$(document).ready(function() {
	$("#checkIdBtn").on("click", function() {
		isUserExist();
	});

	$("#registerForm").on("submit", function(event) {
		if (!validateForm()) {
			event.preventDefault();  // 폼 제출 방지
		} else {
			alert("회원가입 완료");
		}
	});
});

// ID 중복 체크 함수
function isUserExist() {
	var id = $("#userId").val();

	if (id == '' || id.length == 0) {
		alert("아이디를 입력하세요.");
		return false;
	}

	$.ajax({
		url: '/web/idcheck',
		data: { id: id },
		type: 'POST',
		dataType: 'json',
		success: function(data) {
			// json객체의 exists값이 있는지 없는지 비교
			if (data.result) {
				$("#msg").css("color", "red").text("사용 불가능한 ID 입니다.");
				$("#userId").val(''); // 이미 있는 id인 경우 입력 필드를 비움
			} else {
				$("#msg").css("color", "green").text("사용 가능한 ID 입니다.");
			}
		},
		error: function() {
			alert("중복 체크 중 오류가 발생했습니다.");
		}
	});
}

// 폼 유효성 검사
function validateForm() {
	let id = $("#userId").val();
	let pw = $("input[name='pw']").val();
	let name = $("input[name='name']").val();
	let ssn = $("input[name='ssn']").val();
	let phone = $("input[name='phone']").val();
	let addr = $("input[name='addr']").val();

	if (pw == "" || name == "" || ssn == "" || phone == "" || addr == "") {
		alert("모든 값을 입력하세요.");
		return false;
	}

	if (id == "" || id.length == 0) {
		alert("공백은 아이디로 사용할 수 없습니다.");
		return false;
	}

	// 주민번호 형식 검사
	let ssnPattern = /^\d{6}-\d{7}$/;
	if (!ssnPattern.test(ssn)) {
		alert("주민번호 형식이 잘못되었습니다. (예: 123456-1234567)");
		return false;
	}

	// 전화번호 형식 검사
	let phonePattern = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if (!phonePattern.test(phone)) {
		alert("전화번호 형식이 잘못되었습니다. (예: 010-1234-5678)");
		return false;
	}

	return true; // 모든 유효성 검사를 통과한 경우 true 반환
}
