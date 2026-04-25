package com.narxoz.rpg.combatant;

import com.narxoz.rpg.state.HeroState;

public class Hero {

    private final String name;
    private int hp;
    private final int maxHp;
    private final int attackPower;
    private final int defense;

    private HeroState state;

    public Hero(String name, int hp, int attackPower, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public String getName()        { return name; }
    public int getHp()             { return hp; }
    public int getMaxHp()          { return maxHp; }
    public int getAttackPower()    { return attackPower; }
    public int getDefense()        { return defense; }
    public boolean isAlive()       { return hp > 0; }

    public void setState(HeroState state){
        System.out.println(name+" -> STATE: "+state.getName());
        this.state=state;
    }

    public int dealDamage(){
        return state.modifyOutgoingDamage(attackPower);
    }

    public void receiveDamage(int dmg) {
        int finalDmg=state.modifyIncomingDamage(dmg);
        takeDamage(finalDmg);
    }

    public void takeDamage(int amount) {
        hp = Math.max(0, hp - amount);
        System.out.println(name+" takes "+amount+" damage (HP="+hp+ ")");
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
        System.out.println(name+" heals "+amount+" (HP="+hp+")");
    }

    public void onTurnStart(){
         state.onTurnStart(this);}
    public void onTurnEnd() { 
        state.onTurnEnd(this);}
    public boolean canAct(){ 
        return state.canAct();}
}
