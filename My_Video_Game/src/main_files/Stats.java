package main_files;
import java.util.Random;

public class Stats 
{
	String name;
	int level; //Indicator of how strong the player or enemy is
	int max_hp; //"Hit Points". current_hp is not allowed to exceed this number
	int current_hp; //The number that will lower when taking damage and rise when being healed, not allowed to be below 0. Player or enemy will be defeated once it reaches 0
	int strength; //Will determine power of physical attacks
	int magic; //Will determine power and resistance of magic attacks
	int speed; //Will determine who goes first
	int defense; //Will determine resistance of physical attacks
	int experience; //Will determine if player can level up
	Random random_calculator = new Random();
	
	public Stats(String entered_name, int entered_level, int entered_hp, int entered_strength, int entered_magic, int entered_speed, int entered_defense) //Constructor to set stats for player or enemy
	{
		name = entered_name;
		level = entered_level;
		max_hp = entered_hp;
		current_hp = entered_hp;
		strength = entered_strength;
		magic = entered_magic;
		speed = entered_speed;
		defense = entered_defense;
		experience = 0;
	}
	public int Calculate_Attack(boolean is_magic)
	{
		int damage;
		if(is_magic)
		{
			damage = random_calculator.nextInt(3) + magic;
		}
		else 
		{
			damage = random_calculator.nextInt(3) + strength;
		}
		return damage;
	}
	public void Take_Damage(int damage, boolean is_magic) //lower current_hp
	{
		if(is_magic)
		{
			damage = damage - magic;
		}
		else
		{
			damage = damage - defense;
		}
		if(damage <= 0)
		{
			damage = 1;
		}
		current_hp = current_hp - damage;
		if(current_hp < 0) //Prevents current_hp from being below 0
		{
			current_hp = 0;
		}
		System.out.println(name + " took " + damage + " damage");
	}
	public void Heal_Damage(int heal) //raises current_hp
	{
		current_hp = current_hp + heal;
		if(current_hp > max_hp) //Prevents current_hp from exceeding max_hp
		{
			current_hp = max_hp;
		}
		System.out.println(name + " received heal of " + heal + " now at " + current_hp + " hp");
	}
	public void Increase_Experience(int gained_experience)
	{
		experience = experience + gained_experience;
		System.out.println("Gained " + gained_experience + " experience points");
	}
	public boolean Can_Level_up()
	{
		int[] milestones = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		if(experience >= milestones[level - 1])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void Rest()
	{
		if(max_hp == current_hp)
		{
			System.out.println("You are feeling fine, so decided not to rest right now");
		}
		if(current_hp < max_hp)
		{
			System.out.println("You took a nice long rest and now your Current hp is now at max");
			current_hp = max_hp;
		}
	}
	public void Level_up()
	{
		level = level + 1;
		max_hp = max_hp + random_calculator.nextInt(5) + 1;
		current_hp = max_hp;
		strength = strength + random_calculator.nextInt(3) + 1;
		magic = magic + random_calculator.nextInt(3) + 1;
		speed = speed + random_calculator.nextInt(3) + 1;
		defense = defense + random_calculator.nextInt(3) + 1;
		System.out.println("You leveled up");
		System.out.println("Your level is now " + level);
		System.out.println("Strength has increased to " + strength);
		System.out.println("Magic has increased to " + magic);
		System.out.println("Speed has increased to " + speed);
		System.out.println("Defense has increased to " + defense);
	}
}
