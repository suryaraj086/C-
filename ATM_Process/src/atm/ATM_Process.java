package atm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM_Process {

	Map<Long, CustomerDetails> map = new HashMap<>();
	Map<Long, List<Transaction>> transaction = new HashMap<>();
	int transactionNumber;

	public ATM_Process() {
		CustomerDetails cus = new CustomerDetails();
		cus.setAccNo(1);
		cus.setAccountBalance(5000);
		cus.setAccountHolder("Surya");
		cus.setPinNumber(1234);
		long val = 1;
		map.put(val, cus);
	}

	public void loadToATM(int twoThosand, int fiveHundred, int hundred) throws Exception {
		Amount.Instance.setTwoThosandCount(twoThosand);
		Amount.Instance.setFiveHundredCount(fiveHundred);
		Amount.Instance.setHundredCount(hundred);
	}

	public void moneyDistribution(long amount) throws Exception {
		long total = 0;
		amountChecker(amount);
		if (amount > Amount.Instance.calculateTotal()) {
			throw new Exception("Insufficient Balance At ATM");
		}
		if (amount <= 5000) {
			if (amount > 3000) {
				int twoCount = Amount.Instance.getTwoThosandCount();
				total += (2000 * 1);
				Amount.Instance.setTwoThosandCount(twoCount - 1);
				total = fiveHunderdCalculator(total, amount);
				total = HunderdCalculator(total, amount);
			} else {
				total = fiveHunderdCalculator(total, amount);
				total = HunderdCalculator(total, amount);
			}
		} else {
			int twoCount = Amount.Instance.getTwoThosandCount();
			total += (2000 * 2);
			Amount.Instance.setTwoThosandCount(twoCount - 2);
			total = fiveHunderdCalculator(total, amount);
			total = HunderdCalculator(total, amount);
		}
	}

	public long fiveHunderdCalculator(long amount, long reachValue) throws Exception {
		long temp = 0;
		while (true) {
			if (amount <= reachValue) {
				temp = amount;
			} else {
				break;
			}
			int twoCount = Amount.Instance.getFiveHundredCount();
			amount += 500 * 1;
			Amount.Instance.setFiveHundredCount(twoCount - 1);
		}
		return temp;
	}

	public long HunderdCalculator(long amount, long reachValue) throws Exception {
		long temp = 0;
		int count = 0;
		while (true) {
			if (reachValue >= amount) {
				temp = amount;
			} else {
				break;
			}
			count++;
			int twoCount = Amount.Instance.getHundredCount();
			amount += 100 * 1;
			Amount.Instance.setHundredCount(twoCount - 1);
		}
		return temp;
	}

	public String withdrawAmount(long accNo, long amount) throws Exception {
		CustomerDetails obj = map.get(accNo);
		nullChecker(obj);
		long balance = obj.getAccountBalance();
		balanceChecker(amount, balance);
		moneyDistribution(amount);
		Transaction tran = new Transaction(transactionNumber++, "Cash Withdrawal", TransactionType.debit, amount,
				balance);
		List<Transaction> arr = transaction.get(accNo);
		if (arr == null) {
			arr = new ArrayList<>();
		}
		arr.add(tran);
		balance -= amount;
		obj.setAccountBalance(balance);
		return "Withdraw Successful";
	}

	public void balanceChecker(long amount, long balance) throws Exception {
		if (balance < amount) {
			throw new Exception("Insufficient Balance");
		}

	}

	public void nullChecker(Object inp) throws Exception {
		if (inp == null) {
			throw new Exception("Account not found");
		}
	}

	public String TransferAccount(long fromAcc, long toAcc, long amount) throws Exception {
		CustomerDetails fromUser = map.get(fromAcc);
		nullChecker(fromUser);
		long fromBalance = fromUser.getAccountBalance();
		balanceChecker(amount, fromBalance);
		CustomerDetails toUser = map.get(toAcc);
		nullChecker(toUser);
		long toBalance = toUser.getAccountBalance();
		long newFromBal = fromBalance - amount;
		long newToBal = toBalance += amount;
		fromUser.setAccountBalance(newFromBal);
		toUser.setAccountBalance(newToBal);
		transferHistory(fromAcc, "Transfer to " + toAcc, TransactionType.debit, amount, fromBalance);
		transferHistory(toAcc, "Transfer from " + fromAcc, TransactionType.credit, amount, toBalance);
		return "Transaction Successful";
	}

	public void transferHistory(long accNo, String description, TransactionType type, long amount, long balance) {
		Transaction tran = new Transaction(transactionNumber++, description, type, amount, balance);
		List<Transaction> arr = transaction.get(accNo);
		if (arr == null) {
			arr = new ArrayList<>();
		}
		arr.add(tran);
	}

	public long checkBalance(long accNo) throws Exception {
		CustomerDetails obj = map.get(accNo);
		nullChecker(obj);
		return obj.getAccountBalance();
	}

	public String printMiniStatement(long accNo) throws Exception {
		List<Transaction> list = transaction.get(accNo);
		String out = "";
		nullChecker(list);
		for (int i = 0; i < list.size(); i++) {
			out += list.get(i).toString();
		}
		return out;
	}

	public void amountChecker(long amount) throws Exception {
		if (amount >= 10000) {
			throw new Exception("Maximum withdrawal limit for a single transaction is 10,000₹");
		} else if (amount <= 100) {
			throw new Exception("Minimum withdrawal limit for a single transaction is 100₹");
		}
	}

	public String getCustomerDetails() {
		String out = "";
		for (CustomerDetails obj : map.values()) {
			out += obj.toString();
		}
		return out;
	}

	public String checkATMBalance() {
		String out = "";
		int twoThosand = Amount.Instance.getTwoThosandCount();
		int fiveHundred = Amount.Instance.getFiveHundredCount();
		int hundred = Amount.Instance.getHundredCount();
		out += "2000" + " " + twoThosand + " " + (2000 * twoThosand) + "\n";
		out += "500" + " " + fiveHundred + " " + (500 * fiveHundred) + "\n";
		out += "100" + " " + hundred + " " + (100 * hundred);
		return out;
	}

}