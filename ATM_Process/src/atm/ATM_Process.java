package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM_Process {

	Map<Long, CustomerDetails> map = new HashMap<>();
	Map<Long, List<Transaction>> transaction = new HashMap<>();
	int transactionNumber = 1000;

	public ATM_Process() {
		CustomerDetails cus = new CustomerDetails();
		cus.setAccNo(1);
		cus.setAccountBalance(5000);
		cus.setAccountHolder("Surya");
		cus.setPinNumber(1234);
		cus.setCustomerId(1);
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
				if (amount <= 1000) {
					total = HunderdCalculator(total, amount);
				} else {
					total = fiveHunderdCalculator(total, amount);
					total = HunderdCalculator(total, amount);
				}
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
			if (amount < reachValue) {
				temp = amount;
			} else {
				return temp;
			}
			int twoCount = Amount.Instance.getFiveHundredCount();
			amount += 500 * 1;
			try {
				Amount.Instance.setFiveHundredCount(twoCount - 1);
			} catch (Exception e) {
				return temp;
			}
		}
	}

	public long HunderdCalculator(long amount, long reachValue) throws Exception {
		long temp = 0;
		while (true) {
			if (amount < reachValue) {
				temp = amount;
			} else {
				return temp;

			}
			int twoCount = Amount.Instance.getHundredCount();
			amount += 100 * 1;
			Amount.Instance.setHundredCount(twoCount - 1);
		}
	}

	public String withdrawAmount(long accNo, long amount) throws Exception {
		CustomerDetails obj = map.get(accNo);
		nullChecker(obj);
		long balance = obj.getAccountBalance();
		balanceChecker(amount, balance);
		moneyDistribution(amount);
		Transaction tran = new Transaction(transactionNumber++, "Cash Withdrawal", TransactionType.debit, amount,
				balance, obj.getCustomerId());
		List<Transaction> arr = transaction.get(accNo);
		if (arr == null) {
			arr = new ArrayList<>();
		}
		arr.add(tran);
		transaction.put(accNo, arr);
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
		transferHistory(fromAcc, "Transfer to " + toAcc, TransactionType.debit, amount, fromBalance,
				fromUser.getCustomerId());
		transferHistory(toAcc, "Transfer from " + fromAcc, TransactionType.credit, amount, toBalance,
				toUser.getCustomerId());
		return "Transaction Successful";
	}

	public void transferHistory(long accNo, String description, TransactionType type, long amount, long balance,
			long id) {
		Transaction tran = new Transaction(transactionNumber++, description, type, amount, balance, id);
		List<Transaction> arr = transaction.get(accNo);
		if (arr == null) {
			arr = new ArrayList<>();
		}
		arr.add(tran);
		transaction.put(accNo, arr);
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
		out += "Transaction number\tDescription\tDebit/Credit\tAmount\tClosing Balance\n";
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
		out += "Description\tNumber\tValue\n";
		out += "2000" + "\t\t" + twoThosand + "\t" + (2000 * twoThosand) + "\n";
		out += "500" + "\t\t" + fiveHundred + "\t" + (500 * fiveHundred) + "\n";
		out += "100" + "\t\t" + hundred + "\t" + (100 * hundred) + "\n \n";
		out += "Total amount available in the ATM = " + Amount.Instance.calculateTotal();
		return out;
	}

	public void storeTransactionToFile() throws IOException {
		FileWriter fw = null;
		for (List<Transaction> arr : transaction.values()) {
			Transaction obj1 = arr.get(0);
			File f = new File(obj1.getCustomerId() + "_transacion.txt");
			f.createNewFile();
			fw = new FileWriter(f);
			fw.write("Transaction number\tDescription\tDebit/Credit\tAmount\tClosing Balance\n");
			for (int i = 0; i < arr.size(); i++) {
				Transaction obj = arr.get(i);
				fw.write(obj.toString());
			}
			fw.close();
		}
		Thread t = new Thread();
		t.start();
	}

	public void storeAtMCashToFile() throws IOException {
		File f = new File("ATM.txt");
		f.createNewFile();
		FileWriter fw = new FileWriter(f);
		fw.write(checkATMBalance());
		fw.close();
	}

	public void loadAtMCashFromFile() throws NumberFormatException, Exception {
		FileReader fr = new FileReader("ATM.txt");
		try (BufferedReader br = new BufferedReader(fr)) {
			String strCurrentLine = "";
			int i;
			br.readLine();
			while ((i = br.read()) != -1) {
				strCurrentLine += (char) i;
			}
			String[] arr = strCurrentLine.split("\t");
			for (i = 0; i < arr.length; i++) {
				if (i == 2) {
					Amount.Instance.setTwoThosandCount(Integer.parseInt(arr[i]));
				} else if (i == 5) {
					Amount.Instance.setFiveHundredCount(Integer.parseInt(arr[i]));
				} else if (i == 8) {
					Amount.Instance.setHundredCount(Integer.parseInt(arr[i]));
					br.close();
					return;
				}
			}
		}
	}

}