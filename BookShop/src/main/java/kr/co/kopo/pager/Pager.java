package kr.co.kopo.pager;

import java.util.ArrayList;
import java.util.List;

public class Pager {

	private int page = 1;
	private int perPage = 10;
	
	private int search;
	private String keyword;
	
	//페이지 이동 구현
	//전체 개수 나누기 페이지그룹을 하면 마지막 페이지를 추출 가능함.
	private float total;	//나누고 나서의 나머지도 필요하기 때문에 float을 씀.
	private int perGroup = 5;
	
	private int totalPage; // 전체 페이지 수
    private int startPage; // 현재 블록의 시작 페이지
    private int endPage; // 현재 블록의 마지막 페이지
    private boolean prev; // 이전 블록 여부
    private boolean next; // 다음 블록 여부
	
	
	public int getOffset() {
		return (page-1) * perPage;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	//필드는 선언되지 않았지만 넘겨줄 getter 작성
	public int getLast(){
		//나눠진 값을 올림해주고 int로 casting해줌.
		return (int)Math.ceil(total / perPage);
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getNext() {
		//페이지 그룹을 묶기위해 사용	(((page - 1) / perGroup) + 1) * perGroup : 현재 페이지의 그룹이 어디인가?
		//위의 수식에 +1을 해서 다음 그룹으로 이동하게됨.
		int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		
		return next <= last ? next : last;
	}
	public int getPrev() {
		int prev = (((page - 1) / perGroup) - 1) * perGroup + 1;
		
		return prev <= perGroup ? 1 : prev;
	}
	
	public List<Integer> getList(){
		List<Integer> list = new ArrayList<Integer>();
		
		//현재 그룹의 첫 번째 페이지
		int startPage = (((page - 1) / perGroup) + 0) * perGroup + 1;
		
		//현재 페이지부터 
		for(int i=startPage; i < (startPage + perGroup) && i <= getLast(); i++)
			list.add(i);
		
		//데이터 값이 없더라도 1번 페이지로 표시하기 위함.
		if(list.isEmpty())
			list.add(1);
		
		return list;
	}
	
}