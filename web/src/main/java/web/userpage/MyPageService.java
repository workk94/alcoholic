package web.userpage;

import web.model.User;

public class MyPageService {
    MyPageDAO mypagedao = new MyPageDAO();

    public void modifyMember(String id, String pw, String ssn, String phone, String addr) {
        // 전달받은 매개변수를 이용하여 User 객체 생성
        User user = new User(id, pw, "", ssn, phone, addr);  // 생성자에 맞게 빈 필드 또는 필요한 정보를 추가
        
        // 생성한 User 객체를 DAO의 update 메서드에 전달
        mypagedao.update(user);
    }
}
