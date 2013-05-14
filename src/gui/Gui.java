package gui;

import java.util.ArrayList;
import java.util.Vector;

import nfc.PCSC;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

import database.Database_Functions;



public class Gui {

	protected Shell shell;
	private Text txtFirstnametextfield;
	private Text txtLastnametextfield;
	private Text txtMontant;
	private Text txtRfid;
	private Text txtSubTotal;
	private Text txtTotal;
	private Text text;
	private Text text_1;
	private Text text_2;
	private PCSC pcsc;
	private Database_Functions database;
	/**
	 * Launch the application.
	 * @param args
	 */
	public Gui(PCSC pcsc) {
		this.pcsc = pcsc;
		this.database = new Database_Functions();
		
		try {
			this.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		final Display display = Display.getDefault();
		createShell("home",display);

	}

	private void createShell(String name, Display display) {
		final Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application " + name);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		final Composite composite = new Composite(shell, SWT.NONE);

		composite.setLayout(new FormLayout());
		createContents(composite,shell);
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		
	}

 void createContents(final Composite composite, final Shell shell1) {

		

			final FormData show_home = new FormData();
			show_home.top = new FormAttachment(0, 10);
			show_home.left = new FormAttachment(0, 10);
			final FormData hide_home = new FormData();
			hide_home.top = new FormAttachment(0);
			hide_home.left = new FormAttachment(0);
			hide_home.height = 0;
			hide_home.width = 0;
			
			final Composite home_composite = new Composite(composite, SWT.NONE);
			home_composite.setLayout(new GridLayout(2, false));
			home_composite.setLayoutData(show_home);
			
			Button btnAdd = new Button(home_composite, SWT.CENTER);
			btnAdd.setText("ADD");
			
			Button btnPay = new Button(home_composite, SWT.NONE);
			btnPay.setText("PAY");
			
			Button btnCheck = new Button(home_composite, SWT.NONE);

			btnCheck.setText("CHECK");
			
			Button btnStock = new Button(home_composite, SWT.NONE);
			btnStock.setText("STOCK");
			

///////////////////////////////////////////////////////////////////////:::			
			final FormData show_add = new FormData();
			show_add.top = new FormAttachment(0, 10);
			show_add.left = new FormAttachment(0, 10);
			final FormData hide_add = new FormData();
			hide_add.top = new FormAttachment(0);
			hide_add.left = new FormAttachment(0);
			hide_add.height = 0;
			hide_add.width = 0;
			
			final Composite add_new_user_composite = new Composite(composite, SWT.NONE);
			add_new_user_composite.setLayout(new GridLayout(3, false));
			add_new_user_composite.setLayoutData(hide_add);
			
			Label lblFirstName = new Label(add_new_user_composite, SWT.NONE);
			lblFirstName.setSize(74, 17);
			lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblFirstName.setText("First Name");
			
			txtFirstnametextfield = new Text(add_new_user_composite, SWT.BORDER);
			txtFirstnametextfield.setText("first_name_text_field");
			txtFirstnametextfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(add_new_user_composite, SWT.NONE);
			
			Label lblLastName = new Label(add_new_user_composite, SWT.NONE);
			lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblLastName.setText("Last Name");
			
			txtLastnametextfield = new Text(add_new_user_composite, SWT.BORDER);
			txtLastnametextfield.setText("Last_name_text_field");
			txtLastnametextfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(add_new_user_composite, SWT.NONE);
			
			Label lblMontant = new Label(add_new_user_composite, SWT.NONE);
			lblMontant.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblMontant.setText("Montant");
			
			txtMontant = new Text(add_new_user_composite, SWT.BORDER);
			txtMontant.setText("Montant");
			txtMontant.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(add_new_user_composite, SWT.NONE);
			
			Label lblId = new Label(add_new_user_composite, SWT.NONE);
			lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblId.setText("id");
			
			txtRfid = new Text(add_new_user_composite, SWT.BORDER);
			txtRfid.setText("rfid");
			txtRfid.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Button btnGetRfid = new Button(add_new_user_composite, SWT.NONE);
			btnGetRfid.setText("Get RFID");
			
			Button btnGetBackHome = new Button(add_new_user_composite, SWT.NONE);
			btnGetBackHome.setText("<< Back");
			
			Button btnCreateUser = new Button(add_new_user_composite, SWT.NONE);
			btnCreateUser.setText("Create User");
			
			new Label(add_new_user_composite, SWT.NONE);
			//////////////////////////////////////////////////////////////////////////////////				
			final FormData show_pay = new FormData();
			show_pay.top = new FormAttachment(0, 10);
			show_pay.left = new FormAttachment(0, 10);
			final FormData hide_pay = new FormData();
			hide_pay.top = new FormAttachment(0);
			hide_pay.left = new FormAttachment(0);
			hide_pay.height = 0;
			hide_pay.width = 0;
	
			final Composite pay_composite = new Composite(composite, SWT.NONE);
			pay_composite.setLayout(new GridLayout(4, false));
			pay_composite.setLayoutData(hide_pay);
			/*
			Label lblBoisson = new Label(pay_composite, SWT.NONE);
			lblBoisson.setText("Boisson");
			
			Label lblPrix = new Label(pay_composite, SWT.NONE);
			lblPrix.setText("Prix");
			
			@SuppressWarnings("unused")
			Spinner spinner = new Spinner(pay_composite, SWT.BORDER);

			
			txtSubTotal = new Text(pay_composite, SWT.BORDER);
			txtSubTotal.setText("total");
			txtSubTotal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(pay_composite, SWT.NONE);
			new Label(pay_composite, SWT.NONE);
			new Label(pay_composite, SWT.NONE);
			
			Label lblBigtotal = new Label(pay_composite, SWT.NONE);
			lblBigtotal.setText("BigTotal");
			txtTotal = new Text(pay_composite, SWT.BORDER);
			txtTotal.setText("total");
			txtTotal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(pay_composite, SWT.NONE);*/
/////////////////////////////////////////////////////////////////////				
			final FormData show_check = new FormData();
			show_check.top = new FormAttachment(0, 10);
			show_check.left = new FormAttachment(0, 10);
			final FormData hide_check = new FormData();
			hide_check.top = new FormAttachment(0);
			hide_check.left = new FormAttachment(0);
			hide_check.height = 0;
			hide_check.width = 0;
	
			final Composite check_composite = new Composite(composite, SWT.NONE);
			check_composite.setLayout(new GridLayout(2, false));
			check_composite.setLayoutData(hide_check);

			Label label = new Label(check_composite, SWT.NONE);
			label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label.setText("First Name");
			
			text = new Text(check_composite, SWT.BORDER);
			text.setText("first_name_text_field");
			text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_1 = new Label(check_composite, SWT.NONE);
			label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_1.setText("Last Name");
			
			text_2 = new Text(check_composite, SWT.BORDER);
			text_2.setText("Last_name_text_field");
			text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_2 = new Label(check_composite, SWT.NONE);
			label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_2.setText("Montant");
			
			text_1 = new Text(check_composite, SWT.BORDER);
			text_1.setText("Montant");
			text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Button btnGetBackHome_1 = new Button(check_composite, SWT.NONE);
			btnGetBackHome_1.setText("<< Back");
			new Label(check_composite, SWT.NONE);
			
			new Label(add_new_user_composite, SWT.NONE);
			new Label(add_new_user_composite, SWT.NONE);
			new Label(add_new_user_composite, SWT.NONE);
//////////////////////////////////////////////////////////////////////			
			final FormData show_stock = new FormData();
			show_stock.top = new FormAttachment(0, 10);
			show_stock.left = new FormAttachment(0, 10);
			final FormData hide_stock = new FormData();
			hide_stock.top = new FormAttachment(0);
			hide_stock.left = new FormAttachment(0);
			hide_stock.height = 0;
			hide_stock.width = 0;
		
			final Composite stock_composite = new Composite(composite, SWT.NONE);
			stock_composite.setLayoutData(hide_stock);
			
		
			///////////////////////////////////////////////////////////////
			////                        EVENT HANDLER                   ///
			///////////////////////////////////////////////////////////////
			
			/////For home /////
			btnAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					home_composite.setLayoutData(hide_home);
					add_new_user_composite.setLayoutData(show_add);
					shell1.pack();
					
					
				}
			});
			btnPay.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					Control[] children = pay_composite.getChildren();
					int len = children.length;
					for (int i=len-1; i>0;i--){
						children[i].dispose();
					}
					createPayContent(pay_composite);
					home_composite.setLayoutData(hide_home);
					pay_composite.setLayoutData(show_pay);
					shell1.pack();

				}
			});
			btnCheck.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					int rfid = pcsc.getUid();
					Vector<String> user = database.getUserFromRfid(String.valueOf(rfid));
					System.out.println(user.toString());
					text.setText(user.get(0));
					text_2.setText(user.get(1));
					text_1.setText(user.get(2));
				
					
					home_composite.setLayoutData(hide_home);
					check_composite.setLayoutData(show_check);
					shell1.pack();

				}
			});
			btnStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					home_composite.setLayoutData(hide_home);
					stock_composite.setLayoutData(show_stock);
					shell1.pack();

				}
			});
			
			
			/////For add_user /////
			
			btnCreateUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					//Je recupere les infos et j'utilise la fonction pour ajouter a la base
					
					String firstname = txtFirstnametextfield.getText();
					String lastname = txtLastnametextfield.getText();
					float montant = Float.parseFloat(txtMontant.getText());
					String rfid = txtRfid.getText();
					
					if (database.addUser(rfid,montant,firstname,lastname)){
						
						txtFirstnametextfield.setText("");
						txtLastnametextfield.setText("");
						txtMontant.setText("0");
						txtRfid.setText("");
						home_composite.setLayoutData(show_home);
						stock_composite.setLayoutData(hide_add);
						shell1.pack();
					}else{
						System.out.println("Not possible to add a user now!! Try again later.");
					}
					
					

				}
			});
			
			btnGetBackHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					System.out.println("Je suis Ici");
					txtFirstnametextfield.setText("");
					txtLastnametextfield.setText("");
					txtMontant.setText("0");
					txtRfid.setText("");
					System.out.println("Je suis Ici");
					home_composite.setLayoutData(show_home);
					add_new_user_composite.setLayoutData(hide_add);
					shell1.pack();
				}
			});
			
			btnGetRfid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					int rfid = pcsc.getUid();
					txtRfid.setText(String.valueOf(rfid));
				}
			});
			
			
			/////////For Check ////////
			btnGetBackHome_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					text.setText("");
					text_2.setText("");
					text_1.setText("0");
					home_composite.setLayoutData(show_home);
					check_composite.setLayoutData(hide_check);
					shell1.pack();
				}
			});

	}

	protected ArrayList<Object[]> createPayContent(final Composite pay_composite) {
	// TODO Auto-generated method stub
		//1 Acces database pour recuperer le tableau
		ArrayList<String[]> data = database.getProvision();
		// 2 pour chaque tableau
		int datasize = data.size();
		final ArrayList<Object[]> list = new ArrayList<Object[]>();

		for (int i=0;i<datasize;i++){
			System.out.println("ar : "+i);
			String[] provision = data.get(i); //provision[0] : boisson ; provision[1]: price;
			Object[] tab =  new Object[4];
			
			tab[0] = new Label(pay_composite, SWT.NONE);
			((Label) tab[0]).setText(provision[0]);
			
			tab[1] = new Label(pay_composite, SWT.NONE);
			((Label) tab[1]).setText(provision[1]);
			
			tab[2] = new Spinner(pay_composite, SWT.BORDER);
			
			tab[3] = new Text(pay_composite, SWT.BORDER);
			((Text) tab[3]).setText("0");
			list.add(tab);	
			
		}
		Object[] tab =  new Object[4];
		
		tab[0] = new Label(pay_composite, SWT.NONE);
		tab[1] = new Button(pay_composite, SWT.NONE);
		((Button) tab[1]).setText("PAY");
		tab[2] =  new Label(pay_composite, SWT.NONE);
		((Label) tab[2]).setText("Total");
		tab[3] = new Text(pay_composite, SWT.BORDER);
		((Text) tab[3]).setText("0");
		list.add(tab);
		
		//// Create handlers for all the array list
		final int listsize = list.size();
		for (int i = listsize-2;i>=0;i--){
			final Object[] tab1 = list.get(i);
			((Spinner) tab1[2]).addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					int number = Integer.parseInt(((Spinner)tab1[2]).getText());
					float price = Float.parseFloat(((Label)tab1[1]).getText());
					float subtotal = (float)number * price;
					((Text) tab1[3]).setText(String.valueOf(subtotal));
					float total=0;
					for (int j = listsize-2;j>=0;j--){
						total = total + Float.parseFloat(((Text)list.get(j)[3]).getText());
					}
					((Text)list.get(listsize-1)[3]).setText(String.valueOf(total));			
					
				}
			});
			
		}
		((Button) list.get(listsize-1)[1]).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Récuperer le rfid, vérifier si le mec a assez, soustraire au compte, ajouter un log dans la base.
				
				//rfid
				int rfid = pcsc.getUid();
				//Amount on the user account
				float amount = database.getAmount(String.valueOf(rfid));
				//Total à payer
				float total =  Float.parseFloat(((Text) list.get(listsize-1)[3]).getText());
				System.out.println("total : "+ total);
				System.out.println("amount : "+amount);
				
				if (amount>=total && database.soustractAmount(String.valueOf(rfid), total)){
					System.out.println("Payment OK!");
					//add log
					
				}else{
					System.out.println("You don't have enough money");
					return;
				}
			}
		});
		
		return list;	
}

	/**
	 * Create contents of the window.
	
	protected void createContents() {

		
		menu.setVisible(true);
		hide_or_show(add_new_user_composite,true);
		hide_or_show(pay_composite,true);
		hide_or_show(check_composite,true);
		hide_or_show(stock_composite,true);

		

		
	} */

	public void show(Composite composite, Composite toshow){
		org.eclipse.swt.widgets.Control[] children = composite.getChildren();
		for (int i = 0; i < children.length; i++){
			children[i].setVisible(false);
		}
		hide_or_show(toshow,false);
	}
	public void hide_or_show(Composite compo, boolean hide){
		org.eclipse.swt.widgets.Control[] children = compo.getChildren();
		for (int i = 0; i < children.length; i++){
			System.out.println(i);
			if (hide){
				children[i].setVisible(false);
			}else{
				children[i].setVisible(true);
			}
		}
	}
}
