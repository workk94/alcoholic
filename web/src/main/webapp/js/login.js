$(document).ready(function() {
    $('#loginBtn').on('click', function(e) {
        let userId = $('#user_id').val();
        let userPw = $('#user_pw').val();

        if (userId === '') {
            e.preventDefault();
            alert('아이디를 입력하세요');
        } else if (userPw === '') {
            e.preventDefault();
            alert('비밀번호를 입력하세요');
        }
    });

    // 서버에서 전달된 메시지가 있을 경우 표시
    let msg = $("#msg").val(); 
    if (msg && msg !== '') {
        alert(msg);  
    }
});
