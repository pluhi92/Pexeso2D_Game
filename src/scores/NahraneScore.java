package scores;

import game.Level;

import java.io.Serializable;

public class NahraneScore implements Comparable<NahraneScore>, Serializable {
    private String pouzivatel;
    private Level level;
    private String cas;
    private int pokusy;
    private int body;

    public NahraneScore(String pouzivatel, Level level, String cas, int pokusy, int body) {
        this.pouzivatel = pouzivatel;
        this.level = level;
        this.cas = cas;
        this.pokusy = pokusy;
        this.body = body;
    }

    public String getPouzivatel() {
        return pouzivatel;
    }

    public Level getLevel() {
        return level;
    }

    public String getCas() {
        return cas;
    }

    public int getPokusy() {
        return pokusy;
    }

    public int getBody() {
        return body;
    }

    @Override
    public int compareTo(NahraneScore score) {   //interface Comparable
        return score.getBody() - this.getBody();
    }
}
