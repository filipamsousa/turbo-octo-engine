package pt.ulisboa.tecnico.learnjava.sibs.cli;

import java.util.Random;

import pt.ulisboa.tecnico.learnjava.bank.domain.Client;
import pt.ulisboa.tecnico.learnjava.bank.services.Services;

public class associateMbWayController {

	Integer code;

	public Integer generateCode() {
		Random random = new Random();
		this.code = random.nextInt(100000) + random.nextInt(899999);
		return code;
	}

	public void associate_mbway(Services services, String iban, String phoneNumber) {
		Client client = services.getAccountByIban(iban).getClient();
		if (phoneNumber.equals(client.getPhoneNumber())) {
			this.code = generateCode();
			client.setMbwayCode(this.code);
			MbWay.mbWayClients.put(phoneNumber, iban);
			System.out.println("Code: " + this.code.toString() + " (don’t share it with anyone)");
		} else {
			System.out.println("Wrong phone number!");
		}

	}

	public Integer getCode() {
		return code;
	}

}
