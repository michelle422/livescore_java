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
			while (!end) {
				System.out.print("Choices: 1 - Start Game; 2 - Update Game; 3 - Summary of Games\t");
				choice = in.nextInt();
				
				switch (choice) {
					case 1: 
						game = startGame(gamelist);
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
					default:
						end = true;
	//					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Not a number");
		}
		
//		for (String homeCountry : homeCountries) {
//			Country country = new Country(homeCountry, true);
//			countries.add(country);
//		}
//		
//		for (String awayCountry : awayCountries) {
//			Country country = new Country(awayCountry, true);
//			countries.add(country);
//		}
		
	}

	private static void summaryGames(List<Game> gamelist) {
		Games games;
		games = new Games(gamelist);
			
		System.out.println();
		System.out.println("Summary of games:");
		games.showSummary(gamelist);
	}
	
	private static void updateGame(Game game, Scanner in) {
		
//		for (Game game : gamelist) {
			System.out.print("Game update: " + game.getHomeTeam() + " " + game.getHomeScore() + " - " + 
					game.getAwayTeam() + " " + game.getAwayScore() + "\tPress 'x' to end the game");
			String key = in.nextLine();
			while (!key.equals("x")) {
				game.getGameUpdate();
				System.out.print("Game update: " + game.getHomeTeam() + " " + game.getHomeScore() + " - " + 
						game.getAwayTeam() + " " + game.getAwayScore() + "\tPress 'x' to end the game");
				key = in.nextLine();
			}
//		}
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