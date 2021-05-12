package com.ascore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImple implements Score {
	
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	private Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void insert() {
		System.out.println("\n자료 추가............");
		String hak;
		System.out.print("학번 : ");
		hak = sc.next();
		
		ScoreVO temp = readScore(hak);
		
		if(temp != null) {
			System.out.println("등록된 학번입니다.");
			return;
		}
		ScoreVO vo = new ScoreVO();
		vo.setHak(hak);
		
		System.out.print("이름 :");
		vo.setName(sc.next());
		
		System.out.print("생년월일 :");
		vo.setBirth(sc.next());
		
		System.out.print("국어 :");
		vo.setKor(sc.nextInt());

		System.out.print("영어 :");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학 :");
		vo.setMat(sc.nextInt());

		list.add(vo);
		System.out.println("자료 추가 완료 ...........");
		
		
	}

	@Override
	public void update() {
		System.out.println("\n 자료 수정...........");
		String hak;
		System.out.print("수정할 학번 :");
		hak = sc.next();
		ScoreVO vo = readScore(hak);
		if(vo == null) {
			System.out.println("등록된 자료가 없습니다.");
			return;
		}
		System.out.print("이름 :");
		vo.setName(sc.next());
		
		System.out.print("생년월일 :");
		vo.setBirth(sc.next());
		
		System.out.print("국어 :");
		vo.setKor(sc.nextInt());

		System.out.print("영어 :");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학 :");
		vo.setMat(sc.nextInt());
		
		System.out.println("자료 수정 완료..........\n");
	}

	@Override
	public void delete() {
		System.out.println("\n 자료 삭제.............");
		String hak;
		System.out.println("삭제할 학번 입력:");
		hak = sc.next();
		
		ScoreVO vo = readScore(hak);
		if(vo == null) {
			System.out.println("등록된 자료가 없습니다.");
			return;
		}

		// 리스트에서 삭제
		list.remove(vo);
		System.out.println("자료 삭제 완료...........\n");
		
	}

	@Override
	public void listAll() {
		// TODO Auto-generated method stub
		System.out.println("\n 전체 출력..............");
		Iterator<ScoreVO> it = list.iterator();
		
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo);
		}
		
		System.out.println();
	}

	@Override
	public void searchHak() {
		System.out.println("\n 학번 검색.................");
		
		String hak;
		System.out.println("\n 검색할 학번을 입력하세요.");
		hak = sc.next();
		
		ScoreVO vo = readScore(hak);
		if(vo != null) {
			System.out.println(vo);
		}else
			System.out.println("등록된 자료가 없습니다.");
			System.out.println();
	}

	@Override
	public void searchName() {
		System.out.println("\n이름 검색.................");
		String name;
		System.out.println("\n 검색할 이름을 입력하세요.");
		name = sc.next();
		
		for(ScoreVO vo : list) {
			if(vo.getName().startsWith(name)) {
				System.out.println(vo);	
			}
		}
		System.out.println();
	}
	
	public ScoreVO readScore(String hak) {
		ScoreVO vo = null;
		
		for(ScoreVO temp : list) {
			if(temp.getHak().equals(hak)) {
				vo = temp;
				break;
			}
			
		}
		return vo;
	}

}
