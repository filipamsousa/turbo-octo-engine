package pt.ulisboa.tecnico.learnjava.sibs.sibs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.domain.Bank;
import pt.ulisboa.tecnico.learnjava.bank.domain.CheckingAccount;
import pt.ulisboa.tecnico.learnjava.bank.domain.Client;
import pt.ulisboa.tecnico.learnjava.bank.exceptions.AccountException;
import pt.ulisboa.tecnico.learnjava.bank.exceptions.BankException;
import pt.ulisboa.tecnico.learnjava.bank.exceptions.ClientException;
import pt.ulisboa.tecnico.learnjava.bank.services.Services;
import pt.ulisboa.tecnico.learnjava.sibs.cli.MbWay;
import pt.ulisboa.tecnico.learnjava.sibs.cli.associateMbWayController;

public class AssociateMbWayControllerMethodTest {

	@Test
	public void mockAssociateMbWayController() throws BankException, ClientException, AccountException {
		Bank mockBank = mock(Bank.class);
		Client client = new Client(mockBank, "Filipa", "Sousa", "123456789", "987654321", "Rua1", 23);
		CheckingAccount account = new CheckingAccount(client, 100);
		Services mockServices = mock(Services.class);
		associateMbWayController associateController = new associateMbWayController();

		when(mockServices.getAccountByIban("iban1")).thenReturn(account);
		associateController.associate_mbway(mockServices, "iban1", "987654321");

		assertEquals(associateController.getCode(), client.getMbwayCode());
		assertEquals("iban1", MbWay.mbWayClients.get("987654321"));
	}
}
