package com.biz.score.exec;

import java.util.Scanner;

import com.biz.score.service.ScoreService;
import com.biz.score.service.ScoreServiceImplV1;

public class ScoreEx_01 {
	
	public static void main(String[] args) {
		ScoreService sService = new ScoreServiceImplV1();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("====================================================");
			System.out.println("학생 관리 시스템 V1");
			System.out.println("====================================================");
			System.out.println("1.성적등록");
			System.out.println("2.성적일람표 출력");
			System.out.println("3.성적일람표 저장");
			System.out.println("-1.업무종료");
			System.out.println("====================================================");
			System.out.print("업무선택>>");
			
			String strManu = scan.nextLine();
			
			int intManu = 0;
			
			try {
				intManu = Integer.valueOf(strManu);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("메뉴는 숫자로만 선택할수 있음!!");
				continue;
			}
			if(intManu==-1) {
				break;
			}
			if(intManu == 1) {
				while(sService.inputScore());
			} else if (intManu == 2) {
				sService.scoreList();
			} else if (intManu == 3) {
				sService.scoreListSave();
			}
		}
		System.out.println("업무종료!!!");
		System.out.println("야 퇴근이다!!!");
	}

}
