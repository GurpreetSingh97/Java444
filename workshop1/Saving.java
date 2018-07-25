


package workshop;

public class Saving extends Account {

	void withdraw(double amount) {
		Saving a = new Saving();
		if (amount <= getBalance()) {
			super.withdraw(amount);
		} else {
			System.out.println("Saving Account cannot be overdrawn");
		}

	}

	public String toString() {
		String balanceVar = "The balance after transaction is: $" + getBalance() + "\n";
		String IdVar = "The id is: " + getId() + "\n";
		String dateVar = "The date of creation is: " + getDateCreated() + "\n";

		return balanceVar + IdVar + dateVar;
	}

	public static void main(String[] args) {
		Saving obj = new Saving();
		obj.modifyBalance(100);
		obj.withdraw(105);
		System.out.println(obj);
	}

}
