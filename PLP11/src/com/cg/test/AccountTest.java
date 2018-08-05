package com.cg.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.bean.Account;
import com.cg.exception.AccountException;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImp;

public class AccountTest {

	AccountService accService=new AccountServiceImp();
	
	@Test
	public void testCreateAccountMobileNum()  {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("sk@gmail.com");
		acc.setMobileNo("97003080");
		acc.setName("Sk");
		
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
		acc.setEmailid("sk@gmail.com");
		acc.setMobileNo("9700308073");
		acc.setName("Sk1234");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Name should contain only alphabets and it should start with a capital letter",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountMailId() {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("sk@@gmail.com");
		acc.setMobileNo("9380015060");
		acc.setName("Skkk");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Invalid mailId",e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccount() {
		Account acc=new Account();
		acc.setBalance(5000.0);
		acc.setEmailid("sk@gmail.com");
		acc.setMobileNo("9380015030");
		acc.setName("sk");
		try {
			String mobileNo = accService.createAccount(acc);
			assertNotNull(mobileNo);
		} catch (AccountException e) {
			//System.out.println(e.getMessage());
			assertEquals("Name should contain only alphabets and it should start with a capital letter", e.getMessage());
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
	
	@Test
	public void testDeposit() {
		Account acc=new Account();
		acc.setMobileNo("9380015070");
		try {
			double ac= accService.deposit(acc.getMobileNo(),50);
			assertEquals(12550.0, ac,0.00);
		} catch (AccountException e) {
			//System.out.println(e.getMessage());
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
	
	@Test
	public void testWithdraw()  {
		Account acc=new Account();
		acc.setMobileNo("9876543210");
		try {
			double acc1 = accService.withdraw(acc.getMobileNo(),500);
			assertEquals(2000.0, acc1,0.00);
		} catch (AccountException e) {
			//System.out.println(e.getMessage());
			
		}
		}
	@Test
	public void testWithdraw1()  {
		Account acc=new Account();
		acc.setMobileNo("9876543210");
		try {
			double acc1 = accService.withdraw(acc.getMobileNo(),0);
			assertEquals(2000.0, acc1,0.00);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero", e.getMessage());
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
			accService.fundTransfer("9700308073","8765432190",-1);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	
	
	@Test
	public void testFundTransfer()  
	{
		Account acc=new Account();
		Account acc1=new Account();
		try {
			boolean b = accService.fundTransfer("9380015066","9700308073",100);
			assertNotNull(b);
		} catch (AccountException e) {
			//System.out.println(e.getMessage());
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
			Account acc1 = accService.printTransactions("97003080a3");
			assertNotNull(acc1);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits", e.getMessage());
			
		}
		}
	
	

	

}
