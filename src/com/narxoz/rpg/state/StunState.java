package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class StunState implements HeroState{
    private int turns=1;
    public String getName(){ 
        return "Stunned"; 
    }
    public int modifyOutgoingDamage(int base){ 
        return 0; 
    }

    public int modifyIncomingDamage(int dmg){ 
        return dmg; 
    }

    public void onTurnStart(Hero hero){
        System.out.println(hero.getName()+" is stunned!");
    }

    public void onTurnEnd(Hero hero){
        turns--;
        if(turns <= 0){
            hero.setState(new NormalState());
        }
    }

    public boolean canAct() { 
        return false; 
    }
}
