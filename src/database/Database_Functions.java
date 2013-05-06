package database;

import java.sql.Timestamp;

public class Database_Functions {
	public void addUser(Database database,int rfid, int montant, String userfirstname, String userlastname){
		//todO	
	}
	public void deleteUser (Database database, int rfid){
		//todo
	}
	public void addAmount (Database database, int rfid, int money){
		// Dans le cas ou un utilisateur crédite son compte USERS.amount = USERS.amount + money
	}
	public void soustractAmount (Database database, int rfid, int money){
		// Dans le cas ou un utilisateur débite son compte USERS.amount = USERS.amount - money
	}
	public int getAmount (Database database, int rfid){
		// return le crédit du compte (utilisé pour vérifié si un utilisateur a assez pour payer)
		return 0;
	}
	public int getPrice (Database database, int id_provision){
		return 0;
	}
	public void addSale (Database database, Timestamp time, int terminal, int id_provision, int id_user){
		//todo
	}
}
