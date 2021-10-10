package com.battle.medievalbattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatoonUtils{
    static Map<String, List<String>> unitAdv = new HashMap<>();
    static {
        unitAdv.put("Militia", List.of("Spearmen", "LightCavalry"));
        unitAdv.put("Spearmen", List.of("LightCavalry", "HeavyCavalry"));
        unitAdv.put("LightCavalry", List.of("FootArcher", "CavalryArcher"));
        unitAdv.put("HeavyCavalry", List.of("Militia", "FootArcher", "LightCavalry"));
        unitAdv.put("CavalryArcher", List.of("Spearmen", "HeavyCavalry"));
        unitAdv.put("FootArcher", List.of("Militia", "CavalryArcher"));
    }

    public static int compare(Platoon team1, Platoon team2){
        int capDelta = team1.getCap() - team2.getCap();
        if(unitAdv.get(team2.getClazz()).contains(team1.getClazz())){
            int oppoCap = team2.getCap()*2;
            capDelta = team1.getCap() - oppoCap;
        }
        else if(unitAdv.get(team1.getClazz()).contains(team2.getClazz())){
            int oppoCap = team2.getCap()/2;
            capDelta = team1.getCap() - oppoCap;
        }
        return capDelta;
    }

    public static List<String> parsePlatoons(String team){
        List<String> platoonList = new ArrayList<>(Arrays.asList(team.split(";")));
        return platoonList;
    }
}