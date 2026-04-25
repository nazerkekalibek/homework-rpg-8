package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class RestFloor extends TowerFloor{
    protected String getFloorName(){ 
        return "Rest Floor"; 
    }
    protected void setup(List<Hero> party){}
    protected FloorResult resolveChallenge(List<Hero> party){
        for(Hero h : party){
            h.heal(20);
        }
        return new FloorResult(true, 0, "Rested");
    }
    protected void awardLoot(List<Hero> party, FloorResult result){}
}
