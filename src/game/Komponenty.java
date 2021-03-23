package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Komponenty extends JComponent {
    private PanelKariet panelKariet;
    private PouzivatelskyPanel pouzivatelskyPanel;
    private static Level level;

    public Komponenty(Level level) {
        setLayout(new BorderLayout());
        Komponenty.level = level;
        panelKariet = new PanelKariet(level);
        pouzivatelskyPanel = new PouzivatelskyPanel(panelKariet.getKarty());

        add(panelKariet, BorderLayout.CENTER);
        panelKariet.setOpaque(false);

        add(pouzivatelskyPanel, BorderLayout.SOUTH);

        HernyEngine hernyEngine = new HernyEngine(pouzivatelskyPanel);
        hernyEngine.start();
        ninjaMode();
    }

    public void ninjaMode() {
        Action ninjaAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (Karta c : panelKariet.getKarty())
                    c.setNinjaMode();
            }
        };

        panelKariet.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ctrl alt N"), "ninja");
        panelKariet.getActionMap().put("ninja", ninjaAction);
    }

    public static Level getLevel() {
        return level;
    }
}
