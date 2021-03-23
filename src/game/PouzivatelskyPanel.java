package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PouzivatelskyPanel extends JPanel {
    private JLabel pokusyStitok;
    private JLabel casStitok;
    private JButton pauzaTlacidlo;
    private JButton ninjaTlacidlo;
    private ImageIcon playIcona;
    private ImageIcon pauzaIcona;
    private ImageIcon ninjaIcona;
    private static boolean pauza;
    private List<Karta> karty;
    private static Casovac casovac;

    public PouzivatelskyPanel(List<Karta> karty) {
        this.karty = karty;

        setOpaque(false);
        setLayout(new BorderLayout());

        pauzaTlacidlo = new JButton();

        playIcona = new ImageIcon(getClass().getResource("/resources/images/Play.png"));
        pauzaIcona = new ImageIcon(getClass().getResource("/resources/images/Pause.png"));

        ninjaTlacidlo = new JButton();
        ninjaIcona = new ImageIcon(getClass().getResource("/resources/images/Ninja.png"));

        vytvorPanel();

        pauza = false;
        casovac = new Casovac(this);
        casovac.start();
    }

    public void vytvorPanel() {
        addPoskusScitok();
        addCasScitokStyl();

        JButton tlacidloVychod = new JButton();

        addButton(pauzaTlacidlo, "Pause.png", event -> {
            pauza = !pauza;
            if (pauza) {
                casovac.setCasBezi(false);
                HernyEngine.setHranie(false);

                pauzaTlacidlo.setIcon(playIcona);

                for (Karta karta : karty)
                    karta.setEnabled(false);
            } else {
                casovac.setCasBezi(true);
                HernyEngine.setHranie(true);

                pauzaTlacidlo.setIcon(pauzaIcona);

                for (Karta karta : karty)
                    if (!karta.bolKliknuty())
                        karta.setEnabled(true);
            }

        });

        addButton(ninjaTlacidlo, "Ninja.png", e -> {
            JOptionPane.showMessageDialog(null, "Dneska ti nejde karta. Stlač klávesovú \nkombináciu Ctrl+alt+n, a pozrí, čo sa stane :)",
                    "Pomôcka", JOptionPane.INFORMATION_MESSAGE);

            ninjaTlacidlo.setIcon(ninjaIcona);
        });

        addButton(tlacidloVychod, "Exit.png", new VychodListener());

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(pauzaTlacidlo);
        buttonsPanel.add(ninjaTlacidlo);
        buttonsPanel.add(tlacidloVychod);

        add(buttonsPanel, BorderLayout.LINE_END);
    }

    public void addPoskusScitok() {
        pokusyStitok = new JLabel();

        pokusyStitok.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        pokusyStitok.setText("Pokusy: 000");
        pokusyStitok.setBorder(new EmptyBorder(0, 15, 0, 0));
        pokusyStitok.setOpaque(false);

        pokusyStitok.setForeground(Color.WHITE);

        add(pokusyStitok, BorderLayout.LINE_START);
    }

    public void addCasScitokStyl() {
        casStitok = new JLabel();
        casStitok.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        casStitok.setForeground(Color.WHITE);
        casStitok.setOpaque(false);
        casStitok.setBorder(new EmptyBorder(0, 140, 0, 0));
        casStitok.setText("00:00");

        add(casStitok, BorderLayout.CENTER);
    }

    public void addButton(JButton button, String iconName, ActionListener listener) {
        button.setIcon(new ImageIcon(getClass().getResource("/resources/images/" + iconName)));

        button.setBackground(Color.WHITE);
        button.setBorder(new EmptyBorder(0, 5, 15, 10));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));


        button.addActionListener(listener);
        button.setOpaque(false);
    }

    public List<Karta> getKarty() {
        return karty;
    }

    public void setCasLabelText(String text) {
        casStitok.setText(text);
    }

    public void setPokusyLabelText(String text) {
        pokusyStitok.setText("Pokusy: " + text);
    }

    public static Casovac getCasovac() {
        return casovac;
    }

    public static boolean isPauza() {
        return pauza;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 90);
    }
}
