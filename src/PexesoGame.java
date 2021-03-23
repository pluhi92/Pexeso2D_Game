import game.PametovyRamec;

import java.awt.*;

public class PexesoGame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PametovyRamec ramec = PametovyRamec.getInstanceOf();
        });
    }
}
