package menu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuTlacidlo extends JButton {
    public MenuTlacidlo(String meno, Color farba, int velkostPisma, Dimension velkost) {
        super(meno);

        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, velkostPisma));
        setForeground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(new Color(0xD0C801));
                setFont(new Font(getName(), getFont().getStyle(), getFont().getSize() + 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.WHITE);
                setFont(new Font(getName(), getFont().getStyle(), getFont().getSize() - 2));
                repaint();
            }
        });

        Border prednyRam = BorderFactory.createRaisedBevelBorder();
        Border zadnyRam = BorderFactory.createLoweredBevelBorder();
        setBorder(BorderFactory.createCompoundBorder(prednyRam, zadnyRam));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(farba);

        setPreferredSize(velkost);
        setFocusable(false);


//	TRANSPARENTNE TLACIDLA
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
