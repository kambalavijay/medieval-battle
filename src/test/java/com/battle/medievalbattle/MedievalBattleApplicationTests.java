package com.battle.medievalbattle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class MedievalBattleApplicationTests {

    @Test
    void testBattleWin() {
        String t1 = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
        String t2 = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";

        List<String> t1List = PlatoonUtils.parsePlatoons(t1);
        List<String> t2List = PlatoonUtils.parsePlatoons(t2);

        BattleShip battleShip = new BattleShip();
        String expected = "FootArcher#20;Spearmen#10;LightCavalry#1000;HeavyCavalry#120;Militia#30";
        Assert.hasText(expected, battleShip.rearrangeTeamToWin(t1List, t2List));
    }

    @Test
    void testBattleLoss() {

        Map<String, List<String>> unitAdv = new HashMap<>();

        unitAdv.put("Militia", List.of("Spearmen", "LightCavalry"));
        unitAdv.put("Spearmen", List.of("LightCavalry", "HeavyCavalry"));
        unitAdv.put("LightCavalry", List.of("FootArcher", "CavalryArcher"));
        unitAdv.put("HeavyCavalry", List.of("Militia", "FootArcher", "LightCavalry"));
        unitAdv.put("CavalryArcher", List.of("Spearmen", "HeavyCavalry"));
        unitAdv.put("FootArcher", List.of("Militia", "CavalryArcher"));

        String t1 = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
        String t2 = "Militia#600;Spearmen#300;FootArcher#5000;LightCavalry#2000;CavalryArcher#500";

        List<String> t1List = PlatoonUtils.parsePlatoons(t1);
        List<String> t2List = PlatoonUtils.parsePlatoons(t2);

        BattleShip battleShip = new BattleShip();
        String expected = "There is no chance of winning";
        Assert.hasText(expected, battleShip.rearrangeTeamToWin(t1List, t2List));
    }

}
