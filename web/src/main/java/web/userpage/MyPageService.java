package web.userpage;

public class MyPageService {
    MyPageDAO mypagedao = new MyPageDAO();

    
    public void modifyMember(String id, String pw, String ssn, String phone, String addr) {
        mypagedao.update(id, pw, ssn, phone, addr);
    }
}
