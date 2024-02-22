package es.iessoterohernandez.daw.endes.EjerciciosJunit;

import java.text.NumberFormat;

public class Account {
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();

	private final float kInterestRate = 0.045f; // interest rate of 4.5%

	private long acctNumber;
	private float balance;
	public final String name;

	public Account(String owner, long account, float initial) {
		name = owner;
		acctNumber = account;
		balance = initial;
	}

	public boolean deposit(float amount) {
		boolean result = true;
		// is amount invalid?
		if (amount < 0) {
			result = false;
		} else {
			balance = balance + amount;
		}

		return result;
	}

	public boolean withdraw(float amount, float fee) {
		// validate parameters
		if (isValidWithdrawl(amount, fee)) {
			amount += fee;
			balance = balance - amount;
		}
		return isValidWithdrawl(amount, fee);
	}

	/* Determine if withdrawal parameters are valid */
	private boolean isValidWithdrawl(float amount, float fee) {
		return amount >= 0 && fee >= 0 && amount <= balance;
	}

	public void addInterest() {
		balance += (balance * kInterestRate);
	}

	public float getBalance() {
		return balance;
	}

	public long getAccountNumber() {
		return acctNumber;
	}

	public String toString() {
		return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
	}
}