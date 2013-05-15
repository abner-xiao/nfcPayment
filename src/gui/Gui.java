package gui;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import nfc.PCSC;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.graphics.Rectangle;

import database.Database_Functions;



public class Gui {

	protected Shell shell;
	private PCSC pcsc;
	private Database_Functions database;
	private Composite home_composite;
	private Composite add_new_user_composite;
	private Composite pay_composite;
	private Composite check_composite;
	private Composite stock_composite;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public Gui() {
		this.pcsc = new PCSC();
		pcsc.start();
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
		shell = new Shell();
		shell.setSize(400, 300);
		//shell.setMinimumSize(400, 300);
		shell.setText("SWT Application " + name);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		final Composite composite = new Composite(shell, SWT.None);

		composite.setLayout(new FormLayout());
		createContents(composite);

		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    shell.setLocation(x, y);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		
		
	}

	void createContents(final Composite composite) {

		
			
			home_composite = new Composite(composite, SWT.NONE);
			home_composite.setLayoutData(getLayoutData("show"));
			home_composite.setLayout(new GridLayout(2, false));
			//home_composite.setLayout(new FormLayout());


			final Button btnAdd = new Button(home_composite, SWT.PUSH);
			btnAdd.setText("ADD");		

			
			final Button btnPay = new Button(home_composite, SWT.PUSH);
			btnPay.setText("PAY");
			
			final Button btnCheck = new Button(home_composite, SWT.PUSH);

			btnCheck.setText("CHECK");
			
			final Button btnStock = new Button(home_composite, SWT.PUSH);
			btnStock.setText("STOCK");
			
			/*			FormData data = new FormData();
			data.top = new FormAttachment(0, 50, SWT.CENTER);
			data.left = new FormAttachment(0, 50, SWT.CENTER);
			btnAdd.setLayoutData(data);
			
			data = new FormData();
			data.left = new FormAttachment(btnAdd, 0, SWT.CENTER);
			data.bottom = new FormAttachment(btnStock, 0, SWT.CENTER);
			btnPay.setLayoutData(data);
			
			data = new FormData();
			data.right = new FormAttachment(btnStock, 0, SWT.CENTER);
			data.top = new FormAttachment(btnAdd, 0, SWT.CENTER);
			btnCheck.setLayoutData(data);
			
			data = new FormData();
			data.left = new FormAttachment(btnCheck, 0, SWT.CENTER);
			data.top = new FormAttachment(btnPay, 0, SWT.CENTER);
			btnStock.setLayoutData(data);*/
			

///////////////////////////////////////////////////////////////////////:::			

			add_new_user_composite = new Composite(composite, SWT.NONE);
			add_new_user_composite.setLayout(new GridLayout(3, false));
			add_new_user_composite.setLayoutData(getLayoutData("hide"));
			
			Label lblFirstName = new Label(add_new_user_composite, SWT.NONE);
			//lblFirstName.setSize(74, 17);
			lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblFirstName.setText("First Name");
			
			final Text txtFirstnametextfield = new Text(add_new_user_composite, SWT.BORDER);
			txtFirstnametextfield.setText("first_name_text_field");
			txtFirstnametextfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(add_new_user_composite, SWT.NONE);
			
			Label lblLastName = new Label(add_new_user_composite, SWT.NONE);
			lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblLastName.setText("Last Name");
			
			final Text txtLastnametextfield = new Text(add_new_user_composite, SWT.BORDER);
			txtLastnametextfield.setText("Last_name_text_field");
			txtLastnametextfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(add_new_user_composite, SWT.NONE);
			
			Label lblMontant = new Label(add_new_user_composite, SWT.NONE);
			lblMontant.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblMontant.setText("Montant");
			
			final Text txtMontant = new Text(add_new_user_composite, SWT.BORDER);
			txtMontant.setText("Montant");
			txtMontant.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(add_new_user_composite, SWT.NONE);
			
			Label lblId = new Label(add_new_user_composite, SWT.NONE);
			lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblId.setText("id");
			
			final Text txtRfid = new Text(add_new_user_composite, SWT.BORDER);
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
	
			pay_composite = new Composite(composite, SWT.NONE);
			pay_composite.setLayout(new GridLayout(4, false));
			pay_composite.setLayoutData(getLayoutData("hide"));
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
	
			check_composite = new Composite(composite, SWT.NONE);
			check_composite.setLayout(new GridLayout(2, false));
			check_composite.setLayoutData(getLayoutData("hide"));

			Label label = new Label(check_composite, SWT.NONE);
			label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label.setText("First Name");
			
			final Text text = new Text(check_composite, SWT.BORDER);
			text.setText("first_name_text_field");
			text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_1 = new Label(check_composite, SWT.NONE);
			label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_1.setText("Last Name");
			
			final Text text_2 = new Text(check_composite, SWT.BORDER);
			text_2.setText("Last_name_text_field");
			text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_2 = new Label(check_composite, SWT.NONE);
			label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_2.setText("Montant");
			
			final Text text_1 = new Text(check_composite, SWT.BORDER);
			text_1.setText("Montant");
			text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Button btnGetBackHome_1 = new Button(check_composite, SWT.NONE);
			btnGetBackHome_1.setText("<< Back");
			new Label(check_composite, SWT.NONE);
			
			new Label(add_new_user_composite, SWT.NONE);
			new Label(add_new_user_composite, SWT.NONE);
			new Label(add_new_user_composite, SWT.NONE);
//////////////////////////////////////////////////////////////////////			
		
			stock_composite = new Composite(composite, SWT.NONE);
			stock_composite.setLayoutData(getLayoutData("hide"));
			
			///////////////////////////////////////////////////////////////
			////                        EVENT HANDLER                   ///
			///////////////////////////////////////////////////////////////
			
			/////For home /////
			btnAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					home_composite.setLayoutData(getLayoutData("hide"));
					add_new_user_composite.setLayoutData(getLayoutData("show"));
					shell.pack();
					shell.setSize(400, 300);
					
					
				}
			});
			btnPay.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					Control[] children = pay_composite.getChildren();
					int len = children.length;
					for (int i=len-1; i>=0;i--){
						children[i].dispose();
					}
					createPayContent();
					home_composite.setLayoutData(getLayoutData("hide"));
					pay_composite.setLayoutData(getLayoutData("show"));
					shell.pack();
					shell.setSize(400, 300);

				}
			});
			btnCheck.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					String rfid = pcsc.getUid();
					Vector<String> user = database.getUserFromRfid(rfid);
					System.out.println(user.toString());
					if (user.size()>0){
					text.setText(user.get(0));
					text_2.setText(user.get(1));
					text_1.setText(user.get(2));
					}else{
						text.setText("Unknown User");
						text_2.setText("Unknown User");
						text_1.setText("Unknown User");
					}
					
					home_composite.setLayoutData(getLayoutData("hide"));
					check_composite.setLayoutData(getLayoutData("show"));
					shell.pack();
					shell.setSize(400, 300);

				}
			});
			btnStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					home_composite.setLayoutData(getLayoutData("hide"));
					stock_composite.setLayoutData(getLayoutData("show"));
					shell.pack();
					shell.setSize(400, 300);

				}
			});
			
			
			/////For add_user /////
			txtMontant.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent arg0) {
					try{
						Float.parseFloat(txtMontant.getText());
					}catch (Exception e){
						System.out.println("please enter a valid amount");
						txtMontant.setText("invalid amount");
						txtMontant.setFocus();
					}
				}

				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					txtMontant.setText("0");
					
				}
				
			});
			
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
						home_composite.setLayoutData(getLayoutData("show"));
						stock_composite.setLayoutData(getLayoutData("hide"));
						shell.pack();
						shell.setSize(400, 300);
					}else{
						System.out.println("Not possible to add a user now!! Try again later.");
					}
					
					

				}
			});
			
			btnGetBackHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					txtFirstnametextfield.setText("");
					txtLastnametextfield.setText("");
					txtMontant.setText("0");
					txtRfid.setText("");
					home_composite.setLayoutData(getLayoutData("show"));
					add_new_user_composite.setLayoutData(getLayoutData("hide"));
					shell.pack();
					shell.setSize(400, 300);
				}
			});
			
			btnGetRfid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					String rfid = pcsc.getUid();
					System.out.println("UID from GUI = "+pcsc.getUid());
					if (rfid == null){
						txtRfid.setText("No UID detected");
					}else{
						txtRfid.setText(rfid);
					}
				}
			});
			
			
			/////////For Check ////////
			btnGetBackHome_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					text.setText("");
					text_2.setText("");
					text_1.setText("0");
					home_composite.setLayoutData(getLayoutData("show"));
					check_composite.setLayoutData(getLayoutData("hide"));
					shell.pack();
					shell.setSize(400, 300);
				}
			});

	}
	
	public FormData getLayoutData(String layout){
		if (layout == "show"){
			FormData show_home = new FormData();
			show_home.top = new FormAttachment(0, 10);
			show_home.left = new FormAttachment(0, 10);
			return show_home;
		}else{
			FormData hide_home = new FormData();
			hide_home.top = new FormAttachment(0);
			hide_home.left = new FormAttachment(0);
			hide_home.height = 0;
			hide_home.width = 0;
			return hide_home;
		}
	}

