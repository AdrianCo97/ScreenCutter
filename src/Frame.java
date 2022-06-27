import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame{

    private static JFrame frame = new JFrame();
    private static JPanel imagePanel = new JPanel();
    private static JLabel imageToEdit = new JLabel();
    private static JButton chooseImageButton = new JButton();
    private static JButton cutImageButton = new JButton();

    public void buildFrame(){
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }

        chooseImageButton.setText("Choose Image");
        chooseImageButton.setFocusPainted(false);

        cutImageButton.setText("Cut Image");
        cutImageButton.setFocusPainted(false);

        chooseImageButton.setText("Choose Image");
        chooseImageButton.setFocusPainted(false);

        cutImageButton.setText("Cut Image");
        cutImageButton.setFocusPainted(false);

        imagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageToEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageToEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(chooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 911, Short.MAX_VALUE)
                                                .addComponent(cutImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(chooseImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                        .addComponent(cutImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        frame.pack();
        frame.setVisible(true);

        chooseImageButton.addActionListener(e -> {
            File file = selectImage();
            System.out.println(file);
            try {
                Image image = ImageIO.read(file);
                renderImage(image);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
          });
    }

    public static File selectImage(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose an image.");
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        return selectedFile;
    }

    private static void renderImage(Image image){
        imageToEdit.setIcon(new ImageIcon(image));
    }
}
