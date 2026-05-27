package main_files;

import java.util.Scanner;
import java.util.Random;

public class Main_Script 
{
	Stats player = new Stats("Player", 1, 10, 3, 3, 2, 3);
	Inventory player_inventory = new Inventory();
	Combat_Script battle = new Combat_Script();
	Scanner keyboard = new Scanner(System.in);
	Random random_calculator = new Random();
	int total_searches = 0;
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
			System.out.println("Bell Town is so lively");
			Timeout();
			System.out.println("Enter 'w' to go to cave\nEnter 'a' to rest and mix some potions\nEnter 'd' to listen for rumors\nEnter 's' to quit game");
				char user_input = keyboard.next().toLowerCase().charAt(0);
				switch(user_input) 
				{
					case 'w':
						System.out.println("You decided to head to the cave");
						Timeout();
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
		while(true)
		{
			System.out.println("The cave is so deep and vast");
			Timeout();
			System.out.println("Enter 'w' to search the cave\nEnter 'a' to go back to Bell Town\nEnter 'd' to check your stats\nEnter 's' to ponder your progress");
			char user_input = keyboard.next().toLowerCase().charAt(0);
			switch(user_input) 
			{
				case 'w':
					if(total_searches != 30)
					{
						int chosen_event = random_calculator.nextInt(10);
						if(chosen_event <= 7)
						{
							battle.Encounter(player, player_inventory);
						}
						else if(chosen_event == 8)
						{
							System.out.println("While searching, you found a potion!");
							Timeout();
							player_inventory.Gain_Potion();
						}
						else
						{
							System.out.println("No signs of anything noteworthy yet");
						}
					}
					else
					{
						System.out.println("Time to fight the bear!");
					}
					Timeout();
					if(total_searches != 30)
					{
						total_searches++;
					}
					break;
				case 'a':
					System.out.println("You decided to head back to Bell Town");
					Timeout();
					return;
				case 'd':
					System.out.println("Your stats are:\nLevel: " + player.level +"\nMax Hp: " + player.max_hp + "\nCurrent Hp: " + player.current_hp + "\nStrength: " + player.strength + "\nMagic: " + player.magic + "\nSpeed: " + player.speed + "\nDefense: " + player.defense + "\nExperience: " + player.experience);
					System.out.println("Potions: " + player_inventory.potion_bag);
					Timeout();
					break;
				case 's':
					if(total_searches < 10)
					{
						System.out.println("You do not have a good feel for the cave layouot, you should definitely search around more");
					}
					else if(total_searches < 20)
					{
						System.out.println("You feel like you've searched a good amount of the cave, but you still have more to search");
					}
					else if(total_searches < 30)
					{
						System.out.println("You feel like you're getting close to finding the treasure, just got to search a bit more");
					}
					else
					{
						System.out.println("You know where the treasure is, search and go get it");
					}
					Timeout();
					break;
				default:
					System.out.println("Invalid input");
					Timeout();
			}
		}
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