public ArrayList<Object[]> createPayContent() {
	// TODO Auto-generated method stub
		//1 Acces database pour recuperer le tableau
		ArrayList<String[]> data = database.getProvision();
		// 2 pour chaque tableau
		int datasize = data.size();
		final ArrayList<Object[]> list = new ArrayList<Object[]>();

		for (int i=0;i<datasize;i++){
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
		
		tab[0] =  new Button(pay_composite, SWT.NONE);
		((Button) tab[0]).setText("<< Back");
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
				String rfid = "0";//pcsc.getUid();
				//Amount on the user account
				float amount = database.getAmount(rfid);
				//Total à payer
				float total =  Float.parseFloat(((Text) list.get(listsize-1)[3]).getText());
				System.out.println("total : "+ total);
				System.out.println("amount : "+amount);
				
				if (amount>=total && database.soustractAmount(rfid, total)){
					System.out.println("Payment OK!");
					//add log
					Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime ());
					//pour chaque boisson
					for (int k = listsize-2;k>=0;k--){
						// si la quantité n'est pas nulle
						if (((Spinner)list.get(k)[2]).getText()!="0"){
							//on recupere la quantité
							int quantity = Integer.parseInt(((Spinner)list.get(k)[2]).getText());
							//on recupere la boisson
							String boisson = ((Label)list.get(k)[0]).getText();
							// on recupere l'id de la boisson
							int id_provision = database.getProvisonId(boisson);
							
							database.addSale(time, 1, id_provision, quantity,rfid);
							
						}
					}
					home_composite.setLayoutData(getLayoutData("show"));
					pay_composite.setLayoutData(getLayoutData("hide"));
					shell.pack();
					shell.setSize(400, 300);
				}else{
					System.out.println("You don't have enough money");
					//On remet tout a 0
					
					return;
				}
			}

		});
		((Button) list.get(listsize-1)[0]).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				home_composite.setLayoutData(getLayoutData("show"));
				pay_composite.setLayoutData(getLayoutData("hide"));
				shell.pack();
				shell.setSize(400, 300);
			}
		});
		
		return list;	
}	


}
