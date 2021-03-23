package menu;

import javax.swing.*;
import java.awt.*;

public class MenuScitok extends JLabel {
    public MenuScitok(String text, Font font, Color fontColor) {
        setText(text);
        setFont(font);
        setForeground(fontColor);

        setHorizontalAlignment(JLabel.CENTER);
    }
}