package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class BerserkState implements HeroState{
    public String getName(){ 
        return "Berserk"; 
    }

    public int modifyOutgoingDamage(int base){
        return (int)(base * 1.5);
    }

    public int modifyIncomingDamage(int dmg){
        return (int)(dmg * 1.3);
    }

    public void onTurnStart(Hero hero){}

    public void onTurnEnd(Hero hero){
        if (hero.getHp() > hero.getMaxHp()/2){
            hero.setState(new NormalState());
        }
    }

    public boolean canAct(){ 
        return true; 
    }

}
