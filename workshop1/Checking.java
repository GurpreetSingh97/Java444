

package workshop;


public class Checking extends Account {
	public double overDraftLimit;

	Checking() {
		overDraftLimit = -1000;
	}

	Checking(double amount) {
		overDraftLimit = -amount;
	}

	void withdraw(double amount) {
		if ((getBalance() - amount) >= overDraftLimit) {
			super.withdraw(amount);
		} else {
			System.out.println("Over Draft Limit Exceeded!!");
		}

	}

	public String toString() {
		String overdraft = "The overdraft limit is: $" + overDraftLimit + "\n";
		String balanceVar = "The balance after transaction is $:" + getBalance() + "\n";
		String idVar = "The id is :" + getId() + "\n";
		String dateString = "The Date on which account was created is: " + getDateCreated();
		return overdraft + balanceVar + idVar + dateString;
	}

	public static void main(String[] args) {
		Checking obj = new Checking(1000);
		obj.modifyBalance(100);
		obj.withdraw(900);

		System.out.println(obj);
	}
}
