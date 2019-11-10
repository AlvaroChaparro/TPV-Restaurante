package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;

public class Comanda extends JPanel {
	private JLabel lblitem;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private int cantidad;
	private float precio;
	private JSpinner spinCantidad;

	/**
	 * Create the panel.
	 */
	public Comanda(String item, float precio) {
		this.precio = precio;
		setBounds(new Rectangle(0, 0, 0, 100));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		lblitem = new JLabel(item);
		lblitem.setFont(new Font("Dialog", Font.BOLD, 20));
		lblitem.setBounds(23, 13, 126, 19);
		add(lblitem);
		
		cantidad = 1;
		lblCantidad = new JLabel("x"+cantidad);
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCantidad.setBounds(198, 13, 48, 19);
		add(lblCantidad);
		
		lblPrecio = new JLabel(precio+"\t");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPrecio.setBounds(345, 13, 93, 19);
		add(lblPrecio);
		
		spinCantidad = new JSpinner();
		spinCantidad.setBounds(235, 12, 30, 22);
		spinCantidad.setValue(1);
		add(spinCantidad);
		spinCantidad.setVisible(false);
	}
	
	public JLabel getLblitem() {
		return lblitem;
	}

	public void setLblitem(JLabel lblitem) {
		this.lblitem = lblitem;
	}

	public void aumentarCantidad() {
		cantidad++;
		lblCantidad.setText("x"+cantidad);
		spinCantidad.setValue(cantidad);
		lblPrecio.setText(precio*cantidad+"\t");
	}
	
	public float getTotalItem() {
		return precio*cantidad;
	}
}
