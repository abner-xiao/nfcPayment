package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;


public class Gui {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public Gui() {
		try {
			Gui window = new Gui();
			window.open();
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
		
		Composite composite = new Composite(shell, SWT.NONE);
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

	}

}
