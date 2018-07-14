package com.cg.ppl.walletDao;

import com.cg.ppl.bean.Account;
import com.cg.ppl.walletException.WalletException;

public interface WalletDao {
	
	String createAccount(Account acc) throws WalletException;
	double showBalance(String mobileNo) throws WalletException;
	Account deposit(String mobileNo) throws WalletException;
	Account withdraw(String mobileNo) throws WalletException;
	Account printTransactionDetails(String mobileNo) throws WalletException;

}
