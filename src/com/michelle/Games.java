package com.michelle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Games {
	private List<Game> games = new ArrayList<Game>();
	
	public Games(List<Game> games) {
		super();
		this.games = games;
	}

	public List<Game> getGames() {
		return games;
	}

	public void showSummary(List<Game> games) {
		Collections.sort(games);
		
		for (Game game : games) {
			System.out.println(game.getHomeTeam() + " " + game.getHomeScore() + " - " + game.getAwayScore() + " " + game.getAwayTeam());
		}
		
		System.out.println();
	}
}
