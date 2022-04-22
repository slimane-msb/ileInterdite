package Controller;

public class MapManager {



    public void endRound() {
        int[][] zonesNb = island.submerge3NotSubmergedZones();
        this.viewIsland.submerge3ViewZones(
                this.viewIsland.getViewZones(zonesNb[0][0], zonesNb[0][1]),
                this.viewIsland.getViewZones(zonesNb[1][0], zonesNb[1][1]),
                this.viewIsland.getViewZones(zonesNb[2][0], zonesNb[2][1]));
    }

    public void actionMade() {
        if (currRound == 2) {
            playerIndex = (playerIndex + 1) % 4;
            this.endRound();
        }
        currRound = (currRound + 1) % 3;

    }
}
