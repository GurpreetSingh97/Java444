




/*
 * BorrowerBank class handle the banks that owe money
 */
public class BorrowerBank {
	private int id;
	private double amountBorrowed;

	public void setId(int tempId) {
		id = tempId;
	}

	public void setAmountBorrowed(double tempAmountBorrowed) {
		amountBorrowed = tempAmountBorrowed;
	}

	public int getId() {
		return id;
	}

	public double getAmountBorrowed() {
		return amountBorrowed;
	}

}
