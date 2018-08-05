package com.cg.paytmwallet.test;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.cg.paytmwallet.bean.Account;
import com.cg.paytmwallet.exception.AccountException;
import com.cg.paytmwallet.service.AccountService;
import com.cg.paytmwallet.service.AccountServiceImp;

public class AccountServiceImpTest {

	AccountService accService=new AccountServiceImp();
	
	@Test
	public void testCreateAccountMobileNum()  {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("vineesha@gmail.com");
		acc.setMobileNo("938001506");
		acc.setName("vineesha");
		
		try {
			accService.createAccount(acc);
		
		} catch (AccountException e) {
			
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountName() {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("vineesha@gmail.com");
		acc.setMobileNo("9380015060");
		acc.setName("vinee123");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Name should contain only alphabets",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountMailId() {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("vineesha123@gmail");
		acc.setMobileNo("9380015060");
		acc.setName("vineesha");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Invalid mailId",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountAmount() {
		Account acc=new Account();
		acc.setBalance(-2000.0);
		acc.setEmailid("vineesha@gmail.com");
		acc.setMobileNo("9380015060");
		acc.setName("vineesha");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	@Test
	public void testcreateAccountdoesNotExist() {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("vineesha@gmail.com");
		acc.setMobileNo("9380014060");
		acc.setName("vineesha");
		try {
		 accService.createAccount(acc);
			} catch (AccountException e) {
			assertEquals("Exhausted ResultSet",e.getMessage());
		}
		
	}
	@Test
	public void testCreateAccount() {
		Account acc=new Account();
		acc.setBalance(5000.0);
		acc.setEmailid("esha@gmail.com");
		acc.setMobileNo("9380015030");
		acc.setName("esha");
		try {
			String mobileNo = accService.createAccount(acc);
			assertNotNull(mobileNo);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void testShowBalanceMobileNum()  {
		try {
			accService.showBalance("98765432");
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	/*@Test
	public void testShowBalanceMobileNumNotExist()  {
		try {
			accService.showBalance("1234567890");
		} catch (AccountException e) {
			assertEquals("Account with mobileno 1234567890 does not exist",e.getMessage());
		}
	}
	@Test
	public void testShowBalance()  {
		Account acc=new Account();
	try {
			double amount=accService.showBalance("9380015066");
			assertEquals(2300.0, amount,0.00);
		} catch (AccountException e) {
			assertEquals("Account with mobileno 1234567890 does not exist",e.getMessage());
			}
	
	}
	@Test
	public void testDepositMobileNum()  {
		try {
			accService.deposit("98765432",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testDepositAmount() {
		try {
			accService.deposit("9876543210",-1.0);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	/*@Test
	public void testDepositMobileNumDoesNotExist()  {
		try {
			accService.deposit("9876543567",50);
		} catch (AccountException e) {
			assertEquals("Account with mobileno 9876543567 does not exist",e.getMessage());
		}
	}
	@Test
	public void testDeposit() {
		Account acc=new Account();
		acc.setMobileNo("9380015070");
		try {
			double ac= accService.deposit(acc.getMobileNo(),50);
			assertEquals(12550.0, ac,0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testWithdrawMobileNum()  {
		try {
			accService.withdraw("98765432",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testWithdrawAmount()  {
		try {
			accService.withdraw("9876543210",-1.0);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	/*@Test
	public void testWithdrawMobileNumDoesNotExist()  {
		try {
			accService.deposit("9876543567",50);
		} catch (AccountException e) {
			assertEquals("Account with mobileno 9876543567 does not exist",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawMoreAmount() {
		try {
			accService.withdraw("9380015070",4000);
		} catch (AccountException e) {
			assertEquals("Enter Amount it should be less than available amount",e.getMessage());
		}
	}
	/*@Test
	public void testWithdraw()  {
		Account acc=new Account();
		acc.setMobileNo("9876543210");
		try {
			double acc1 = accService.withdraw(acc.getMobileNo(),500);
			assertEquals(2000.0, acc1,0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			
		}
		}
	@Test
	public void testFundTransferMobileNo1()  {
		try {
			accService.fundTransfer("98765432","9876543210",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferMobileNo2()  {
		try {
			accService.fundTransfer("9876543210","98765432",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferAmount()
	{
		try {
			accService.fundTransfer("9876543210","8765432190",-1);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferMoreAmount() {
		try {
			accService.fundTransfer("9380015060","9380015066",7000);
		} catch (AccountException e) {
			assertEquals("Enter Amount it should be less than available amount",e.getMessage());
		}
	}
	/*@Test
	public void testFundTransfer()  
	{
		Account acc=new Account();
		Account acc1=new Account();
		try {
			boolean b = accService.fundTransfer("9380015066","9380015080",100);
			assertNotNull(b);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		}
	@Test
	public void testPrintTransactionMobileNo()  {
		try {
			accService.printTransactions("98765432");
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testPrintTransactions()  {
		Account acc=new Account();
		try {
			Account acc1 = accService.printTransactions("9380015080");
			assertNotNull(acc1);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			
		}
		}*/

	

}
