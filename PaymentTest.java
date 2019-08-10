package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import bean.PayBean;
import dao.PayDao;
import dao.UserException;
import service.PayService;

class PaymentTest {

	PayService serv=new PayService();
	PayBean acOpen=new PayBean();
	PayDao dao = new PayDao();
	@Test
	public void testStoreIntoMap() throws UserException {
		
		acOpen.setName("Mayank");
		acOpen.setAddress("Mathura");
		acOpen.setPhnno(9193207896L);
		acOpen.setBalance(5000);
		
		boolean result=serv.create(9193207896L, "Mayank", "Mathura", 9193207896L, 5000); 
		
		assertTrue(result);
	}
	@Test
	public void testAddBalanceTrue() throws UserException
	{
		HashMap<Long,PayBean >map = new HashMap();
		PayBean acOpen = new PayBean();
		
		
		acOpen.setAccno(9193207896L);
		acOpen.setAddress("Mathura");
		
		acOpen.setBalance(5000);
		acOpen.setPhnno(919320775L);	
		map.put(9193207896L, acOpen);
		dao.populateMap(map);
		
		boolean result=dao.deposit(9193207896L, 1000);
		assertTrue(result);
	}
	@Test
	public void testAddBalanceFalse() throws UserException
	{
		HashMap<Long,PayBean >map = new HashMap();
		PayBean acOpen = new PayBean();
		
		
		acOpen.setAccno(9193207896L);
		acOpen.setAddress("Mathura");
		
		acOpen.setBalance(5000);
		acOpen.setPhnno(919320775L);	
		map.put(9193207896L, acOpen);
		dao.populateMap(map);
		
		boolean result=dao.deposit(913207896L, 1000);
		assertFalse(result);
	}
	@Test
	public void testFundTransfer() throws UserException
	{
		HashMap<Long,PayBean >map = new HashMap<>();
		PayBean acOpen = new PayBean();
		acOpen.setAccno(1001);
		acOpen.setBalance(5000);
		acOpen.setPhnno(9803538343L);	
		map.put(9803538343L, acOpen);
		dao.populateMap(map);
		PayBean acOpen2 = new PayBean();
		acOpen.setAccno(1002);
		acOpen.setBalance(6000);
		acOpen.setPhnno(9803768343L);
		map.put(9803768343L, acOpen2);
		dao.populateMap(map);
		boolean result=dao.transferFund(9803538343L,9803768343L,1000);
		assertTrue(result);
	}

	@Test
	public void testWithdrawTrue() throws UserException
	{
		HashMap<Long,PayBean >map = new HashMap();
		PayBean acOpen = new PayBean();
		
		
		acOpen.setAccno(9193207896L);
		acOpen.setAddress("Mathura");
		
		acOpen.setBalance(5000);
		acOpen.setPhnno(919320775L);	
		map.put(919320775L, acOpen);
		dao.populateMap(map);
		
		boolean result=dao.Withdraw(919320775L, 100);
		assertTrue(result);
	}
	@Test
	public void testWithdrawFalse() throws UserException
	{
		HashMap<Long,PayBean >map = new HashMap();
		PayBean acOpen = new PayBean();
		
		
		acOpen.setAccno(9193207896L);
		acOpen.setAddress("Mathura");
		
		acOpen.setBalance(5000);
		acOpen.setPhnno(919320775L);	
		map.put(919320775L, acOpen);
		dao.populateMap(map);
		
		boolean result=dao.Withdraw(91920775L, 100);
		assertFalse(result);
	}
}
