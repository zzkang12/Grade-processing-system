package com.mscore;

import java.util.HashMap;
//import java.util.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score{

	private Map<String, ScoreVO> map = new HashMap<String, ScoreVO>();
	//private Map<String, ScoreVO> map1 = new TreeMap<String, ScoreVO>();
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void insert() {
		System.out.println("\n 자료 추가................");
		String hak;
		System.out.print("학번 입력:");
		hak = sc.next();
		
		if(map.containsKey(hak)) {
			System.out.println("등록된 학번입니다. \n");
			return;
		}
		ScoreVO vo = new ScoreVO(); // 필드에 저장	
		
		System.out.print("이름 :");
		vo.setName(sc.next());
		
		System.out.print("생년월일 :");
		vo.setBirth(sc.next());

		System.out.print("국어점수 :");
		vo.setKor(sc.nextInt());
		
		System.out.print("영어점수 :");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학점수 :");
		vo.setMat(sc.nextInt());
		
		map.put(hak, vo);
		System.out.println("추가 완료 .........\n");
	}

	@Override
	public void update() {
		System.out.println("\n 자료 수정 ............");
		String hak;
		System.out.print("수정할 학번입력:");
		hak = sc.next();
		if(!map.containsKey(hak)) {
			System.out.println("등록된 자료가 없습니다.");
			return;
		}
		ScoreVO vo = map.get(hak);
		
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
		
		if(!map.containsKey(hak)) {
			System.out.println("등록된 자료가 아닙니다.");
			return;
		}
		/*
		ScoreVO vo = map.get(hak);
		if(vo == null) {
			System.out.println("등록된 자료가 없습니다.");
			return;
		}
		*/
		map.remove(hak);
		System.out.println("자료 삭제 완료..............\n");
		
	}

	@Override
	public void listAll() {
		System.out.println("\n 전체 출력.............");
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String hak = it.next();
			ScoreVO vo = map.get(hak);
			/*
			System.out.print(hak + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getBirth() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMat() + "\t");
			System.out.print(vo.getTot() + "\t");
			System.out.println((float)vo.getTot()/3);
			*/
			System.out.println(vo);
		}
		System.out.println();
	}

	@Override
	public void searchHak() {
		System.out.println("\n 학번 검색...........");
		String hak;
		System.out.print("검색할 학번 입력:");
		hak = sc.next();
		if(!map.containsKey(hak)) {
			System.out.println("등록된 자료가 없습니다.\n");
			return;
		}
		ScoreVO vo = map.get(hak);
		System.out.println(vo);
	}

	@Override
	public void searchName() {
		System.out.println("\n 이름 검색.............");
		String name;
		System.out.print("검색할 이름입력:");
		name = sc.next();
		
		Iterator<String> it = map.keySet().iterator();// 이게 중요
		while(it.hasNext()) {
			String hak = it.next();
			ScoreVO vo =map.get(hak);
			
			if(vo.getName().startsWith(name)) {
				System.out.print(hak + "\t");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getBirth() + "\t");
				System.out.print(vo.getKor() + "\t");
				System.out.print(vo.getEng() + "\t");
				System.out.print(vo.getMat() + "\t");
				System.out.print(vo.getTot() + "\t");
				System.out.println((float)vo.getTot()/3);
			}
		}
		
	}

}
