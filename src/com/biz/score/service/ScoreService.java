package com.biz.score.service;

import com.biz.score.domain.ScoreVO;

public interface ScoreService {
	
	public boolean inputScore();
	public void scoreSave(ScoreVO scoreVO);
	public void scoreLoard();
	public void scoreSum();
	public void scoreAvg();
	public void scoreList();
	public void scoreListSave();
}
