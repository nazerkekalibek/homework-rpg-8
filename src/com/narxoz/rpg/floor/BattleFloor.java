package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.state.StunState;
import java.util.*;

public class BattleFloor extends TowerFloor{
    private Monster monster;
    protected String getFloorName(){ 
        return "Battle Floor"; 
    }
    protected void setup(List<Hero> party){
        monster=new Monster("Orc", 40, 10);
    }
    protected FloorResult resolveChallenge(List<Hero> party){
        int damage=0;
        while(monster.isAlive() && party.stream().anyMatch(Hero::isAlive)) {
            for(Hero h : party){
                if(!h.isAlive()) continue;
                h.onTurnStart();
                if(h.canAct()){
                    int dmg=h.dealDamage();
                    monster.takeDamage(dmg);
                    System.out.println(h.getName()+" hits for "+dmg);
                }
                h.onTurnEnd();
            }
            if(monster.isAlive()){
                Hero target=party.get(0);
                monster.attack(target);
                target.setState(new StunState());
                damage+=5;
            }
        }
        return new FloorResult(!monster.isAlive(), damage, "Battle finished");
    }
    protected void awardLoot(List<Hero> party, FloorResult result) {
        for(Hero h : party) h.heal(10);
    }
}
