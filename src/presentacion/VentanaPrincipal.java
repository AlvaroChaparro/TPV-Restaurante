package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ButtonGroup;

public class VentanaPrincipal {

	private JFrame frame;
	private JTextField txtTarjeta;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnIdiomas;
	private JPanel pnlListaProductos = new JPanel();
	private JLabel lblTotalPrecio = new JLabel();
	private JPanel pnlTotal;
	private JPanel pnlOfertas;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JPanel pnlListaProductosPedido = new JPanel();
	private JLabel lblTotalPedidoX = new JLabel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 222, 173));
		frame.setBackground(Color.WHITE);
		frame.setBounds(new Rectangle(0, 0, 1080, 1920));

		//Maximizamos Ventana
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);

		//frame.setBounds(new Rectangle(0, 0, 960, 540));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pnlSuperior = new JPanel();
		pnlSuperior.setBackground(new Color(255, 222, 173));
		pnlSuperior.setBounds(new Rectangle(0, 0, 20, 20));
		frame.getContentPane().add(pnlSuperior, BorderLayout.NORTH);
		GridBagLayout gbl_pnlSuperior = new GridBagLayout();
		gbl_pnlSuperior.columnWidths = new int[]{208, 50, 338, 0, 0, 0, 0};
		gbl_pnlSuperior.rowHeights = new int[]{50, 0};
		gbl_pnlSuperior.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSuperior.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlSuperior.setLayout(gbl_pnlSuperior);

		JLabel lblFoto = new JLabel(""); //$NON-NLS-1$
		lblFoto.setBounds(new Rectangle(0, 0, 100, 100));
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.anchor = GridBagConstraints.WEST;
		gbc_lblFoto.insets = new Insets(0, 0, 0, 5);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 0;
		pnlSuperior.add(lblFoto, gbc_lblFoto);

		ImageIcon imageFoto = ajustarImagenLabel("/recursos/boy.png",lblFoto); //$NON-NLS-1$
		lblFoto.setIcon(imageFoto);

		JLabel lblInfoUsuario = new JLabel(Messages.getString("VentanaPrincipal.2")); //$NON-NLS-1$
		lblInfoUsuario.setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 24 )); //$NON-NLS-1$

		GridBagConstraints gbc_lblInfoUsuario = new GridBagConstraints();
		gbc_lblInfoUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblInfoUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblInfoUsuario.gridx = 2;
		gbc_lblInfoUsuario.gridy = 0;
		pnlSuperior.add(lblInfoUsuario, gbc_lblInfoUsuario);

		JButton btnIdiomas = new JButton();
		btnIdiomas.addActionListener(new BtnIdiomasActionListener());
		btnIdiomas.setBorderPainted(true);
		btnIdiomas.setBounds(new Rectangle(0, 0, 50, 50));

		GridBagConstraints gbc_btnIdiomas = new GridBagConstraints();
		gbc_btnIdiomas.insets = new Insets(0, 0, 0, 5);
		gbc_btnIdiomas.gridx = 3;
		gbc_btnIdiomas.gridy = 0;
		pnlSuperior.add(btnIdiomas, gbc_btnIdiomas);

		ImageIcon imageIdiomas = ajustarImagenButton("/recursos/idiomas.png", btnIdiomas); //$NON-NLS-1$
		btnIdiomas.setIcon(imageIdiomas);
		//btnIdiomas.setBorder(BorderFactory.createEmptyBorder());
		btnIdiomas.setContentAreaFilled(false);
		
		JButton btnAjustes = new JButton();
		btnAjustes.setBorderPainted(true);
		btnAjustes.setBounds(new Rectangle(0, 0, 50, 50));
		btnAjustes.addActionListener(new BtnAjustesActionListener());

		GridBagConstraints gbc_btnAjustes = new GridBagConstraints();
		gbc_btnAjustes.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjustes.gridx = 4;
		gbc_btnAjustes.gridy = 0;
		pnlSuperior.add(btnAjustes, gbc_btnAjustes);

		ImageIcon imageAjustes = ajustarImagenButton("/recursos/ajustes.png", btnAjustes); //$NON-NLS-1$
		btnAjustes.setIcon(imageAjustes);
		//btnAjustes.setBorder(BorderFactory.createEmptyBorder());
		btnAjustes.setContentAreaFilled(false);
		
		JButton btnAyuda = new JButton();
		btnAyuda.setBorderPainted(true);
		btnAyuda.setBounds(new Rectangle(0, 0, 50, 50));
		
		GridBagConstraints gbc_btnAyuda = new GridBagConstraints();
		gbc_btnAyuda.gridx = 5;
		gbc_btnAyuda.gridy = 0;
		pnlSuperior.add(btnAyuda, gbc_btnAyuda);
		
		ImageIcon imageAyuda = ajustarImagenButton("/recursos/ayuda.png", btnAyuda); //$NON-NLS-1$
		btnAyuda.setIcon(imageAyuda);
		//btnAyuda.setBorder(BorderFactory.createEmptyBorder());
		btnAyuda.setContentAreaFilled(false);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.setToolTipText(""); //$NON-NLS-1$
		tabbedPane.setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 24 )); //$NON-NLS-1$

		JPanel pnlMenu = new JPanel();
		pnlMenu.setMaximumSize(new Dimension(100, 32767));
		tabbedPane.addTab(Messages.getString("VentanaPrincipal.9"), null, pnlMenu, null); //$NON-NLS-1$
		GridBagLayout gbl_pnlMenu = new GridBagLayout();
		gbl_pnlMenu.columnWidths = new int[]{1030, 422, 130, 0};
		gbl_pnlMenu.rowHeights = new int[]{635, 0};
		gbl_pnlMenu.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlMenu.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlMenu.setLayout(gbl_pnlMenu);

		JTabbedPane pnlMenuCompra = new JTabbedPane(JTabbedPane.TOP);
		pnlMenuCompra.setBackground(new Color(255, 255, 255));
		pnlMenuCompra.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		pnlMenuCompra.setMaximumSize(new Dimension(100, 100));
		GridBagConstraints gbc_pnlMenuCompra = new GridBagConstraints();
		gbc_pnlMenuCompra.fill = GridBagConstraints.BOTH;
		gbc_pnlMenuCompra.insets = new Insets(0, 0, 0, 5);
		gbc_pnlMenuCompra.gridx = 0;
		gbc_pnlMenuCompra.gridy = 0;
		pnlMenu.add(pnlMenuCompra, gbc_pnlMenuCompra);

		pnlMenuCompra.setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 20 )); //$NON-NLS-1$

		JScrollPane scrollOfertas = new JScrollPane();
		scrollOfertas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollOfertas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlMenuCompra.addTab(Messages.getString("VentanaPrincipal.11"), null, scrollOfertas, null); //$NON-NLS-1$

		JPanel pnlOfertas = new JPanel();
		pnlOfertas.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollOfertas.setViewportView(pnlOfertas);
		pnlOfertas.setLayout(new GridLayout(0, 3, 15, 15));
		
		JScrollPane scrollProductos = new JScrollPane();
		scrollProductos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollProductos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlMenuCompra.addTab(Messages.getString("VentanaPrincipal.12"), null, scrollProductos, null); //$NON-NLS-1$
		
		JPanel pnlProductos = new JPanel();
		pnlProductos.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollProductos.setViewportView(pnlProductos);
		pnlProductos.setLayout(new GridLayout(0, 3, 15, 15));
		
		JScrollPane scrollMenus = new JScrollPane();
		scrollMenus.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMenus.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlMenuCompra.addTab(Messages.getString("VentanaPrincipal.13"), null, scrollMenus, null); //$NON-NLS-1$
		
		JPanel pnlMenus = new JPanel();
		pnlMenus.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollMenus.setViewportView(pnlMenus);
		pnlMenus.setLayout(new GridLayout(0, 3, 15, 15));

		JScrollPane scrollPostres = new JScrollPane();
		scrollPostres.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPostres.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlMenuCompra.addTab(Messages.getString("VentanaPrincipal.14"), null, scrollPostres, null); //$NON-NLS-1$
		
		JPanel pnlPostres = new JPanel();
		pnlPostres.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPostres.setViewportView(pnlPostres);
		pnlPostres.setLayout(new GridLayout(0, 3, 15, 15));

		JScrollPane scrollBebidas = new JScrollPane();
		scrollBebidas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBebidas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlMenuCompra.addTab(Messages.getString("VentanaPrincipal.15"), null, scrollBebidas, null); //$NON-NLS-1$
		
		JPanel pnlBebidas = new JPanel();
		pnlBebidas.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollBebidas.setViewportView(pnlBebidas);
		pnlBebidas.setLayout(new GridLayout(0, 3, 15, 15));
		
		JScrollPane scrollComplementos = new JScrollPane();
		scrollComplementos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollComplementos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlMenuCompra.addTab(Messages.getString("VentanaPrincipal.16"), null, scrollComplementos, null); //$NON-NLS-1$
		
		JPanel pnlComplementos = new JPanel();
		pnlComplementos.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollComplementos.setViewportView(pnlComplementos);
		pnlComplementos.setLayout(new GridLayout(0, 3, 15, 15));
		

		JPanel pnlPedido = new JPanel();
		pnlPedido.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		pnlPedido.setBounds(new Rectangle(0, 0, 100, 0));
		GridBagConstraints gbc_pnlPedido = new GridBagConstraints();
		gbc_pnlPedido.insets = new Insets(0, 0, 0, 5);
		gbc_pnlPedido.fill = GridBagConstraints.BOTH;
		gbc_pnlPedido.gridx = 1;
		gbc_pnlPedido.gridy = 0;
		pnlMenu.add(pnlPedido, gbc_pnlPedido);
		pnlPedido.setLayout(new BorderLayout(0, 0));

		JLabel lblTuPedido = new JLabel(Messages.getString("VentanaPrincipal.17")); //$NON-NLS-1$
		lblTuPedido.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25)); //$NON-NLS-1$
		pnlPedido.add(lblTuPedido, BorderLayout.NORTH);

		JButton btnConfirmar = new JButton(Messages.getString("VentanaPrincipal.19")); //$NON-NLS-1$
		btnConfirmar.setBackground(new Color(0, 255, 127));
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 35)); //$NON-NLS-1$
		pnlPedido.add(btnConfirmar, BorderLayout.SOUTH);
		
		JPanel pnlListaYTotal = new JPanel();
		pnlPedido.add(pnlListaYTotal, BorderLayout.CENTER);
		pnlListaYTotal.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPedido = new JScrollPane();
		pnlListaYTotal.add(scrollPedido, BorderLayout.CENTER);
		
		pnlListaProductos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPedido.setViewportView(pnlListaProductos);
		pnlListaProductos.setLayout(new BoxLayout(pnlListaProductos, BoxLayout.Y_AXIS));
		
		JPanel pnlTotal = new JPanel();
		pnlTotal.setBounds(new Rectangle(0, 0, 0, 100));
		pnlListaYTotal.add(pnlTotal, BorderLayout.SOUTH);
		pnlTotal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTotal.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTotal = new JLabel(Messages.getString("VentanaPrincipal.21")); //$NON-NLS-1$
		lblTotal.setFont(new Font("Arial", Font.BOLD, 24)); //$NON-NLS-1$
		pnlTotal.add(lblTotal, BorderLayout.WEST);
		
		//JLabel lblTotalPrecio = new JLabel("0 €    ");
		lblTotalPrecio.setText("0 €    "); //$NON-NLS-1$
		lblTotalPrecio.setFont(new Font("Arial", Font.BOLD, 24)); //$NON-NLS-1$
		pnlTotal.add(lblTotalPrecio, BorderLayout.EAST);

		JPanel pnlPago = new JPanel();
		pnlPago.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		GridBagConstraints gbc_pnlPago = new GridBagConstraints();
		gbc_pnlPago.fill = GridBagConstraints.BOTH;
		gbc_pnlPago.gridx = 2;
		gbc_pnlPago.gridy = 0;
		pnlMenu.add(pnlPago, gbc_pnlPago);
		pnlPago.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25)); //$NON-NLS-1$
		pnlPago.add(tabbedPane_2, BorderLayout.CENTER);

		JPanel pnlEnLocal = new JPanel();
		tabbedPane_2.addTab(Messages.getString("VentanaPrincipal.26"), null, pnlEnLocal, null); //$NON-NLS-1$
		GridBagLayout gbl_pnlEnLocal = new GridBagLayout();
		gbl_pnlEnLocal.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlEnLocal.rowHeights = new int[] {0, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 0};
		gbl_pnlEnLocal.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlEnLocal.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlEnLocal.setLayout(gbl_pnlEnLocal);

		JRadioButton rdbtnNewRadioButton = new JRadioButton(Messages.getString("VentanaPrincipal.27")); //$NON-NLS-1$
		rdbtnNewRadioButton.addActionListener(new RdbtnNewRadioButtonActionListener());
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 1;
		pnlEnLocal.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(Messages.getString("VentanaPrincipal.29")); //$NON-NLS-1$
		rdbtnNewRadioButton_1.addActionListener(new RdbtnNewRadioButton_1ActionListener());
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		pnlEnLocal.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

		JLabel lblNewLabel = new JLabel(Messages.getString("VentanaPrincipal.31")); //$NON-NLS-1$
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		pnlEnLocal.add(lblNewLabel, gbc_lblNewLabel);

		MaskFormatter formatoTarjeta = null;
		try {
			formatoTarjeta = new MaskFormatter("####'-####'-####'-####'"); //$NON-NLS-1$
			formatoTarjeta.setPlaceholderCharacter('*');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTarjeta = new JFormattedTextField(formatoTarjeta);
		txtTarjeta.setFont(new Font("Arial", Font.BOLD, 18)); //$NON-NLS-1$
		GridBagConstraints gbc_txtTarjeta = new GridBagConstraints();
		gbc_txtTarjeta.insets = new Insets(0, 0, 5, 5);
		gbc_txtTarjeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTarjeta.gridx = 2;
		gbc_txtTarjeta.gridy = 3;
		pnlEnLocal.add(txtTarjeta, gbc_txtTarjeta);
		txtTarjeta.setColumns(10);
		txtTarjeta.disable();

		JLabel lblNewLabel_1 = new JLabel(Messages.getString("VentanaPrincipal.35")); //$NON-NLS-1$
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		pnlEnLocal.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 18)); //$NON-NLS-1$
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 5;
		pnlEnLocal.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblVip = new JLabel(Messages.getString("VentanaPrincipal.38")); //$NON-NLS-1$
		lblVip.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_lblVip = new GridBagConstraints();
		gbc_lblVip.anchor = GridBagConstraints.WEST;
		gbc_lblVip.insets = new Insets(0, 0, 5, 5);
		gbc_lblVip.gridx = 0;
		gbc_lblVip.gridy = 7;
		pnlEnLocal.add(lblVip, gbc_lblVip);

		JCheckBox chckbxNewCheckBox = new JCheckBox(""); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 7;
		pnlEnLocal.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		JLabel lblNumPedido = new JLabel(Messages.getString("VentanaPrincipal.41")); //$NON-NLS-1$
		lblNumPedido.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNumPedido = new GridBagConstraints();
		gbc_lblNumPedido.anchor = GridBagConstraints.WEST;
		gbc_lblNumPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumPedido.gridx = 0;
		gbc_lblNumPedido.gridy = 9;
		pnlEnLocal.add(lblNumPedido, gbc_lblNumPedido);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 18)); //$NON-NLS-1$
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 9;
		pnlEnLocal.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblTicket = new JLabel(Messages.getString("VentanaPrincipal.44")); //$NON-NLS-1$
		lblTicket.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_lblTicket = new GridBagConstraints();
		gbc_lblTicket.anchor = GridBagConstraints.WEST;
		gbc_lblTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblTicket.gridx = 0;
		gbc_lblTicket.gridy = 11;
		pnlEnLocal.add(lblTicket, gbc_lblTicket);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox(""); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1.gridx = 2;
		gbc_chckbxNewCheckBox_1.gridy = 11;
		pnlEnLocal.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 13;
		pnlEnLocal.add(panel_1, gbc_panel_1);

		JPanel pnlDomicilio = new JPanel();
		tabbedPane_2.addTab(Messages.getString("VentanaPrincipal.47"), null, pnlDomicilio, null); //$NON-NLS-1$

		JPanel pnlBotonesCompra = new JPanel();
		pnlPago.add(pnlBotonesCompra, BorderLayout.SOUTH);

		JButton btnConfirmaPedido = new JButton(Messages.getString("VentanaPrincipal.48")); //$NON-NLS-1$
		btnConfirmaPedido.setBackground(new Color(0, 255, 127));
		btnConfirmaPedido.setForeground(new Color(255, 255, 255));
		btnConfirmaPedido.setFont(new Font("Arial", Font.BOLD, 30)); //$NON-NLS-1$
		pnlBotonesCompra.add(btnConfirmaPedido);

		JButton btnCancelar = new JButton(Messages.getString("VentanaPrincipal.50")); //$NON-NLS-1$
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 30)); //$NON-NLS-1$
		pnlBotonesCompra.add(btnCancelar);

		JPanel pnlClientes = new JPanel();
		tabbedPane.addTab(Messages.getString("VentanaPrincipal.52"), null, pnlClientes, null); //$NON-NLS-1$
		pnlClientes.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollClientes = new JScrollPane();
		scrollClientes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlClientes.add(scrollClientes);
		
		JPanel panel_3 = new JPanel();
		scrollClientes.setViewportView(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 50, 30));
		
		btnNewButton = new JButton("Jorge Mata Sanchez"); //$NON-NLS-1$
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40)); //$NON-NLS-1$
		btnNewButton.setBackground(Color.white);
		btnNewButton.addActionListener(new Btn_Resaltar2(btnNewButton));
		panel_3.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Jose Jimenez Lopez"); //$NON-NLS-1$
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 40)); //$NON-NLS-1$
		btnNewButton_1.setBackground(Color.white);
		btnNewButton_1.addActionListener(new Btn_Resaltar2(btnNewButton_1));
		panel_3.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Luis Hernandez Garrido"); //$NON-NLS-1$
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 40)); //$NON-NLS-1$
		btnNewButton_2.addActionListener(new Btn_Resaltar2(btnNewButton_2));
		btnNewButton_2.setBackground(Color.white);
		panel_3.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Pedro Gomez Labian"); //$NON-NLS-1$
		btnNewButton_3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 40)); //$NON-NLS-1$
		btnNewButton_3.addActionListener(new Btn_Resaltar2(btnNewButton_3));
		btnNewButton_3.setBackground(Color.white);
		panel_3.add(btnNewButton_3);
		
		JPanel pnlDatosCliente = new JPanel();
		pnlClientes.add(pnlDatosCliente);
		GridBagLayout gbl_pnlDatosCliente = new GridBagLayout();
		gbl_pnlDatosCliente.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlDatosCliente.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlDatosCliente.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDatosCliente.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		pnlDatosCliente.setLayout(gbl_pnlDatosCliente);
		
		JLabel lblFotoUser = new JLabel(""); //$NON-NLS-1$
		lblFotoUser.setBounds(new Rectangle(0, 0, 250, 250));
		
		ImageIcon imageFotoUser = ajustarImagenLabel("/recursos/girl.png",lblFotoUser); //$NON-NLS-1$
		lblFotoUser.setIcon(imageFotoUser);
		
		GridBagConstraints gbc_lblFotoUser = new GridBagConstraints();
		gbc_lblFotoUser.gridwidth = 2;
		gbc_lblFotoUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoUser.gridx = 2;
		gbc_lblFotoUser.gridy = 0;
		pnlDatosCliente.add(lblFotoUser, gbc_lblFotoUser);
		
		JLabel lblDni = new JLabel(Messages.getString("VentanaPrincipal.63")); //$NON-NLS-1$
		lblDni.setFont(new Font("Arial", Font.BOLD, 25)); //$NON-NLS-1$
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 2;
		pnlDatosCliente.add(lblDni, gbc_lblDni);
		
		MaskFormatter formatoDNI = null;
		try {
			formatoDNI = new MaskFormatter("########'-?'"); //$NON-NLS-1$
			formatoDNI.setPlaceholderCharacter('*');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//JFormattedTextField txtDNI = new JFormattedTextField();
		JFormattedTextField txtDNI = new JFormattedTextField(formatoDNI);
		txtDNI.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.gridx = 3;
		gbc_txtDNI.gridy = 2;
		pnlDatosCliente.add(txtDNI, gbc_txtDNI);
		
		JLabel lblNombre = new JLabel(Messages.getString("VentanaPrincipal.67")); //$NON-NLS-1$
		lblNombre.setFont(new Font("Arial", Font.BOLD, 25)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		pnlDatosCliente.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 4;
		pnlDatosCliente.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnBorrarUsuario = new JButton(Messages.getString("VentanaPrincipal.70")); //$NON-NLS-1$
		btnBorrarUsuario.setForeground(new Color(255, 255, 255));
		btnBorrarUsuario.setBackground(new Color(255, 0, 0));
		btnBorrarUsuario.setFont(new Font("Arial", Font.BOLD, 30)); //$NON-NLS-1$
		GridBagConstraints gbc_btnBorrarUsuario = new GridBagConstraints();
		gbc_btnBorrarUsuario.gridx = 7;
		gbc_btnBorrarUsuario.gridy = 12;
		pnlDatosCliente.add(btnBorrarUsuario, gbc_btnBorrarUsuario);
		
		JLabel lblApellidos = new JLabel(Messages.getString("VentanaPrincipal.72")); //$NON-NLS-1$
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 25)); //$NON-NLS-1$
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 6;
		pnlDatosCliente.add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 4;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 3;
		gbc_txtApellidos.gridy = 6;
		pnlDatosCliente.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblDireccion = new JLabel(Messages.getString("VentanaPrincipal.75")); //$NON-NLS-1$
		lblDireccion.setFont(new Font("Arial", Font.BOLD, 25)); //$NON-NLS-1$
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.WEST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 8;
		pnlDatosCliente.add(lblDireccion, gbc_lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.BOLD, 20)); //$NON-NLS-1$
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.gridwidth = 4;
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridx = 3;
		gbc_txtDireccion.gridy = 8;
		pnlDatosCliente.add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);
		
		JButton btnAniadirUsuario = new JButton(Messages.getString("VentanaPrincipal.78")); //$NON-NLS-1$
		btnAniadirUsuario.setForeground(new Color(255, 255, 255));
		btnAniadirUsuario.setBackground(new Color(0, 255, 127));
		btnAniadirUsuario.setFont(new Font("Arial", Font.BOLD, 30)); //$NON-NLS-1$
		GridBagConstraints gbc_btnAniadirUsuario = new GridBagConstraints();
		gbc_btnAniadirUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_btnAniadirUsuario.gridx = 6;
		gbc_btnAniadirUsuario.gridy = 12;
		pnlDatosCliente.add(btnAniadirUsuario, gbc_btnAniadirUsuario);
		
		JLabel lblVip_1 = new JLabel(Messages.getString("VentanaPrincipal.80")); //$NON-NLS-1$
		lblVip_1.setFont(new Font("Arial", Font.BOLD, 25)); //$NON-NLS-1$
		GridBagConstraints gbc_lblVip_1 = new GridBagConstraints();
		gbc_lblVip_1.anchor = GridBagConstraints.WEST;
		gbc_lblVip_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblVip_1.gridx = 1;
		gbc_lblVip_1.gridy = 10;
		pnlDatosCliente.add(lblVip_1, gbc_lblVip_1);
		
		JCheckBox chckbxVIP = new JCheckBox(""); //$NON-NLS-1$
		chckbxVIP.setBounds(new Rectangle(0, 0, 100, 100));
		GridBagConstraints gbc_chckbxVIP = new GridBagConstraints();
		gbc_chckbxVIP.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVIP.gridx = 3;
		gbc_chckbxVIP.gridy = 10;
		pnlDatosCliente.add(chckbxVIP, gbc_chckbxVIP);

		JPanel pnlPedidos = new JPanel();
		tabbedPane.addTab(Messages.getString("VentanaPrincipal.83"), null, pnlPedidos, null); //$NON-NLS-1$
		pnlPedidos.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		pnlPedidos.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPedidos = new JScrollPane();
		scrollPedidos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPedidos);
		
		JPanel pnlListaPedidos = new JPanel();
		scrollPedidos.setViewportView(pnlListaPedidos);
		pnlListaPedidos.setLayout(new GridLayout(0, 1, 5, 5));
		
		btnNewButton_4 = new JButton(Messages.getString("VentanaPrincipal.84") //$NON-NLS-1$
				+ Messages.getString("VentanaPrincipal.85")); //$NON-NLS-1$
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new Btn_Resaltar(btnNewButton_4));
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 30)); //$NON-NLS-1$
		pnlListaPedidos.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton(Messages.getString("VentanaPrincipal.87") //$NON-NLS-1$
				+ Messages.getString("VentanaPrincipal.88")); //$NON-NLS-1$
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new Btn_Resaltar(btnNewButton_5));
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 30)); //$NON-NLS-1$
		pnlListaPedidos.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton(Messages.getString("VentanaPrincipal.90") //$NON-NLS-1$
				+ Messages.getString("VentanaPrincipal.91")); //$NON-NLS-1$
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.addActionListener(new Btn_Resaltar(btnNewButton_6));
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 30)); //$NON-NLS-1$
		pnlListaPedidos.add(btnNewButton_6);

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_6.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel(Messages.getString("VentanaPrincipal.93")); //$NON-NLS-1$
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20)); //$NON-NLS-1$
		panel_4.add(lblNewLabel_5, BorderLayout.WEST);
		
		//JLabel lblTotalPedidoX = new JLabel("");
		lblTotalPedidoX.setFont(new Font("Tahoma", Font.BOLD, 20)); //$NON-NLS-1$
		panel_4.add(lblTotalPedidoX, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		//JPanel pnlListaProductosPedido = new JPanel();
		scrollPane.setViewportView(pnlListaProductosPedido);
		pnlListaProductosPedido.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlMapa = new JPanel();
		pnlPedidos.add(pnlMapa);
		pnlMapa.setLayout(new BorderLayout(0, 0));
		
		JButton btnCalcular = new JButton(Messages.getString("VentanaPrincipal.96")); //$NON-NLS-1$
		btnCalcular.setBackground(new Color(255, 153, 0));
		btnCalcular.setForeground(new Color(255, 255, 255));
		btnCalcular.setFont(new Font("Arial", Font.BOLD, 25)); //$NON-NLS-1$
		pnlMapa.add(btnCalcular, BorderLayout.SOUTH);
		
		JLabel lvlMapa = new JLabel(""); //$NON-NLS-1$
		lvlMapa.setHorizontalAlignment(SwingConstants.CENTER);
		lvlMapa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/mapa.PNG"))); //$NON-NLS-1$
		pnlMapa.add(lvlMapa, BorderLayout.NORTH);
		
		aniadirOfertas(pnlOfertas);
		aniadirProductos(pnlProductos);
		aniadirMenus(pnlMenus);
		aniadirPostres(pnlPostres);
		aniadirBebidas(pnlBebidas);
		aniadirComplementos(pnlComplementos);

		ajustarImagenesGrid(pnlOfertas);
		ajustarImagenesGrid(pnlProductos);
		ajustarImagenesGrid(pnlMenus);
		ajustarImagenesGrid(pnlPostres);
		ajustarImagenesGrid(pnlBebidas);
		ajustarImagenesGrid(pnlComplementos);
	}

	private void aniadirOfertas(JPanel panel) {
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.100"),4f,"/recursos/ImagenesIPO/Ofertas/long_chicken.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.102"),8f,"/recursos/ImagenesIPO/Ofertas/pizza_pina.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.104"),10f,"/recursos/ImagenesIPO/Ofertas/2x1 pizzas.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.106"),1f,"/recursos/ImagenesIPO/Postres/helados.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void aniadirProductos(JPanel panel) {
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.108"),3.5f,"/recursos/ImagenesIPO/Productos/burguer_ternera.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.110"),3f,"/recursos/ImagenesIPO/Productos/cheeseburguer.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.112"),7f,"/recursos/ImagenesIPO/Productos/double_burguer.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.114"),4f,"/recursos/ImagenesIPO/Productos/ensalada.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.116"),7f,"/recursos/ImagenesIPO/Productos/pizza1.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.118"),10f,"/recursos/ImagenesIPO/Productos/pizza2.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.120"),9f,"/recursos/ImagenesIPO/Productos/pizza3.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void aniadirMenus(JPanel panel) {
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.122"),12f,"/recursos/ImagenesIPO/Menus/costillar.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.124"),10f,"/recursos/ImagenesIPO/Menus/hamb_grande+patatas+bebida.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.126"),11f,"/recursos/ImagenesIPO/Menus/pollo+patatas+bebida.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.128"),10f,"/recursos/ImagenesIPO/Menus/spaghetti.jpg")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void aniadirPostres(JPanel panel) {
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.130"),2f,"/recursos/ImagenesIPO/Postres/helados.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.132"),2.5f,"/recursos/ImagenesIPO/Postres/flan_huevo.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.134"),3f,"/recursos/ImagenesIPO/Postres/fresas.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.136"),2.5f,"/recursos/ImagenesIPO/Postres/gelatina.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.138"),3f,"/recursos/ImagenesIPO/Postres/macedonia_frutas.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.140"),4f,"/recursos/ImagenesIPO/Postres/tarta_queso.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.142"),2f,"/recursos/ImagenesIPO/Postres/yogurt.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.144"),1f,"/recursos/ImagenesIPO/Postres/manzana.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void aniadirBebidas(JPanel panel) {
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.146"),1f,"/recursos/ImagenesIPO/Bebidas/agua.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.148"),1.5f,"/recursos/ImagenesIPO/Bebidas/cc_zero.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.150"),2f,"/recursos/ImagenesIPO/Bebidas/cerveza_sin.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.152"),2f,"/recursos/ImagenesIPO/Bebidas/cerveza.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.154"),1.5f,"/recursos/imagenesIPO/Bebidas/descarga.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.156"),1.5f,"/recursos/ImagenesIPO/Bebidas/fanta_limon.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.158"),1.5f,"/recursos/ImagenesIPO/Bebidas/fanta_naranja.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.160"),2f,"/recursos/ImagenesIPO/Bebidas/sprite.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void aniadirComplementos(JPanel panel) {
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.162"),2f,"/recursos/ImagenesIPO/Complementos/alitas_pollo.jpg")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.164"),2f,"/recursos/ImagenesIPO/Complementos/aros_cebolla.jpg")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.166"),2f,"/recursos/ImagenesIPO/Complementos/bolitas_pollo.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.168"),2f,"/recursos/ImagenesIPO/Complementos/nuggets.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.170"),1f,"/recursos/ImagenesIPO/Complementos/patatas_fritas.jfif")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.172"),1.5f,"/recursos/ImagenesIPO/Complementos/patatas_delux.png")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(new Item(this,Messages.getString("VentanaPrincipal.174"),0.5f,"/recursos/ImagenesIPO/Complementos/ketchup.jpg")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void ajustarImagenesGrid(JPanel panel) {
		int ancho = panel.getComponent(0).getMinimumSize().width;
		int alto = panel.getComponent(0).getMinimumSize().height;
		for (Component c : panel.getComponents()) {
			((Item) c).ajustarImagenItem(ancho+100, alto+100);;
		}
	}
	
	private ImageIcon ajustarImagenLabel(String urlImagen, JLabel label) {
		BufferedImage img = null; //Creamos una Buffered Image
		try {
			img = ImageIO.read(getClass().getResource(urlImagen));
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

	public void aniadirComanda(String nombreItem, float precioItem) {
		boolean exist = false;
		float total = 0;

		for (Component c : pnlListaProductos.getComponents()) {
			if (((Comanda) c).getLblitem().getText().equals(nombreItem)) {
				exist = true;
				((Comanda) c).aumentarCantidad();
			}
		}
		
		for (Component c : pnlListaProductosPedido.getComponents()) {
			if (((Comanda) c).getLblitem().getText().equals(nombreItem)) {
				exist = true;
				((Comanda) c).aumentarCantidad();
			}
		}
		
		if (!exist) {
			pnlListaProductos.add(new Comanda(nombreItem, precioItem));
			pnlListaProductos.repaint();
			pnlListaProductos.revalidate();	
			
			pnlListaProductosPedido.add(new Comanda(nombreItem, precioItem));
			pnlListaProductosPedido.repaint();
			pnlListaProductosPedido.revalidate();	
		}
		
		for (Component c : pnlListaProductos.getComponents()) {
			total += ((Comanda) c).getTotalItem();
		}
		
		total = (float) (Math.round(total * 100.0) / 100.0);
		lblTotalPrecio.setText(total+" €    "); //$NON-NLS-1$
		lblTotalPedidoX.setText(total+" €    "); //$NON-NLS-1$
	}


	private class BtnAjustesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class Btn_Resaltar implements ActionListener {
		private JButton btn;
		
		public Btn_Resaltar(JButton btnNewButton_4) {
			this.btn = btnNewButton_4;
		}

		public void actionPerformed(ActionEvent e) {
			btnNewButton_4.setBackground(new Color(255, 255, 255));
			btnNewButton_5.setBackground(new Color(255, 255, 255));
			btnNewButton_6.setBackground(new Color(255, 255, 255));
			
			btn.setBackground(new Color(130, 255, 130));
		}
	}

	private class Btn_Resaltar2 implements ActionListener {
		private JButton btn;
		
		public Btn_Resaltar2(JButton btnNewButton) {
			this.btn = btnNewButton;
		}

		public void actionPerformed(ActionEvent e) {
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_2.setBackground(new Color(255, 255, 255));
			btnNewButton_3.setBackground(new Color(255, 255, 255));
			
			btn.setBackground(new Color(130, 255, 130));
		}
	}
	
	private class RdbtnNewRadioButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtTarjeta.enable();
			txtTarjeta.grabFocus();
		}
	}
	private class RdbtnNewRadioButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtTarjeta.setText(""); //$NON-NLS-1$
			txtTarjeta.disable();
		}
	}
	private class BtnIdiomasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
	        final ImageIcon[] icons = new ImageIcon[2];
	        icons[0] = new ImageIcon(VentanaPrincipal.class.getResource("/recursos/Banderas/es.png"));
	        icons[1] = new ImageIcon(VentanaPrincipal.class.getResource("/recursos/Banderas/en.png"));
	        
	        int x = JOptionPane.showOptionDialog(null, null, "Idiomas/Languajes", JOptionPane.DEFAULT_OPTION,
	        										JOptionPane.PLAIN_MESSAGE, null, icons, icons[0]);
	        
			if(x == 1) {
				Messages.setIdioma("ingles");
				VentanaPrincipal ventana = new VentanaPrincipal();
				frame.dispose();
			}else if(x == 0) {
				Messages.setIdioma("es");
				VentanaPrincipal ventana = new VentanaPrincipal();
				frame.dispose();
			}
		}
	}

}
