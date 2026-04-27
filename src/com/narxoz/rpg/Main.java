package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.BattleFloor;
import com.narxoz.rpg.floor.RestFloor;
import com.narxoz.rpg.floor.TowerFloor;
import com.narxoz.rpg.floor.TrapFloor;
import com.narxoz.rpg.state.NormalState;
import com.narxoz.rpg.state.PoisonState;
import com.narxoz.rpg.tower.TowerRunResult;
import com.narxoz.rpg.tower.TowerRunner;
import java.util.Arrays;
import java.util.List;

public class Main { 
    public static void main(String[] args) {
        Hero h1=new Hero("Knight", 100, 15, 5);
        Hero h2= new Hero("Mage", 70, 20, 3);

        h1.setState(new NormalState());
        h2.setState(new PoisonState());

        List<Hero> party=Arrays.asList(h1, h2);
        List<TowerFloor> floors=Arrays.asList(
                new BattleFloor(),
                new TrapFloor(),
                new RestFloor(),
                new BattleFloor()
        );

        TowerRunner runner=new TowerRunner(floors);
        TowerRunResult result=runner.run(party);

        System.out.println("\n=====RESULT=====");
        System.out.println("Floors cleared: "+result.getFloorsCleared());
        System.out.println("Heroes alive: "+result.getHeroesSurviving());
        System.out.println("Reached top: "+result.isReachedTop());
    }
}
