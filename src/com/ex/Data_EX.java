package com.ex;

/* 하나의 데이터 생성자가 생산한 데이터를 데이터 계산자 세 개가 한 번씩
 * 	돌아가면서 데이터를 가져와 각 합을 구한다.
 * 	linkedlist 클래스와 list 인터페이스를 이용해 생산자와 계산자를 연결한다
 * 	데이터 계산자는 입력된 데이터 ArrayList클래스를 사용해 저장한다.
 * 	ArrayList에 저장된 데이터는 Iterator를 이용해 데이터를 가져온 뒤 합을 구한다.
 * 
 * 전체 데이터
 *  -78 27 -38 -45 31 88 19 41 6 -12 -32 -88 -28 59 63
 *  나누어진 데이터의 합
 *  cal1 = -49
 *  cal2 = -56
 *  cal3 = -59
 */
import java.util.*;
	
public class Data_EX {
	
	private List linkedlist = null;
	private List cal1, cal2, cal3;
	
	public Data_EX() {
	// linkedlist 객체 생성
		linkedlist = new LinkedList();
	// arraylist 객체 생성
		cal1 = new ArrayList();// cal1 -> cal2 -> cal3
		cal2 = new ArrayList();
		cal3 = new ArrayList();
	}
	void makeValue() {
		Random r = new Random();
		int Num,i;
		System.out.println("전체 데이터....");
		for( i =0; i<21; i++) {
			Num = (r.nextInt()%100);// 랜덤 값 생성
			linkedlist.add(Num); // 리스트에 값 저장
			System.out.print(Num+"\t");
		}
		System.out.println();
	}
	void Serve() {
		// Iterator 이라 값을 생성해서 가져옴
		int i = 0;
		Iterator it = linkedlist.iterator();
		
		while(it.hasNext()) {
			// 값을 가져옴
			cal1.add(it.next());
			cal2.add(it.next());
			cal3.add(it.next());
		}
		
	}
	
	void cal(List cal, int nIndex) {
		// 합계
		Iterator it = cal.iterator();
		int Sum = 0;
		Integer nNum;
		while(it.hasNext()) {
			nNum = (Integer)it.next();
			Sum += nNum;
		}

		System.out.println("Cal"+nIndex +" : "+Sum);
	}
	
	void Calculation() {
		System.out.println("나누어진 데이터의 합계 :");
		cal(cal1, 1);
		cal(cal2, 2);
		cal(cal3, 3);
	}
}
