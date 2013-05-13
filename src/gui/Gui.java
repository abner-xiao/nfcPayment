package gui;

import java.util.ResourceBundle.Control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.GestureListener;
import org.eclipse.swt.events.GestureEvent;
import org.eclipse.swt.events.MouseTrackAdapter;



public class Gui {

	protected Shell shell;
	private Text txtFirstnametextfield;
	private Text txtLastnametextfield;
	private Text txtMontant;
	private Text txtRfid;

	/**
	 * Launch the application.
	 * @param args
	 */
	public Gui() {
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
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		final Composite composite = new Composite(composite_1, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		Button btnAdd = new Button(composite, SWT.CENTER);

		GridData gd_btnAdd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnAdd.widthHint = 56;
		btnAdd.setLayoutData(gd_btnAdd);
		btnAdd.setText("ADD");
		
		Button btnPay = new Button(composite, SWT.CENTER);

		btnPay.setText("PAY");
		
		Button btnCheck = new Button(composite, SWT.NONE);
		btnCheck.setText("CHECK");
		
		Button btnStock = new Button(composite, SWT.NONE);
		btnStock.setText("STOCK");
		
		final Composite add_new_user_composite = new Composite(composite_1, SWT.NONE);
		add_new_user_composite.setLayoutData(new RowData(300, 175));
		add_new_user_composite.setLayout(new GridLayout(3, false));
		
		Label lblFirstName = new Label(add_new_user_composite, SWT.NONE);
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
		new Label(add_new_user_composite, SWT.NONE);
		
		Button btnCreateUser = new Button(add_new_user_composite, SWT.NONE);
		btnCreateUser.setText("Create User");
		new Label(add_new_user_composite, SWT.NONE);
		
		final Composite pay_composite = new Composite(composite_1, SWT.NONE);
		pay_composite.setLayoutData(new RowData(183, 142));
		pay_composite.setLayout(new GridLayout(2, false));
		
		final Composite check_composite = new Composite(composite_1, SWT.NONE);
		
		final Composite stock_composite = new Composite(composite_1, SWT.NONE);
		
		hide_or_show(add_new_user_composite,true);
		hide_or_show(pay_composite,true);
		hide_or_show(check_composite,true);
		hide_or_show(stock_composite,true);
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				hide_or_show(composite,true);
				hide_or_show(add_new_user_composite,false);
				hide_or_show(pay_composite,true);
				hide_or_show(check_composite,true);
				hide_or_show(stock_composite,true);
			}
		});
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				hide_or_show(composite,true);
				hide_or_show(add_new_user_composite,true);
				hide_or_show(pay_composite,false);
				hide_or_show(check_composite,true);
				hide_or_show(stock_composite,true);
			}
		});
		
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