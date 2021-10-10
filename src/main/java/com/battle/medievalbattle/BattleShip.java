package com.battle.medievalbattle;

import java.util.ArrayList;
import java.util.List;

class BattleShip{

    public String rearrangeTeamToWin(List<String> team1, List<String> team2){
        int winCount = 0;
        StringBuilder teamArrange = new StringBuilder();
        for (int i = 0; i < team2.size(); i++) {
            String t2Type = team2.get(i).split("#")[0];
            Integer t2Cap = Integer.parseInt(team2.get(i).split("#")[1]);
            Platoon oppoPlatoon = new Platoon(t2Cap, t2Type);
            List<Integer> capDeltas = new ArrayList<>();
            for (int j = 0; j < team1.size(); j++) {
                String t1Type = team1.get(j).split("#")[0];
                Integer t1Cap = Integer.parseInt(team1.get(j).split("#")[1]);
                Platoon myPlatoon = new Platoon(t1Cap, t1Type);
                capDeltas.add(PlatoonUtils.compare(myPlatoon, oppoPlatoon));
            }
            int minCapDiff = Integer.MAX_VALUE;
            int maxCapDiff = Integer.MAX_VALUE;
            for (int capDelta : capDeltas) {
                if(capDelta >= 0 && capDelta < minCapDiff){
                    minCapDiff = capDelta;
                    winCount++;
                }
                else if(capDelta < 0 && capDelta < maxCapDiff){
                    maxCapDiff = capDelta;
                }
            }
            int platoonIndex = minCapDiff != Integer.MAX_VALUE ? capDeltas.indexOf(minCapDiff) : capDeltas.indexOf(maxCapDiff);
            teamArrange.append(team1.get(platoonIndex)).append(";");
            team1.remove(platoonIndex);
        }
        return winCount >= 3 ? teamArrange.substring(0, teamArrange.length()-1) : "There is no chance of winning";
    }
}