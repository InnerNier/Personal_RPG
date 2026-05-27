package main_files;

import java.util.Scanner;
import java.util.Random;

public class Combat_Script 
{
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
	public void Encounter(Stats player, Inventory player_inventory)
	{
		int chosen_enemy = random_calculator.nextInt(8);
		Stats enemy;
		switch(chosen_enemy)
		{
			case 1:
				enemy = new Stats("Orc", 3, 14, 4, 1, 2, 12);
				break;
			case 2:
				enemy = new Stats("Slime", 2, 10, 3, 12, 1, 1);
				break;
			case 3:
				enemy = new Stats("Wolf", 4, 11, 5, 1, 15, 2);
				break;
			default:
				enemy = new Stats("Goblin", 1, 7, 2, 1, 1, 1);
				break;
		}
		System.out.println(enemy.name + " appears");
		Timeout();
		while(true) //loop for the battle
		{
			if(player.speed >= enemy.speed)
			{
				Player_Turn(player, enemy, player_inventory);
				if(enemy.current_hp == 0)
				{
					System.out.println(enemy.name + " has been defeated");
					Timeout();
					break;
				}
				Enemy_Turn(player, enemy);
				if(player.current_hp == 0)
				{
					System.out.println(player.name + " has been defeated");
					Timeout();
					break;
				}
			}
			else
			{
				Enemy_Turn(player, enemy);
				if(player.current_hp == 0)
				{
					System.out.println(player.name + " has been defeated");
					Timeout();
					break;
				}
				Player_Turn(player, enemy, player_inventory);
				if(enemy.current_hp == 0)
				{
					System.out.println(enemy.name + " has been defeated");
					Timeout();
					break;
				}
			}
		}
		if(enemy.current_hp == 0)
		{
			int experience = enemy.level * 3;
			player.Increase_Experience(experience);
			Timeout();
			boolean can_level_up = true;
			while(can_level_up)
			{
				can_level_up = player.Can_Level_up();
				if(can_level_up)
				{
					player.Level_up();
					Timeout();
				}
			}
		}
		else
		{
			Main_Script game_over_caller = new Main_Script();
			game_over_caller.Game_Over();
		}
	}
	public void Boss_Fight(Stats player, Inventory player_inventory)
	{
		Stats bear = new Stats("Bear", 10, 70, 21, 1, 17, 17);
		//loop between the player and enemy turns
		//give player experience
		//check for level up
		//level up if true
	}
	public void Player_Turn(Stats player, Stats enemy, Inventory player_inventory)
	{
		System.out.println(player.name + "'s turn");
		Timeout();
		System.out.println("Enter 'w' to use your Sword\nEnter 'a' to use your Magic\nEnter 'd' to drink a Potion");
		Timeout();
		char user_input = keyboard.next().toLowerCase().charAt(0);
		outerloop: while(true)
		{
			switch(user_input) 
			{
				case 'w':
					int attack_damage = player.Calculate_Attack(false);
					System.out.println("You slashed at " + enemy.name + " with your sword");
					Timeout();
					enemy.Take_Damage(attack_damage, false);
					Timeout();
					break outerloop;
				case 'a':
					int magic_damage = player.Calculate_Attack(true);
					System.out.println("You conjured a bolt of fire at " + enemy.name);
					Timeout();
					enemy.Take_Damage(magic_damage, true);
					Timeout();
					break outerloop;
				case 'd':
					boolean potion_use_success = player_inventory.Use_Potion();
					Timeout();
					if(potion_use_success)
					{
						player.Heal_Damage(20);
						Timeout();
						break outerloop;
					}
					break;
				default:
					System.out.println("Invalid input");
					Timeout();
					break;
			}
		}
		
	}
	public void Enemy_Turn(Stats player, Stats enemy)
	{
		System.out.println(enemy.name + "'s turn");
		Timeout();
		System.out.println(enemy.name + " attacks");
		Timeout();
		int attack_damage = enemy.Calculate_Attack(false);
		player.Take_Damage(attack_damage, false);
		Timeout();
		System.out.println(player.name + " is now at " + player.current_hp + " hp");
		Timeout();
	}
}
