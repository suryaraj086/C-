package atm;

public class Transaction {
	int transactionNumber;
	String description;
	TransactionType type;
	long amount;
	long closingBalance;

	public Transaction(int transactionNum, String descri, TransactionType type, long amounts, long balance) {
		transactionNumber = transactionNum;
		description = descri;
		this.type = type;
		amount = amounts;
		closingBalance = balance;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(long closingBalance) {
		this.closingBalance = closingBalance;
	}

	@Override
	public String toString() {
		return "      " + transactionNumber + "     " + description + "      " + type + "     " + amount + "          "
				+ closingBalance + "\n";
	}

}
