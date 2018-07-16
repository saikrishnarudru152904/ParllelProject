package com.cg.ppl.WalletService;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.ppl.bean.Account;
import com.cg.ppl.walletException.WalletException;

public class WalletTest {
private WalletService service;

@Before
public void init() {
service = new WalletServiceImpl();
}

@Test
public void testCreateAccountForMobile() {
Account ac = new Account();
ac.setMobileNo("1234");
ac.setName("Hari");
ac.setEmail("nhbsai333@gmail.com");
ac.setBalance(200.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Mobile number should contain 10 digits", e.getMessage());
}
}
 
@Test
public void testCreateAccountForName() {
Account ac = new Account();
ac.setMobileNo("0123456789");
ac.setName("hari33");
ac.setEmail("mark@gmail.com");
ac.setBalance(500.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
}
}
 
@Test
public void testCreateAccountForNameIsEmpty() {
Account ac = new Account();
ac.setMobileNo("1234567890");
ac.setName("");
ac.setEmail("nhbsai333@gmail.com");
ac.setBalance(200.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Name cannot be empty", e.getMessage());
}
}
 
@Test
public void testCreateAccountForEmailId() {
Account ac = new Account();
ac.setMobileNo("1234567890");
ac.setName("Tapparao");
ac.setEmail("tinku.@@23gmail.com");
ac.setBalance(200.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Enter valid emailid", e.getMessage());
}
}
 

 
@Test
public void testCreateAccount() {
Account ac = new Account();
ac.setMobileNo("1234567890");
ac.setName("Balaji");
ac.setEmail("balajironanki251@gmail.com");
ac.setBalance(200.0);
 
try {
String s=service.createAccount(ac);
Assert.assertNotNull(s);
} catch (WalletException e) {
//System.out.println(e.getMessage());
 
}
 
}
 
@Test
public void testShowBalanceForMobileNo() {

try {
service.showBalance("9502676");
} catch (WalletException e) {
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
 

@Test
public void testShowBalanceForMobileNoDoesNotExist() {
try {
service.showBalance("9700308073");
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}

@Test
public void testShowBalanceForMobileNoExist() {
try {
service.showBalance("9502676892");
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}

 
@Test
public void testDepositForMobileNo() {
Account ac=new Account();
ac.setMobileNo("9502676");
try {
service.deposit(ac.getMobileNo(), 230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
@Test
public void testDepositForMobileNoDoesNotExist() {
Account ac=new Account();
ac.setMobileNo("9505934512");
try {
service.deposit(ac.getMobileNo(), 230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}
@Test
public void testDepositForDepositAmt1() {
Account ac=new Account();
ac.setMobileNo("9502676892");
try {
service.deposit(ac.getMobileNo(), -230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Deposit amount must be greater than zero",e.getMessage());
}
}
 
@Test
public void testDeposit() {
Account ac=new Account();
ac.setMobileNo("9505928555");
try {
Account ac1=service.deposit(ac.getMobileNo(), 230);
assertNotNull(ac1);
} catch (WalletException e) {
 
//System.out.println(e.getMessage());
}
}
 
@Test
public void testWithDrawForMobileNo() {
Account ac=new Account();
ac.setMobileNo("95059345");
try {
service.withdraw(ac.getMobileNo(), 230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
@Test
public void testWithdrawForMobileNoDoesNotExist() {
Account ac=new Account();
ac.setMobileNo("9505934512");
try {
service.withdraw(ac.getMobileNo(), 230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}
@Test
public void testWithdrawForAmt() {
Account ac=new Account();
ac.setMobileNo("9502676892");
try {
service.withdraw(ac.getMobileNo(), -230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
}
}


@Test
public void testWithdrawForAmtEqualZero() {
Account ac=new Account();
ac.setMobileNo("9502676892");
try {
service.withdraw(ac.getMobileNo(), 0);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
}
}
 

@Test
public void testFundTransferForMobileNo() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("95059345");
ac2.setMobileNo("1234");
try {
service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
@Test
public void testFundTransferForMobileNoDoesNotExist() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9505934512");
ac2.setMobileNo("9505934782");
try {
service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}
@Test
public void testFundTransferForAmt() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9502676892");
ac2.setMobileNo("9652142243");
try {
service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
}
}
@Test
public void testFundTransfer() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9505928555");
ac2.setMobileNo("9848468242");
try {
assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230));
} catch (WalletException e) {
// TODO Auto-generated catch block
//System.out.println(e.getMessage());
}
}
@Test
public void testPrinttransactionDetails() {
Account ac=new Account();
ac.setMobileNo("9502676892");
try {
Account acc=service.printTransactionDetails(ac.getMobileNo());
assertNotNull(acc);
} catch (WalletException e) {
//System.out.println(e.getMessage());
}
 
}
@Test
public void testPrinttransactionDetailsForMobileNoDoesNotExist() {
Account ac=new Account();
ac.setMobileNo("9502676891");
try {
	Account acc=service.printTransactionDetails(ac.getMobileNo());
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}
@Test
public void testPrinttransactionDetailsForMobileNo() {
Account ac=new Account();
ac.setMobileNo("9502");
try {
	service.printTransactionDetails(ac.getMobileNo());
	} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
@Test
public void testFundTransferForMobileNoEquality() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9502676892");
ac2.setMobileNo("9502676892");
try {
	service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), 230);

} catch (WalletException e) {
	Assert.assertEquals("Mobile number of Source and Destination should not be same",e.getMessage());
}
}
 
@Test
public void testFundTransferForMobileNoSource() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("950267");
ac2.setMobileNo("9502676892");
try {
	service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), 230);

} catch (WalletException e) {
	Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}

@Test
public void testFundTransferForMobileNoNotExist() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9502676892");
ac2.setMobileNo("9502676891");
try {
	service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), 230);

} catch (WalletException e) {
	Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}

@Test
public void testFundTransferForAmountNotZero() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9502676892");
ac2.setMobileNo("9502676891");
try {
	service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), 0);

} catch (WalletException e) {
	Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
}
}
}