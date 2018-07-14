package com.cg.ppl.WalletService;

import com.cg.ppl.bean.Account;
import com.cg.ppl.walletException.WalletException;

public interface WalletService {

	String createAccount(Account acc) throws WalletException;
	double showBalance(String mobileNo) throws WalletException;
	Account deposit(String mobileNo,double depositAmt) throws WalletException;
	Account withdraw(String mobileNo,double withdrawAmt) throws WalletException;
	boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmt) throws WalletException;
	Account printTransactionDetails(String mobileNo) throws WalletException;
}
