package com.biz.score.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.score.domain.ScoreVO;

public class ScoreServiceImplV1 implements ScoreService {
	protected List<ScoreVO> scoreList;
	protected Scanner scan;
	String fileName; 
	
	public ScoreServiceImplV1() {
		// TODO Auto-generated constructor stub
		scoreList = new ArrayList<ScoreVO>();
		scan = new Scanner(System.in);
		fileName = "src/com/biz/score/data/score.txt";
		this.scoreLoard();
	}
	
	
	@Override
	public boolean inputScore() {
		// TODO Auto-generated method stub
		ScoreVO scoreVO = new ScoreVO();
		
		System.out.print("학번(END:종료)>>");
		String strNum = scan.nextLine();
		if(strNum.equals("END")) {
			return false;
		}
		int intNum = 0;
		try {
			intNum = Integer.valueOf(strNum);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("학번은 숫자만 가능!!");
			System.out.println("다시 입력해 주세요.");
			return true;
		}
		if(intNum < 1 || intNum > 99999) {
			System.out.println("학번은 1~99999까지의 숫자만 가능!!");
			System.out.println("다시 입력해 주세요.");
			return true;
		}
		strNum = String.format("%05d", strNum);
		
		for (ScoreVO scoreVO2 : scoreList) {
			if(scoreVO.getNum().equals(strNum)) {
				System.out.println("이미 등록된 학번입니다");
				System.out.println("다시 입력해 주세요.");
				return true;
			}
		}
		scoreVO.setNum(strNum);
		
		System.out.println("국어(END:종료)>>");
		String strKor = scan.nextLine();
		int intKor = 0;
		if(strKor.equals("END")) {
			return false;
		}
		try {
			intKor = Integer.valueOf(strKor); 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("점수는 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		if (intKor < 0 || intKor > 100) {
			System.out.println("점수는 0~100까지 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		scoreVO.setKor(intKor);
		
		System.out.println("영어(END:종료)>>");
		String strEng = scan.nextLine();
		int intEng = 0;
		if(strEng.equals("END")) {
			return false;
		}
		try {
			intEng = Integer.valueOf(strEng); 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("점수는 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		if (intEng < 0 || intEng > 100) {
			System.out.println("점수는 0~100까지 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		scoreVO.setEng(intEng);
		
		System.out.println("수학(END:종료)>>");
		String strMath = scan.nextLine();
		int intMath = 0;
		if(strMath.equals("END")) {
			return false;
		}
		try {
			intMath = Integer.valueOf(strMath); 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("점수는 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		if (intMath < 0 || intMath > 100) {
			System.out.println("점수는 0~100까지 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		scoreVO.setMath(intMath);
		
		System.out.println("음악(END:종료)>>");
		String strMusic = scan.nextLine();
		int intMusic = 0;
		if(strMusic.equals("END")) {
			return false;
		}
		try {
			intMusic = Integer.valueOf(strMusic); 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("점수는 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		if (intMusic < 0 || intMusic > 100) {
			System.out.println("점수는 0~100까지 숫자만 가능");
			System.out.println("다시 입력해 주세요");
			return true;
		}
		scoreVO.setMusic(intMusic);
		
		scoreList.add(scoreVO);
		this.scoreSave(scoreVO);
		return true;
		
		
	}

	@Override
	public void scoreSave(ScoreVO scoreVO) {
		// TODO Auto-generated method stub
		
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		
		try {
			fileWriter = new FileWriter(fileName, true);
			
			printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%s:",scoreVO.getNum());
			printWriter.printf("%d:",scoreVO.getKor());
			printWriter.printf("%d:",scoreVO.getEng());
			printWriter.printf("%d:",scoreVO.getMath());
			printWriter.printf("%d\n",scoreVO.getMusic());
			printWriter.flush();
			printWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scoreListSave() {
		// TODO Auto-generated method stub
		String fileListName = "src/com/biz/score/data/scoreList.txt";
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		
		try {
			fileWriter = new FileWriter(fileListName, true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.print(this.scoreList);
			printWriter.flush();
			printWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void scoreLoard() {
		// TODO Auto-generated method stub
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while(true) {
				reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				String[] scores = reader.split(":");
				ScoreVO scoreVO = new ScoreVO();
				scoreVO.setNum(scores[0]);
				scoreVO.setKor(Integer.valueOf(scores[1]));
				scoreVO.setEng(Integer.valueOf(scores[2]));
				scoreVO.setMath(Integer.valueOf(scores[3]));
				scoreVO.setMusic(Integer.valueOf(scores[4]));
				
				scoreList.add(scoreVO);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("학생정보 파일 읽기 오류!!!");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("학생정보 파일 읽기 오류!!!");
		} 
	}

	@Override
	public void scoreSum() {
		// TODO Auto-generated method stub
		for (ScoreVO scoreVO : scoreList) {
			scoreVO.setSum(scoreVO.getKor()
					+scoreVO.getEng()
					+scoreVO.getMath()
					+scoreVO.getMusic());
		}
	}

	@Override
	public void scoreAvg() {
		// TODO Auto-generated method stub
		for (ScoreVO scoreVO : scoreList) {
			String strAvg = String.format("5.2f", (float)scoreVO.getSum() / 4);
			float floatAvg = Float.valueOf(strAvg);
			scoreVO.setAvg(floatAvg);
		}
	}

	@Override
	public void scoreList() {
		// TODO Auto-generated method stub
		System.out.println("===================================================");
		System.out.println("성적 리스트");
		System.out.println("===================================================");
		System.out.println("학번\t국어\t영어\t수학\t음악\t총점\t평균");
		System.out.println("---------------------------------------------------");
		int intKorSum = 0;
		int intEngSum = 0;
		int intMathSum = 0;
		int intMusicSum = 0;
		for (ScoreVO scoreVO : scoreList) {
			System.out.print(scoreVO.getNum()+"\t");
			System.out.print(scoreVO.getKor()+"\t");
			System.out.print(scoreVO.getEng()+"\t");
			System.out.print(scoreVO.getMath()+"\t");
			System.out.print(scoreVO.getMusic()+"\t");
			System.out.print(scoreVO.getSum()+"\t");
			System.out.print(scoreVO.getAvg()+"\n");
			
			intKorSum += scoreVO.getKor();
			intEngSum += scoreVO.getEng();
			intMathSum += scoreVO.getMath();
			intMusicSum += scoreVO.getMusic();
		}
		System.out.println("---------------------------------------------------");
		System.out.printf("총점:\t%d\t%d\t%d\t%d\t%d\t\t\n",
				intKorSum,
				intEngSum,
				intMathSum,
				intMusicSum,
				intKorSum+intEngSum+intMathSum+intMusicSum);
		System.out.printf("평균:\t%d\t%d\t%d\t%d\t\t%f\n",
				String.format("%5.2f", intKorSum/scoreList.size()),
				String.format("%5.2f", intEngSum/scoreList.size()),
				String.format("%5.2f", intMathSum/scoreList.size()),
				String.format("%5.2f", intMusicSum/scoreList.size()),
				String.format("%5.2f", intKorSum+intEngSum+intMathSum+intMusicSum/4));
	}
	
}
