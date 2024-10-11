package web.review;

public class Paging {

	//먼저 설정할 부분들
	//페이지 사이즈  한 페이지의 글 개수
	//페이지 그룹 사이즈	[1] [2]	[3]	[4]	[5]
	
	// 총 레코드 수 (테이블로 부터 얻어오기)
	
	//현재 페이지 설정 
	//총 페이지 수 
	//현재 그룹구하기
	//현재 그룹의 시작 값(번호)과  마지막값(번호)을 구하기위해 현재그룹을 먼저 구해야한다
	
	
	int pageSize;
	int grpSize;
	int totRecords;
	int currentPage;
	
	int totalPage;
	int currentGroup;
	int grpStartPage;
	int grpEndPage;
	
	public Paging(int pageSize, int grpSize, int totRecords, int currentPage) {
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		this.totRecords = totRecords;
		this.currentPage = currentPage;
		calcPage();
	}

	private void calcPage() {
		//1.총 페이지 수 구하기
		//2.현재 페이지에 대한 현재그룹 구하기
		//3. 현재 그룹 시작번호
		//4. 현재 그룹 마지막번호 
		
		//1.
		int remain = totRecords % pageSize;
		
		if(remain ==0) {
			totalPage	= totRecords / pageSize ;
		}else {
			totalPage	= totRecords / pageSize +1;
		}
		//2.
		int remain2 = currentPage % grpSize ; 
		if(remain2 == 0) {
			currentGroup = currentPage / grpSize ;
		} else {
			currentGroup = currentPage / grpSize +1;
		}
		
		//3.
		grpStartPage = (currentGroup - 1 )*grpSize +1; 
		grpEndPage = currentPage *grpSize;
		
		
		//4. 그룹의 마지막 값 확인하기
		if(grpEndPage > totalPage) {
			grpEndPage = totalPage;
		}
	}
	 // 전체 레코드 수 업데이트 메서드
    public void updateTotRecords(int newTotRecords) {
        this.totRecords = newTotRecords;
        calcPage(); // 페이지 계산을 다시 수행
    }
	
	public int getPageSize() {
		return pageSize;
	}

	public int getGrpSize() {
		return grpSize;
	}

	public int getTotRecords() {
		return totRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentGroup() {
		return currentGroup;
	}

	public int getGrpStartPage() {
		return grpStartPage;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}
	
	//	public PageHandler(int pageSize, int grpSize, int totRecords, int currentPage) {

	public static void main(String[] args) {
	
		Paging page = new Paging(10,4,153,13);
//		PageHandler page = new PageHandler(7,6,513,9);
		
		System.out.println(page.getTotalPage());
		System.out.println(page.getCurrentGroup());
		System.out.println(page.getGrpStartPage());
		System.out.println(page.getGrpEndPage());
	

}

}