package com.narxoz.rpg.tower;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.FloorResult;
import com.narxoz.rpg.floor.TowerFloor;
import java.util.List;

public class TowerRunner {
    private List<TowerFloor> floors;
    public TowerRunner(List<TowerFloor> floors){
        this.floors=floors;
    }
    public TowerRunResult run(List<Hero> party){
        int cleared=0;
        for(TowerFloor f : floors){
            FloorResult r=f.explore(party);
            if(!r.isCleared()) break;
            cleared++;
        }
 
        int alive =(int) party.stream().filter(Hero::isAlive).count();
        return new TowerRunResult(cleared, alive, cleared == floors.size());
    }

}
