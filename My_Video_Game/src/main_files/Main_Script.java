package main_files;

import java.util.Scanner;
import java.util.Random;

public class Main_Script 
{
	Stats player = new Stats("Player", 1, 10, 3, 3, 2, 2);
	Inventory player_inventory = new Inventory();
	Scanner keyboard = new Scanner(System.in);
	Random random_calculator = new Random();
	public void Timeout()
	{
		try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	public void Run_Intro()
	{
		System.out.println("Welcome to the world of fantasy and adventure");
		Timeout();
		System.out.println("Use the 'w', 'a', 's', 'd', and 'enter' keys to play");
		Timeout();
		System.out.println("You are an adventurer looking for the treasure of a nearby cave full of monsters");
		Timeout();
		System.out.println("Do whatever it takes to retrieve it");
		Timeout();
		System.out.println("For now let's go to Bell Town so you can prepare for you journey!");
		Timeout();
		System.out.println("Your stats are:\nLevel: " + player.level +"\nMax Hp: " + player.max_hp + "\nCurrent Hp: " + player.current_hp + "\nStrength: " + player.strength + "\nMagic: " + player.magic + "\nSpeed: " + player.speed + "\nDefense: " + player.defense + "\nExperience: " + player.experience);
		System.out.println("Potions: " + player_inventory.potion_bag);
		Timeout();
	}
	public void Run_Town() //Main hub for the player
	{
		while(true)
		{
			System.out.println("Welcome to Bell Town");
			Timeout();
			System.out.println("Enter 'w' to go to cave\nEnter 'a' to rest and mix some potions\nEnter 'd' to listen for rumors\nEnter 's' to quit game");
				char user_input = keyboard.next().toLowerCase().charAt(0);
				switch(user_input) {
					case 'w':
						Cave();
						Timeout();
						break;
					case 'a':
						Mix_Potions_and_Rest();
						Timeout();
						break;
					case 'd':
						Rumors();
						Timeout();
						break;
					case 's':
						Game_Over();
						break;
					default:
						System.out.println("Invalid input");
						Timeout();
				}
		}
	}
	public void Cave()
	{
		System.out.println("The cave is blocked off... no treasure for you");
		Timeout();
	}
	public void Mix_Potions_and_Rest()
	{
		player.Rest();
		Timeout();
		player_inventory.Mix_Potions();
		Timeout();
	}
	public void Rumors()
	{
		String[] possible_rumors = {"You didn't hear any rumors", "You hear goblins are vulnerable to swords or magic", "You hear orcs resist sword attacks, but are vulnerable to magic", "You hear slimes are resistant to magic, but are vulnerable to sword attacks", "You hear most people struggle to outspeed wolves", "Based on what you're hearing, the treasure in the cave will require a lot of searching"};
		System.out.println(possible_rumors[random_calculator.nextInt(6)]);
		Timeout();
		
	}
	public void Game_Over()
	{
		System.out.println("Game Over");
		System.exit(0);
	}
}
