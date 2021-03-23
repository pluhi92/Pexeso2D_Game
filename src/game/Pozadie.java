package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class Pozadie extends JDialog {
    private Image obrazokP;
    private static final String DIALOG_POZADIE = "/resources/images/Dialog.jpg";
    private JPanel panel;

    public Pozadie(String title) {
        setTitle(title);
        setResizable(false);
        setModal(true);

        obrazokP = new ImageIcon(getClass().getResource(DIALOG_POZADIE)).getImage();

        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                if (obrazokP == null)
                    return;

                g.drawImage(obrazokP, 0, 0, null);
            }
        };

        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        add(panel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 400);
    }
}
