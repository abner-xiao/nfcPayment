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
		shell.setMinimumSize(400, 300);
		shell.setText("SWT Application " + name);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		createContents("home");

		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    shell.setLocation(x, y);
	    
		shell.open();
		//shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		
		
	}

	void createContents(String content) {
			deleteAllContent(shell);
			if(content=="home"){
				createHomeContent(shell);
			}else if (content=="add"){	
				createAddUserContent(shell);
			}else if (content=="pay"){
				createPayContent(shell);
			}else if (content=="check"){
				createCheckContent(shell);
			}else if (content=="stock"){
				//TODO createStockCOntent(shell);
				createStockContent(shell);
			}
			shell.layout();
	}
	


	private void deleteAllContent(Shell shell2) {
		Control[] children = shell2.getChildren();
		int len = children.length;
		for (int i=len-1; i>=0;i--){
			children[i].dispose();
		}
	}
	

	public void createHomeContent(Shell shell1) {
		home_composite = new Composite(shell1, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 20;
		gridLayout.marginHeight = 20;
	    gridLayout.horizontalSpacing = 20;
	    gridLayout.verticalSpacing = 20;
		home_composite.setLayout(gridLayout);

		Button btnAdd = new Button(home_composite, SWT.PUSH);
		btnAdd.setText("ADD");
		btnAdd.setSize(150, 80);
		

		
		Button btnPay = new Button(home_composite, SWT.PUSH);
		btnPay.setText("PAY");
		
		Button btnCheck = new Button(home_composite, SWT.PUSH);

		btnCheck.setText("CHECK");
		
		Button btnStock = new Button(home_composite, SWT.PUSH);
		btnStock.setText("STOCK");
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		btnAdd.setLayoutData(gridData);
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		btnPay.setLayoutData(gridData);
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		btnCheck.setLayoutData(gridData);
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		btnStock.setLayoutData(gridData);
		
		/////Event Handler For home /////
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				createContents("add");		
				
			}
		});
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				createContents("pay");	

			}
		});
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				createContents("check");
			}
		});
		btnStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				createContents("stock");
			}
		});
		
	}
	
	public void createAddUserContent(Shell shell1) {
		add_new_user_composite = new Composite(shell1, SWT.NONE);
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.marginWidth = 20;
		gridLayout.marginHeight = 20;
	    gridLayout.horizontalSpacing = 5;
	    gridLayout.verticalSpacing = 5;
		add_new_user_composite.setLayout(gridLayout);
		
		Label lblFirstName = new Label(add_new_user_composite, SWT.NONE);
		//lblFirstName.setSize(74, 17);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFirstName.setText("First Name");
		lblFirstName.setLayoutData(getGridData());
		
		final Text txtFirstnametextfield = new Text(add_new_user_composite, SWT.BORDER);
		txtFirstnametextfield.setText("first_name_text_field");
		txtFirstnametextfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtFirstnametextfield.setLayoutData(getGridData());
		new Label(add_new_user_composite, SWT.NONE);
		
		Label lblLastName = new Label(add_new_user_composite, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastName.setText("Last Name");
		lblLastName.setLayoutData(getGridData());
		
		final Text txtLastnametextfield = new Text(add_new_user_composite, SWT.BORDER);
		txtLastnametextfield.setText("Last_name_text_field");
		txtLastnametextfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtLastnametextfield.setLayoutData(getGridData());
		new Label(add_new_user_composite, SWT.NONE);
		
		Label lblMontant = new Label(add_new_user_composite, SWT.NONE);
		lblMontant.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMontant.setText("Montant");
		lblMontant.setLayoutData(getGridData());
		
		final Text txtMontant = new Text(add_new_user_composite, SWT.BORDER);
		txtMontant.setText("Montant");
		txtMontant.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtMontant.setLayoutData(getGridData());
		new Label(add_new_user_composite, SWT.NONE);
		
		Label lblId = new Label(add_new_user_composite, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setText("id");
		lblId.setLayoutData(getGridData());
		
		final Text txtRfid = new Text(add_new_user_composite, SWT.BORDER);
		txtRfid.setText("rfid");
		txtRfid.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtRfid.setLayoutData(getGridData());
		
		Button btnGetRfid = new Button(add_new_user_composite, SWT.NONE);
		btnGetRfid.setText("Get RFID");
		btnGetRfid.setLayoutData(getGridData());
		
		Button btnGetBackHome = new Button(add_new_user_composite, SWT.NONE);
		btnGetBackHome.setText("<< Back");
		btnGetBackHome.setLayoutData(getGridData());
		
		Button btnCreateUser = new Button(add_new_user_composite, SWT.NONE);
		btnCreateUser.setText("Create User");
		btnCreateUser.setLayoutData(getGridData());
		
		new Label(add_new_user_composite, SWT.NONE);
		


		
	/////Event Handler add_user /////
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
							createContents("home");
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
						createContents("home");
					}
				});
				
				btnGetRfid.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDoubleClick(MouseEvent e) {
						String rfid = pcsc.getUid();
						if (rfid == null){
							txtRfid.setText("No UID detected");
						}else{
							txtRfid.setText(rfid);
						}
					}
				});
				
	}
	
	
	private GridData getGridData() {
		// TODO Auto-generated method stub
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		return gridData;
	}

	public void createCheckContent(Shell shell1) {
		check_composite = new Composite(shell1, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 20;
		gridLayout.marginHeight = 20;
	    gridLayout.horizontalSpacing = 5;
	    gridLayout.verticalSpacing = 5;
	    check_composite.setLayout(gridLayout);

		Label label = new Label(check_composite, SWT.NONE);
		label.setText("First Name");
		label.setLayoutData(getGridData());
		
		final Text text = new Text(check_composite, SWT.BORDER);
		text.setText("first_name_text_field");
		text.setLayoutData(getGridData());
		
		Label label_1 = new Label(check_composite, SWT.NONE);
		label.setText("Last Name");
		label_1.setLayoutData(getGridData());
		
		final Text text_2 = new Text(check_composite, SWT.BORDER);
		text_2.setLayoutData(getGridData());
		
		Label label_2 = new Label(check_composite, SWT.NONE);
		label.setText("Amount");
		label_2.setLayoutData(getGridData());
		
		final Text text_1 = new Text(check_composite, SWT.BORDER);
		text_1.setLayoutData(getGridData());
		
		Button btnGetBackHome_1 = new Button(check_composite, SWT.NONE);
		btnGetBackHome_1.setText("<< Back");
		btnGetBackHome_1.setLayoutData(getGridData());
		
		new Label(check_composite, SWT.NONE);
		
		String rfid = "6";//pcsc.getUid();
		Vector<String> user = database.getUserFromRfid(rfid);
		System.out.println(user.toString());
		if (user.size()>0){
			text.setText(user.get(1));
			text_2.setText(user.get(2));
			text_1.setText(user.get(0));
		}else{
			text.setText("Unknown User");
			text_2.setText("Unknown User");
			text_1.setText("Unknown User");
		}
		
		/////////Event Handler For Check ////////
		btnGetBackHome_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				createContents("home");
			}
		});
	}
	
	
	public void createPayContent(Shell shell1) {
	// TODO Auto-generated method stub
		//1 Acces database pour recuperer le tableau
		pay_composite = new Composite(shell1, SWT.NONE);
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.marginWidth = 20;
		gridLayout.marginHeight = 20;
	    gridLayout.horizontalSpacing = 5;
	    gridLayout.verticalSpacing = 5;
	    pay_composite.setLayout(gridLayout);
		
	    //affichage de l'user avant
		Vector<String> user = database.getUserFromRfid("6");//pcsc.getUid()); 
		if (user.size()>0){
			String amount = user.get(0);
			String firstname = user.get(1);
			String lastname = user.get(2);

			
			Label uid_label = new Label(pay_composite, SWT.NONE);
			uid_label.setText("6"/*pcsc.getUid()*/);
			Label firstname_label = new Label(pay_composite, SWT.NONE);
			firstname_label.setText(firstname);
			Label lastname_label = new Label(pay_composite, SWT.NONE);
			firstname_label.setText(lastname);
			Label amount_label = new Label(pay_composite, SWT.NONE);
			firstname_label.setText(amount);
			
		}else{
			new Label(pay_composite, SWT.NONE);
			new Label(pay_composite, SWT.NONE);
			new Label(pay_composite, SWT.NONE);
			Button getUID = new Button(pay_composite, SWT.NONE);
			getUID.setText("Get User ID");
			//event Handler
			
	
		}
	    
	    
	    
		ArrayList<String[]> data = database.getProvision();
		// 2 pour chaque tableau
		int datasize = data.size();
		final ArrayList<Object[]> list = new ArrayList<Object[]>();

		for (int i=0;i<datasize;i++){
			String[] provision = data.get(i); //provision[0] : boisson ; provision[1]: price;
			Object[] tab =  new Object[4];
			
			tab[0] = new Label(pay_composite, SWT.NONE);
			((Label) tab[0]).setText(provision[0]);
			((Label) tab[0]).setLayoutData(getGridData());
			
			tab[1] = new Label(pay_composite, SWT.NONE);
			((Label) tab[1]).setText(provision[1]);
			((Label) tab[1]).setLayoutData(getGridData());
			
			tab[2] = new Spinner(pay_composite, SWT.BORDER);
			((Spinner) tab[2]).setLayoutData(getGridData());
			
			tab[3] = new Text(pay_composite, SWT.BORDER);
			((Text) tab[3]).setText("0");
			((Text) tab[3]).setLayoutData(getGridData());
			list.add(tab);	
			
		}
		Object[] tab =  new Object[4];
		
		tab[0] = new Label(pay_composite, SWT.NONE);
		tab[1] = new Label(pay_composite, SWT.NONE);
		
		tab[2] =  new Label(pay_composite, SWT.NONE);
		((Label) tab[2]).setText("Total");
		((Label) tab[2]).setLayoutData(getGridData());
		
		tab[3] = new Text(pay_composite, SWT.BORDER);
		((Text) tab[3]).setText("0");
		((Text) tab[3]).setLayoutData(getGridData());
		list.add(tab);
		//----------------------//
		
		tab =  new Object[4];
		
		tab[0] =  new Button(pay_composite, SWT.NONE);
		((Button) tab[0]).setText("<< Back");
		((Button) tab[0]).setLayoutData(getGridData());
		
		tab[1] = new Button(pay_composite, SWT.NONE);
		((Button) tab[1]).setText("PAY");
		((Button) tab[1]).setLayoutData(getGridData());
		
		tab[2] = new Label(pay_composite, SWT.NONE);
		tab[3] = new Label(pay_composite, SWT.NONE);
		
		list.add(tab);
		
		//// Create handlers for all the array list
		final int listsize = list.size();
		for (int i = listsize-3;i>=0;i--){
			final Object[] tab1 = list.get(i);
			((Spinner) tab1[2]).addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					int number = Integer.parseInt(((Spinner)tab1[2]).getText());
					float price = Float.parseFloat(((Label)tab1[1]).getText());
					float subtotal = (float)number * price;
					((Text) tab1[3]).setText(String.valueOf(subtotal));
					float total=0;
					for (int j = listsize-3;j>=0;j--){
						total = total + Float.parseFloat(((Text)list.get(j)[3]).getText());
					}
					((Text)list.get(listsize-2)[3]).setText(String.valueOf(total));			
					
				}
			});
			
		}
		((Button) list.get(listsize-1)[1]).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Récuperer le rfid, vérifier si le mec a assez, soustraire au compte, ajouter un log dans la base.
				
				//rfid
				String rfid = "6";//pcsc.getUid();
				//Amount on the user account
				float amount = database.getAmount(rfid);
				//Total à payer
				float total =  Float.parseFloat(((Text) list.get(listsize-2)[3]).getText());
				System.out.println("total : "+ total);
				System.out.println("amount : "+amount);
				
				if (amount>=total && database.soustractAmount(rfid, total)){
					System.out.println("Payment OK!");
					//add log
					Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime ());
					//pour chaque boisson
					for (int k = listsize-3;k>=0;k--){
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
					createContents("home");
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
				createContents("home");
			}
		});
}	

	private void createStockContent(Shell shell2) {
	stock_composite = new Composite(shell2, SWT.NONE);
	
}

}
