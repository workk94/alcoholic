package web.admin;

public class PageHandler {
	int pageSize;
	int grpSize;
	int totRecords;
	int currentPage;
	
	int totalPage;
	int currentGrp;
	int grpStartPage;
	int grpEndPage;
	
	public PageHandler(int pageSize, int grpSize, int totRecords, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		this.totRecords = totRecords;
		this.currentPage = currentPage;
		
		
		calcPage();
	}
	
	private void calcPage() {
		//총페이지수 구하기
		//현재그룹 구하기
		//현재그룹 시작
		//현재그룹 마지막값
		
		
		//1.총 페이지 수 구하기
		int remain = totRecords % pageSize;
		if (remain == 0) {
			totalPage = totRecords / pageSize;
		}else {
			totalPage = totRecords / pageSize+1;
		}
		
		
		//2. 현재그룹구하기
		int remain2 = currentPage % grpSize; 
		
		if(remain2 == 0) {
			currentGrp = currentPage / grpSize;
		}else {
			currentGrp = (currentPage / grpSize) +1;
		}
		
		
		//3.현재그룹 시작, 끝 구하기
		
		grpStartPage = (currentGrp-1) * grpSize +1;
		grpEndPage = currentGrp * grpSize;
		
		//4.
		if( grpEndPage > totalPage){
			 grpEndPage = totalPage;                      // 그룹의 끝번호   10 -> 9로 변경 , 그룹의 끝번호가 마지막페이지번호 크다면
		 }
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

	public int getCurrentGrp() {
		return currentGrp;
	}

	public int getGrpStartPage() {
		return grpStartPage;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}
}
