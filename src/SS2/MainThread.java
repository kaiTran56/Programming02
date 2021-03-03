package SS2;

class BankAccount extends Object {

	long amount = 5000000;

	public synchronized boolean checkAccountBalance(long withDrawAmount) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (withDrawAmount <= amount) {
			System.out.println("Account balance: " + amount);
			return true;
		}

		return false;
	}

	public synchronized void withdraw(String threadName, long withdrawAmount) {
		System.out.println(threadName + " wants to withdraw: " + withdrawAmount);

		if (checkAccountBalance(withdrawAmount)) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			amount -= withdrawAmount;
			System.out.println(threadName + " withdraws successfully: " + withdrawAmount);
		} else {
			System.out.println(threadName + " withdraws error!");
		}

		System.out.println(threadName + " see balance: " + amount);
	}

	public synchronized void withdrawWhenBalanceEnough(String threadName, long withdrawAmount) {
		System.out.println(threadName + " wants to withdraw: " + withdrawAmount);

		while (!checkAccountBalance(withdrawAmount)) {
			System.out.println(threadName + " waits for balance enough");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		amount -= withdrawAmount;
		System.out.println(threadName + " withdraws successfully: " + withdrawAmount);
	}

	public synchronized void deposit(String threadName, long depositAmount) {
		System.out.println(threadName + " deposit: " + depositAmount);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		amount += depositAmount;

		notify();
	}
}

class WithdrawThread extends Thread {

	String threadName = "";
	long withdrawAmount = 0;
	BankAccount bankAccount;

	public WithdrawThread(String threadName, BankAccount bankAccount, long withdrawAmount) {
		this.threadName = threadName;
		this.bankAccount = bankAccount;
		this.withdrawAmount = withdrawAmount;
	}

	@Override
	public void run() {
		bankAccount.withdrawWhenBalanceEnough(threadName, withdrawAmount);
	}
}

class DepositThread extends Thread {

	String threadName = "";
	long depositAmount = 0;
	BankAccount bankAccount;

	public DepositThread(String threadName, BankAccount bankAccount, long depositAmount) {
		this.threadName = threadName;
		this.bankAccount = bankAccount;
		this.depositAmount = depositAmount;
	}

	@Override
	public void run() {
		bankAccount.deposit(threadName, depositAmount);
	}
}

public class MainThread {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();

		WithdrawThread wifeThread = new WithdrawThread("Wife", bankAccount, 10000000);
		wifeThread.start();

		DepositThread husbandThread = new DepositThread("Husband", bankAccount, 5000000);
		husbandThread.start();
	}
}

/**
 * <pre>
 * Husband deposit: 5000000<br>
 * Wife wants to withdraw: 10000000 <br>
 * Account balance: 10000000 <br>
 * Wife withdraws successfully: 10000000
 * 
 */
