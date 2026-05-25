package main_files;

public class Stats {
	int level; //Indicator of how strong the player or enemy is
	int max_hp; //"Hit Points". current_hp is not allowed to exceed this number
	int current_hp; //The number that will lower when taking damage and rise when being healed, not allowed to be below 0. Player or enemy will be defeated once it reaches 0
	int strength; //Will determine power of physical attacks
	int magic; //Will determine power and resistance of magic attacks
	int speed; //Will determine who goes first
	int defense; //Will determine resistance of physical attacks
	int experience; //Will determine if player can level up
	
	public Stats(int entered_level, int entered_hp, int entered_strength, int entered_magic, int entered_speed, int entered_defense) //Constructor to set stats for player or enemy
	{
		level = entered_level;
		max_hp = entered_hp;
		current_hp = entered_hp;
		strength = entered_strength;
		magic = entered_magic;
		speed = entered_speed;
		defense = entered_defense;
		experience = 0;
	}
	public void Take_Damage(int damage) //lower current_hp
	{
		current_hp = current_hp - damage;
		if(current_hp < 0) //Prevents current_hp from being below 0
		{
			current_hp = 0;
		}
	}
	public void Heal_Damage(int heal) //raises current_hp
	{
		current_hp = current_hp + heal;
		if(current_hp > max_hp) //Prevents current_hp from exceeding max_hp
		{
			current_hp = max_hp;
		}
	}
	public void Increase_Experience(int gained_experience)
	{
		experience = experience + gained_experience;
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
	public void Level_up()
	{
		level = level + 1;
		//add logic to increase other stats
	}
}
