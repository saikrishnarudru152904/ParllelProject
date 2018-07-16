package com.cg.ppl.WalletService;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.ppl.WalletDB.WalletDB;
import com.cg.ppl.bean.Account;
import com.cg.ppl.walletDao.WalletDao;
import com.cg.ppl.walletException.WalletDaoImpl;
import com.cg.ppl.walletException.WalletException;

public class WalletServiceImpl implements WalletService {
	WalletDao dao = new WalletDaoImpl();
	private static HashMap<String, Account> walletMap = WalletDB.getWalletDb();
	@Override
	public String createAccount(Account acc) throws WalletException {
		if (!acc.getMobileNo().matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
			if (acc.getName().isEmpty() || acc.getName() == null) {
			throw new WalletException("Name cannot be empty");
			} else {
			if (!acc.getName().matches("[A-Z][A-Za-z]{3,}")) {
			throw new WalletException("Name should start with capital letter and should contain only alphabets");
			}
			}
			if (acc.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")) {
			throw new WalletException("Enter valid emailid");
			}
			if (acc.getBalance() <= 0) {
			throw new WalletException("Balance should be greater than zero");
			}
			return dao.createAccount(acc);
	}

	@Override
	public double showBalance(String mobileNo) throws WalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
			return dao.showBalance(mobileNo);
	}

	@Override
	public Account deposit(String mobileNo, double depositAmt)
			throws WalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
			Account acc = dao.deposit(mobileNo);
			if (depositAmt <= 0) {
			throw new WalletException("Deposit amount must be greater than zero");
			}
			acc.setBalance(acc.getBalance() + depositAmt);
			acc.setDate(LocalDateTime.now());
			return acc;
	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmt)
			throws WalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
			Account acc = dao.withdraw(mobileNo);
			if (withdrawAmt > acc.getBalance() || withdrawAmt <= 0) {
			throw new WalletException(
			"The amount to be withdrawn should be greater than available balance and greater than zero");
			}
			acc.setBalance(acc.getBalance() - withdrawAmt);
			acc.setDate(LocalDateTime.now());
			return acc;
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws WalletException {
		WalletService service = new WalletServiceImpl();
		
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
			if (!destMobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
			if((sourceMobileNo==destMobileNo)){
				throw new WalletException("Mobile number of Source and Destination should not be same");	
			}
			
			Account acc1 = service.withdraw(sourceMobileNo, transferAmt);
			Account acc2 = service.deposit(destMobileNo, transferAmt);
			return true;
		
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws WalletException {
		Account acc = walletMap.get(mobileNo);
		
		if (!mobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
		if (acc == null) {
			throw new WalletException("The mobile number does not exist");
			}
		
		return  dao.printTransactionDetails(mobileNo);
	}
	
	

}
