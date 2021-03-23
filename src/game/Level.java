package game;

public enum Level {
    Ľahká(16), // 4x4
    Stredná(36), // 6x6
    Ťažká(64), // 8x8
    Expert(100); // 10x10

    private final int kolkoKariet;

    Level(int kolkoKariet) {
        this.kolkoKariet = kolkoKariet;
    }

    public int getKolkoKariet() {
        return kolkoKariet;
    }
}
