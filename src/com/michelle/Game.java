package com.michelle;

public class Game implements Comparable<Game> {
	
	private String homeTeam;
	private int homeScore;
	private String awayTeam;
	private int awayScore;
	private int totalScore;
	
	public Game() {
		
	}
	
	public Game(String homeTeam, int homeScore, String awayTeam, int awayScore, int totalScore) {
		super();
		this.homeTeam = homeTeam;
		this.homeScore = homeScore;
		this.awayTeam = awayTeam;
		this.awayScore = awayScore;
	}

	public Game(String homeTeam, String awayTeam) {
		this(homeTeam, 0, awayTeam, 0, 0);
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public Game getGameUpdate() {
		int random = (int) Math.floor(Math.random() * 3); 
		this.homeScore += random;
		random = (int) Math.floor(Math.random() * 3);
		this.awayScore += random;
		this.totalScore = homeScore + awayScore;
		return new Game(homeTeam, homeScore, awayTeam, awayScore, totalScore);
	}

	@Override
	public int compareTo(Game o) {
		
		return o.totalScore - this.totalScore;
	}

}
