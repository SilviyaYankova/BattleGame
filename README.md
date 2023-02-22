# Simple game about battles between individual characters and armies.
Characters have different healt and attack points and special abilities like defense, vampirism, attack in a specific way, healing and rearrangint the army.
Every turn, the first warrior will hit the second and this second will lose his health in the same value as the attack of the first warrior. After that, if he is still alive, the second warrior will do the same to the first one.

Characters in the game: 
  - Warrior - health: 50 points, attack: 5 points
  - Knight - health: 50 points, attack: 7 points
  - Defender - health: 40 points, attack: 4 points, defence: 50%
Defender have an additional defense parameter, which helps him to survive longer. When another unit hits the defender, he loses a certain amount of his health according to the next formula: enemy attack - self defense (if enemy attack > self defense). Otherwise, the defender doesn't lose his health. 
  - Vampire - health: 60 points, attack: 3 points, vampirism: 2 points
Vampire have the additional vampirism parameter, which helps him to heal himself. When the Vampire hits the other unit, he restores his health by +50% of the dealt damage (enemy defense makes the dealt damage value lower).
- Lancer - health: 50 points, attack: 6 points, additional damage: 50%
Lancer should attack in a specific way - when he hits the other unit, he also deals a 50% of the deal damage to the enemy unit, standing behind the firstly assaulted one (enemy defense makes the deal damage value lower - consider this).
- Healer - health: 60 points, heal power: 2 points
- Healer won't be fighting (his attack = 0, so he can't deal the damage). But his role is also very important - every time the allied soldier hits the enemy, the Healer will heal the ally, standing right in front of him by +2 health points. Note that the health after healing can't be greater than the maximum health of the unit. For example, if the Healer heals the Warrior with 49 health points, the Warrior will have 50 healt points, because this is the maximum for him.
- Warlord - health: 100 points, attack: 4 points, defence: 2 points
Warlord has the special abilities of the Defender.
Also, when the Warlord is included in any of the armies, that particular army gets the new moveUnits() method which allows to rearrange the units of that army for the better battle result. The rearrangement is done not only before the battle, but during the battle too, each time the allied units die. 
The rules for the rearrangement are as follow:
  - If there are Lancers in the army, they should be placed in front of everyone else.
  - If there is a Healer in the army, he should be placed right after the first soldier to heal him during the fight. If the number of Healers is > 1, all of     them should be placed right behind the first Healer.
  - If there are no more Lancers in the army, but there are other soldiers who can deal damage, they also should be placed in first position, and the Healer       should stay in the 2nd row (if army still has Healers).
Warlord should always stay way in the back to look over the battle and rearrange the soldiers when it's needed.
Every army can have no more than 1 Warlord.
If the army doesn’t have a Warlord, it can’t use the moveUnits() method. (it should do nothing in such case)
- Wizard - health: 10 points, attack: 0 points, resurection powers reserved for Warlord: 1
One Wizard is allowed per army and he always stay behind the Warlord to keep his back safe. 
Wizard has the ability to resurrect warriors N times but when his health reach 1, he reserve this powers for the Warlord.
Wizard can fight if he is equipped only with Magic wand weapon. If he is, the heal power of the Magic wand adds to the resurrection powers(health) of the Wizard.

Characters can be equipped with weapons.
Every weapon's object have the parameters that will show how the soldier's characteristics change while he uses this weapon.  If the soldier doesn't have some of the characteristics (for example, defense or vampirism), but the weapon have those, these parameters don't need to be added to the soldier.
The parameters list:
  - health - add to the current health and the maximum health of the soldier this modificator;
  - attack - add to the soldier's attack this modificator;
  - defense - add to the soldier's defense this modificator;
  - vampirism - increase the soldier’s vampirism to this number (in %. So vampirism = 20 means +20%);
  - heal power - increase the amount of health which the healer restore for the allied unit.
All parameters could be positive or negative, so when a negative modificator is being added to the soldier’s stats, they are decreasing, but none of them can be less than 0.
Here is an example: vampire (basic parameters: health = 40, attack = 4, vampirism = 50%) equip the Weapon(20, 5, 2, -60, -1). The vampire has the health and the attack, so they will change - health will grow up to 60 (40 + 20), attack will be 9 (4 + 5). The vampire doesn’t have defense or the healPower, so these weapon modificators will be ignored. The weapon's vampirism modificator -60% will work as well. The standard vampirism value is only 50%, so we’ll get -10%. But, as we said before, the parameters can’t be less than 0, so the vampirism after all manipulations will be just 0%.
Weapons list:
  - Sword - health +5, attack +2
  - Shield - health +20, attack -1, defense +2
  - GreatAxe - health -15, attack +5, defense -2, vampirism +10%
  - Katana - health -20, attack +6, defense -5, vampirism +50%
  - MagicWand - health +30, attack +3, healPower +3
While healing (both vampirism and health restored by the healer), the health can’t be greater than the maximum amount of health for this unit (with consideration of all of the weapon's modificators).
If the heal from vampirism is float (for example 3.6, 1.1, 2.945), it is rownded down. So 3.6 = 3, 1.1 = 1, 2.945 = 2.
Every soldier can be equipped with any number of weapons and get all their bonuses, but if he wears too much weapons with the negative health modificator and his health is lower or equal 0 - he is as good as dead, which is actually pretty dead in this case.

Armies consist of different type of warriors.
The battles occur according to the following principles: 
  - a duel between the first warrior of the first army and the first warrior of the second army. As soon as one of them dies - the next warrior from the army that lost the fighter enters the duel, and the surviving warrior continues to fight with his current health. This continues until all the soldiers of one of the armies die
  - straight fight - at the beginning there will be a few duels between each pair of soldiers from both armies (the first unit against the first, the second against the second and so on).
After that all dead soldiers will be removed and the process repeats until all soldiers of one of the armies will be dead.
Armies might not have the same number of soldiers. If a warrior doesn’t have an opponent from the enemy army - we’ll automatically assume that he’s won a duel (for example - 9th and 10th units from the first army, if the second has only 8 soldiers).
It's very important to note that the special abilities of the Lancer and Healer do not work in a straight fight - nobody is standing in front of or behind any of their allies, so there's nobody for the Lancer to deal extra damage to or the Healer to heal.
