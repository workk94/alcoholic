package web.model;

public class Paging {

	int pageSize;
	int grpSize;
	int totRecords;
	int currentPage;

	int totalPage;
	int currentGroup;
	int grpStartPage;
	int grpEndPage;

	public Paging(int pageSize, int grpSize, int totRecords, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		this.totRecords = totRecords;
		this.currentPage = currentPage;

		calcPage();
	}

	private void calcPage() {

		int remain = totRecords & pageSize;

		if (remain == 0) {
			totalPage = totRecords / pageSize;
		} else {
			totalPage = totRecords / pageSize + 1;
		}

		int remain2 = currentPage % grpSize;
		if (remain2 == 0) {
			currentGroup = currentPage / grpSize;
		} else {
			currentGroup = currentPage / grpSize + 1;
		}

		grpStartPage = (currentGroup - 1) * grpSize + 1;
		grpEndPage = currentPage * grpSize;

		if (grpEndPage > totalPage) {
			grpEndPage = totalPage;
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

	public int getCurrentGroup() {
		return currentGroup;
	}

	public int getGrpStartPage() {
		return grpStartPage;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}

	public static void main(String[] args) {
		/*
		 * PageHandler page = new PageHandler(5,4,46,1);
		 * 
		 * System.out.println(page.getTotalPage());
		 * System.out.println(page.getCurrentGroup());
		 * System.out.println(page.getGrpStartPage()); System.out.println(
		 * page.getGrpEndPage());
		 */
		// PageHandler page = new PageHandler(4,5,37,6);
		Paging page = new Paging(10, 4, 153, 13);
//			PageHandler page = new PageHandler(7,6,513,9);

		System.out.println(page.getTotalPage());
		System.out.println(page.getCurrentGroup());
		System.out.println(page.getGrpStartPage());
		System.out.println(page.getGrpEndPage());

	}

}
