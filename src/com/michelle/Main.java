package com.michelle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String[] homeCountries = {
			"Mexico", 
			"Spain", 
			"Germany", 
			"Uruguay", 
			"Argentina", 
			"Belgium"
		};
		
		String[] awayCountries = {
			"Canada", 
			"Brazil", 
			"France",
			"Italy",
			"Australia", 
			"Norway"
		};
		
//		List<Country> countries = new ArrayList<Country>();
		List<Game> gamelist = new ArrayList<Game>();
		Game game = new Game();
		Games games = new Games(gamelist);

		for (int i = 0; i < homeCountries.length && i < awayCountries.length; i++) {

			game = new Game(homeCountries[i], awayCountries[i]);
			gamelist.add(game);
		}

		game = new Game();
		Scanner in = new Scanner(System.in);
		int choice = 0;
		boolean end = false;
		
		try {
			while (choice != 4 || !end) {
				System.out.print("Choices: 1 - Start Game; 2 - Update Game; 3 - Summary of Games; 4 - Exit\t");
				choice = in.nextInt();
				
				switch (choice) {
					case 1: 
						game = startGame(gamelist);
						System.out.println();
						break;
					case 2:
						in = new Scanner(System.in);
						if (game.getHomeTeam() != null || game.getAwayTeam() != null) {
							updateGame(game, in);
						}
						game = new Game();
						break;
					case 3:
						summaryGames(gamelist);
						break;
					case 4:
						end = true;
				}
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Not a number");
		}
		
	}

	private static void summaryGames(List<Game> gamelist) {
		Games games;
		games = new Games(gamelist);
			
		System.out.println();
		System.out.println("Summary of games:");
		games.showSummary(gamelist);
	}
	
	private static void updateGame(Game game, Scanner in) {
		System.out.println();
		System.out.print("Game update: " + game.getHomeTeam() + " " + game.getHomeScore() + " - " + 
				game.getAwayTeam() + " " + game.getAwayScore() + "\tPress 'x' to end the game: ");
		String key = in.nextLine();
		
		while (!key.equals("x")) {
			game.getGameUpdate();
			System.out.print("Game update: " + game.getHomeTeam() + " " + game.getHomeScore() + " - " + 
					game.getAwayTeam() + " " + game.getAwayScore() + "\tPress 'x' to end the game: ");
			key = in.nextLine();
			if (key.equals(game.getHomeTeam())) {
				System.out.println("Team: " + game.getHomeTeam() + "\tScore: " + game.getHomeScore());
			}
			if (key.equals(game.getAwayTeam())) {
				System.out.println("Team: " + game.getAwayTeam() + "\tScore: " + game.getAwayScore());
			}
		}
		
		System.out.println();
	}

	private static Game startGame(List<Game> gamelist) {
		Game currentGame = new Game();
	
		for (Game game : gamelist) {
			
			if (game.getHomeScore() > 0 || game.getAwayScore() > 0) {
				continue;
			}
			
			System.out.println();
			System.out.println("Game start: " + game.getHomeTeam() + " " + game.getHomeScore() + " - " + 
					game.getAwayTeam() + " " + game.getAwayScore());
			return game;
		}
		
		return currentGame;
	}


}
