package menu;

import game.Komponenty;
import game.LevelPozadie;
import scores.VysokeScore;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuKomponenty extends JComponent {
    private JPanel mainPanel;

    private Image obrazokMK;
    private final String POZADIE_MENU_IMAGE = "/resources/images/Pozadie.jpg";
    private LevelPozadie levelPozadie;
    private VysokeScore vysokeScoreDialog;

    public MenuKomponenty() {
        setLayout(new BorderLayout());
        obrazokMK = new ImageIcon(getClass().getResource(POZADIE_MENU_IMAGE)).getImage();
        mainPanel = new JPanel(new GridLayout(5, 1, 12, 10));
        mainPanel.setBorder(new EmptyBorder(80, 300, 30, 300));


        addTitulok();
        addTlacidloStart();
        addTlacidloVysokeScore();
        addTlacidloVychod();

        add(mainPanel, BorderLayout.CENTER);

        mainPanel.setOpaque(false);
    }

    public void addTitulok() {
        MenuScitok gameName = new MenuScitok("Pexeso 2D", new Font("Arial", Font.BOLD | Font.ITALIC, 90), Color.orange);
        mainPanel.add(gameName);


        MenuScitok empty = new MenuScitok("", new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 40), Color.RED);
        mainPanel.add(empty);

    }

    public void addTlacidloStart() {
        MenuTlacidlo newGame = new MenuTlacidlo("Nová hra", new Color(138, 200, 114), 44, null);

        newGame.addActionListener(event -> {
            if (levelPozadie == null)
                levelPozadie = new LevelPozadie();

            levelPozadie.setLocationRelativeTo(null);
            levelPozadie.setVybrany(false);
            levelPozadie.setVisible(true);

            if (levelPozadie.isVybrany()) {
                remove(mainPanel);
                add(new Komponenty(levelPozadie.getLevel()));
                revalidate();
                repaint();
            }

        });

        mainPanel.add(newGame);
    }

    public void addTlacidloVysokeScore() {
        MenuTlacidlo vysokeScore = new MenuTlacidlo("Vysoké skóre", new Color(132, 197, 200), 44, null);

        vysokeScore.addActionListener(event -> {
            if (vysokeScoreDialog == null)
                vysokeScoreDialog = new VysokeScore("Vysoké skóre");

            vysokeScoreDialog.setLocationRelativeTo(null);
            vysokeScoreDialog.setVisible(true);
        });

        mainPanel.add(vysokeScore);
    }

    public void addTlacidloVychod() {
        MenuTlacidlo exit = new MenuTlacidlo("Odísť", new Color(200, 100, 100), 44, null);

        exit.addActionListener((event) -> System.exit(0));

        mainPanel.add(exit);
    }


    @Override
    protected void paintComponent(Graphics g) {
        if (obrazokMK == null)
            return;

        g.drawImage(obrazokMK, 0, 0, null);

    }

}
