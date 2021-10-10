package com.battle.medievalbattle;

import java.util.List;

public class MedievalBattleApplication {

    public static void main(String[] args) {
        String t1 = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
        String t2 = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";

        List<String> t1List = PlatoonUtils.parsePlatoons(t1);
        List<String> t2List = PlatoonUtils.parsePlatoons(t2);

        BattleShip battleShip = new BattleShip();
        System.out.println(battleShip.rearrangeTeamToWin(t1List, t2List));

    }

}
