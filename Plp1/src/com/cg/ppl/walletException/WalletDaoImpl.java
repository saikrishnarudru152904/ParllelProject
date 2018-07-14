package com.cg.ppl.walletException;

import java.util.HashMap;

import com.cg.ppl.WalletDB.WalletDB;
import com.cg.ppl.bean.Account;
import com.cg.ppl.walletDao.WalletDao;

public class WalletDaoImpl implements WalletDao {
	private static HashMap<String, Account> walletMap = WalletDB.getWalletDb();


	@Override
	public String createAccount(Account acc) throws WalletException {
		walletMap.put(acc.getMobileNo(), acc);
		return acc.getMobileNo();
	}

	@Override
	public double showBalance(String mobileNo) throws WalletException {
		Account acc = walletMap.get(mobileNo);
		if (acc == null) {
		throw new WalletException("The mobile number does not exist");
		}
		return acc.getBalance();
		}

	@Override
	public Account deposit(String mobileNo) throws WalletException {
		Account acc = walletMap.get(mobileNo);
		if (acc == null) {
		throw new WalletException("The mobile number does not exist");
		}
		return acc;
	}

	@Override
	public Account withdraw(String mobileNo) throws WalletException {
		Account acc = walletMap.get(mobileNo);
		if (acc == null) {
		throw new WalletException("The mobile number does not exist");
		}
		return acc;
		}

	@Override
	public Account printTransactionDetails(String mobileNo) throws WalletException{
		Account acc = walletMap.get(mobileNo);
	if (acc == null) {
		throw new WalletException("The mobile number does not exist");
		}
		return acc;
	}

}
