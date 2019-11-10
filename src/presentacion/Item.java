package presentacion;

import javax.swing.JPanel;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import javax.swing.border.MatteBorder;
import java.awt.Color;

public class Item extends JPanel {
	private JLabel lblImagen;
	private JPanel panel;
	private JButton btnAniadir;
	private JButton btnInfo;
	private VentanaPrincipal padre;
	private JPanel pnlLabels;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private Alergenos panelAlergenos;
	private String url;
	private String nombreItem;
	
	/**
	 * Create the panel.
	 */
	public Item(VentanaPrincipal padre, String nombreItem, float precioItem, String url) {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//		padre.aniadirComanda(nombreItem, precioItem);
//		padre.pnlListaProductos.removeAll();
		this.padre = padre;
		this.url = url;
		this.nombreItem = nombreItem;
		
		setBounds(new Rectangle(0, 0, 100, 100));
		setLayout(new BorderLayout(0, 0));
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(new Rectangle(0, 0, 100, 100));
		ImageIcon imageFoto = ajustarImagenLabel(lblImagen);
		lblImagen.setIcon(imageFoto);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblImagen, BorderLayout.CENTER);
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnAniadir = new JButton("");
		btnAniadir.setBounds(new Rectangle(0, 0, 50, 50));
		ImageIcon imageAniadir = ajustarImagenButton("/recursos/plus.png", btnAniadir);
		btnAniadir.setIcon(imageAniadir);
		btnAniadir.addActionListener(new BtnNewButtonActionListener(nombreItem, precioItem));
		//btnAniadir.setBorder(BorderFactory.createEmptyBorder());
		btnAniadir.setContentAreaFilled(false);
		panel.add(btnAniadir);
		
		btnInfo = new JButton("");
		btnInfo.addActionListener(new BtnInfoActionListener());
		btnInfo.setBounds(new Rectangle(0, 0, 50, 50));
		ImageIcon imageInfo = ajustarImagenButton("/recursos/ingredientes2.jpg", btnInfo);
		btnInfo.setIcon(imageInfo);
		btnInfo.setContentAreaFilled(false);
		panel.add(btnInfo);
		
		pnlLabels = new JPanel();
		add(pnlLabels, BorderLayout.NORTH);
		pnlLabels.setLayout(new BorderLayout(0, 0));
		
		lblNombre = new JLabel("  "+nombreItem);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
		pnlLabels.add(lblNombre, BorderLayout.WEST);
		
		lblPrecio = new JLabel(""+precioItem+" €  ");
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 18));
		pnlLabels.add(lblPrecio, BorderLayout.EAST);
		
	}
	
	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}
	
	public void ajustarImagenItem(int ancho, int alto) {
		BufferedImage img = null; //Creamos una Buffered Image
		try {
			img = ImageIO.read(getClass().getResource(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Escalamos la Buffered Imagen a las dimensiones de la etiqueta
		Image dimg = img.getScaledInstance(ancho, alto,Image.SCALE_SMOOTH);
		//Creamos el ImageIcon que pasarle a la etiqueta
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblImagen.setIcon(imageIcon);
	}

	private ImageIcon ajustarImagenLabel(JLabel label) {
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
	
	private ImageIcon ajustarImagenButton(String urlImagen, JButton button) {
		BufferedImage img = null; //Creamos una Buffered Image
		try {
			img = ImageIO.read(getClass().getResource(urlImagen));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Escalamos la Buffered Imagen a las dimensiones de la etiqueta
		Image dimg = img.getScaledInstance(button.getWidth(), button.getHeight(),Image.SCALE_SMOOTH);
		//Creamos el ImageIcon que pasarle a la etiqueta
		ImageIcon imageIcon = new ImageIcon(dimg);

		return imageIcon;
	}

	private class BtnNewButtonActionListener implements ActionListener {
		private String nombreItem;
		private float precioItem;
		
	    public BtnNewButtonActionListener(String nombreItem, float precioItem) {
	        this.nombreItem = nombreItem;
	        this.precioItem = precioItem;
	    }
	    
		public void actionPerformed(ActionEvent e) {
			padre.aniadirComanda(nombreItem, precioItem);
		}
	}
	private class BtnInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			panelAlergenos = new Alergenos();
			panelAlergenos.show(true);
            JOptionPane.showMessageDialog(null,panelAlergenos,"Alergenos de: "+nombreItem,-1,null);
		}
	}
}
