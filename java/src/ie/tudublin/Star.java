package ie.tudublin;

public class Star {
    private boolean hab;
    private String displayName;
    private float xG;
    private float yG;
    private float zG;
    private float absMag;
    private float distance;

    public Star(boolean hab, String displayName, float xG, float yG, float zG, float absMag, float distance) {
        this.hab = hab;
        this.displayName = displayName;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
        this.distance = distance;
    }

    public boolean isHab() {
        return hab;
    }

    public String getDisplayName() {
        return displayName;
    }

    public float getxG() {
        return xG;
    }

    public float getyG() {
        return yG;
    }

    public float getzG() {
        return zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    public float getDistance() {
        return distance;
    }

}