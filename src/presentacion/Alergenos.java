package presentacion;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Alergenos extends JPanel {
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public Alergenos() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		JLabel[] alergenos = new JLabel[12];

		for(int i=0;i<12;i++) {
			alergenos[i] = new JLabel("");
			alergenos[i].setBounds(new Rectangle(0, 0, 100, 100));
			ImageIcon imageFoto = ajustarImagenLabel(alergenos[i],"/recursos/imagenesIPO/Alergenos/alergeno_"+(i+1)+".png");
			alergenos[i].setIcon(imageFoto);
			panel.add(alergenos[i]);
		}
	}
	
	private ImageIcon ajustarImagenLabel(JLabel label,String url) {
		BufferedImage img = null; //Creamos una Buffered Image
		try {
			img = ImageIO.read(getClass().getResource(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Escalamos la Buffered Imagen a las dimensiones de la etiqueta
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		//Creamos el ImageIcon que pasarle a la etiqueta
		ImageIcon imageIcon = new ImageIcon(dimg);

		return imageIcon;
	}

}
