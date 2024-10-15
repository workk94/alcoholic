package web.model;

public class PageHandler {

	int currentPage; // 현재페이지
	int totRecords; // 총 레코드 수
	int pageSize; // 페이지 사이즈 (데이터 건수 , 한 페이지에 보이는 레코드 수 )
	int totalPage; // 총 페이지수: 전체 페이수

	int grpSize = 4; // 한 그룹에 5깨씩 보겟다
	int currentGrp; // 현재그룹
	int grpStartPage; // 현재그룹의 시작번호
	int grpEndPage; // 현재그룹의 마지막번호

	// 현재페이지, 전체레코드수, 페이지사이즈

	public PageHandler(int page, int totRecords) { // pageSize는 6으로 고정
		this.currentPage = page;
		this.totRecords = totRecords;
		this.pageSize = 6; // 페이지당 6개의 상품

		calcPage(); // 페이징 계산
	}

	public PageHandler(int page, int totRecords, int pageSize) {
		this.currentPage = page;
		this.totRecords = totRecords;
		this.pageSize = pageSize;

		// 페이징관련 값 구하기
		calcPage();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotRecords() {
		return totRecords;
	}

	public void setTotRecords(int totRecords) {
		this.totRecords = totRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getGrpSize() {
		return grpSize;
	}

	public void setGrpSize(int grpSize) {
		this.grpSize = grpSize;
	}

	public int getCurrentGrp() {
		return currentGrp;
	}

	public void setCurrentGrp(int currentGrp) {
		this.currentGrp = currentGrp;
	}

	public int getGrpStartPage() {
		return grpStartPage;
	}

	public void setGrpStartPage(int grpStartPage) {
		this.grpStartPage = grpStartPage;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}

	public void setGrpEndPage(int grpEndPage) {
		this.grpEndPage = grpEndPage;
	}

	private void calcPage() {
		int reamin = totRecords % pageSize;
		// 총 페이지수 구하기
		if (reamin == 0)
			totalPage = totRecords / pageSize;
		else
			totalPage = totRecords / pageSize + 1;
		// 현재그룹 구하기
		// 현재그룹의 시작번호
		// 현재그룹의 끝번호
		int remain2 = currentPage % grpSize; // 7 => 그룹2 , 시작 6 , 끝 10

		if (remain2 == 0)
			currentGrp = currentPage / grpSize; // 10 /5 =>2 , 2번째 그룹
		else
			currentGrp = currentPage / grpSize + 1; // 4 /5 + 1 => 1번째 그룹 , 7 /5 => 1 +1 => 2그룹

		grpStartPage = (currentGrp - 1) * grpSize + 1; // 그룹의 시작번호 현재그룹 1 => 1 , 현재그룹 2 -> 6
		grpEndPage = currentGrp * grpSize; // 그룹의 끝번호 1-> 5 , 2-> 10

		// 그룹의 마지막번호가 마지막페이지보다 크다면
		// 그룹의 마지막번호가 마지막페이지로 변경해야됨
		if (grpEndPage > totalPage) {
			grpEndPage = totalPage; // 그룹의 끝번호 10 -> 9로 변경 , 그룹의 끝번호가 마지막페이지번호 크다면
		}

	}

}
