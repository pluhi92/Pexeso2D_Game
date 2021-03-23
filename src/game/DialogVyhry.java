package game;

import menu.MenuKomponenty;
import menu.MenuTlacidlo;
import scores.ScitavanieBodov;
import scores.TabulkaScoreModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogVyhry extends JDialog {
    private Image image;
    private static final String IMAGE_VYHRA = "/resources/images/Win.jpg";
    private JTextField poleHrac;
    private ScitavanieBodov scitavanieBodov;

    public DialogVyhry() {
        setTitle("Vyhral si!");
        setResizable(false);
        setModal(true);

        addscitavanieBodov();

        image = new ImageIcon(getClass().getResource(IMAGE_VYHRA)).getImage();

        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                if (image == null)
                    return;

                g.drawImage(image, 0, 0, null);
            }
        };

        JPanel newScorePanel = new JPanel();

        poleHrac = new JTextField("Zadajte meno", 30);

        poleHrac.getCaret().setVisible(false);

        poleHrac.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 28));
        poleHrac.setBorder(new EmptyBorder(10, 10, 10, 10));
        poleHrac.setPreferredSize(new Dimension(300, 58));
        poleHrac.setFocusable(false);
        poleHrac.setFocusable(true);

        newScorePanel.add(poleHrac);

        MenuTlacidlo addUser = new MenuTlacidlo("Pridaj", new Color(0x8D8A8D), 28, new Dimension(200, 60));


        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                DialogVyhry.this.setVisible(false);

                int cas = PouzivatelskyPanel.getCasovac().getCas();
                int pokusy = HernyEngine.getPokusy();
                Level level = Komponenty.getLevel();
                int body = scitavanieBodov.scitavanieBodov(cas, pokusy, level);

                TabulkaScoreModel.getInstanciaOf().addScore(poleHrac.getText(), level,
                        PouzivatelskyPanel.getCasovac().getStringCas(), pokusy, body);

                PametovyRamec pamat = PametovyRamec.getInstanceOf();
                pamat.getContentPane().removeAll();
                pamat.add(new MenuKomponenty());

                pamat.revalidate();
                pamat.repaint();
            }
        });


        poleHrac.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (poleHrac.getText().equals("Zadajte meno")) {
                    poleHrac.setText("");
                }
            }
        });

        newScorePanel.add(addUser);
        newScorePanel.setOpaque(false);
        mainPanel.add(newScorePanel, BorderLayout.SOUTH);

        add(mainPanel);

        pack();
    }

    public void addscitavanieBodov() {
        scitavanieBodov = (int cas, int pokusy, Level level) -> {
            switch (level) {
                case Ľahká:
                    return Math.round((16.0f / (cas + pokusy)) * 100);
                case Stredná:
                    return Math.round((36.0f / (cas / 10f + pokusy / 10f)) * 200);
                case Ťažká:
                    return Math.round((64.0f / (cas / 100f + pokusy / 10f)) * 300);
                case Expert:
                    return Math.round((100.0f / (cas / 1000f + pokusy / 10f)) * 400);
            }
            return 0;
        };
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
