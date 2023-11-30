package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Loser implements LoserInterface{
    public void displayLoserView() {
        // Create the main frame for the winner view
        JFrame frame = new JFrame("Winner!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to full screen size
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);

        // Custom panel with background image
        JPanel backgroundPanel = new BackgroundPanel("UIAssets/lost.gif");
        backgroundPanel.setLayout(new GridBagLayout());

        // Create a label with the winning message, using HTML for styling
        JLabel winnerLabel = new JLabel("<html><u>You lost!</u></html>");
        winnerLabel.setFont(new Font("Serif", Font.BOLD, 90)); // Increase font size
        winnerLabel.setForeground(Color.RED); // Set font color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Center the label
        backgroundPanel.add(winnerLabel, gbc); // Add the label to the background panel

        // Add the backgroundPanel to the center of the frame
        frame.add(backgroundPanel, BorderLayout.CENTER);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    // Custom panel class for drawing the background image
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}
