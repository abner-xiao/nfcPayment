package database;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Database_Functions {
	public void addUser(int rfid, int montant, String userfirstname, String userlastname){
		//todO	
	}
	public void deleteUser (int rfid){
		//todo
	}
	public String[] getUserFromRfid(int rfid){
		String[] str = new String[3];
		str[0] = "UserFirstname";
		str[1] = "UserLastname";
		str[2] = "montant";
		return str;
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
	public ArrayList<String[]> getProvision (Database database){

		// return toute la  base provision sous la forme [["Boisson 1","prix"],["Boisson 1","prix"],...,["Boisson N","prix"]]
		return null;
	}
	public void addSale (Database database, Timestamp time, int terminal, int id_provision, int id_user){
		//todo
	}
}
