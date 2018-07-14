package com.cg.ppl.WalletDB;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.ppl.bean.Account;

public class WalletDB {
	private static HashMap<String,Account> walletDbMap=new HashMap<String,Account>();
	Account obj=new Account();

	public static HashMap<String, Account> getWalletDb() {
		return walletDbMap;
	}
	static{
		 
		walletDbMap.put("9502676892",new Account("9502676892","Hari","nhbsai333@gmail.com",1000.0,LocalDateTime.now()));
		walletDbMap.put("9494433580",new Account("9494433580","Balaji","balaji.ronanki251@gmail.com",2000.0,LocalDateTime.now()));
		walletDbMap.put("9652142243",new Account("9652142243","O.V.Rama Reddy","ramareddy9652@gmail.com",3500.0,LocalDateTime.now()));
		walletDbMap.put("7680809630",new Account("7680809630","Giridhar","giridharpedapudi1@gmail.com",3000.0,LocalDateTime.now()));
		}
	

}
