package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.state.PoisonState;
import java.util.List;

public class TrapFloor extends TowerFloor{
    protected String getFloorName(){ 
        return "Poison Trap"; 
    }
    protected void setup(List<Hero> party){}
    protected FloorResult resolveChallenge(List<Hero> party){
        for (Hero h : party){
            h.setState(new PoisonState());
        }
        return new FloorResult(true, 5, "Poison applied");
    }
    protected void awardLoot(List<Hero> party, FloorResult result){}
    protected boolean shouldAwardLoot(FloorResult r){
        return false;
    }
}
