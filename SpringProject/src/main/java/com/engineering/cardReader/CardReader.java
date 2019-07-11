package com.engineering.cardReader;

import java.util.List;
import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.engineering.repository.UserRepository;

public class CardReader {

	@Autowired
	UserRepository userRepo;



	private static CardTerminal pickTerminal(List<CardTerminal> terminals) {
		if (terminals.size() > 1) {
			System.out.println("Available readers:\n");
			int c = 1;
			for (CardTerminal terminal : terminals) {
				System.out.format("%d) %s\n", c++, terminal);
			}

			while (true) {

				System.out.flush();

				c = 1;
				if (c > 0 && c <= terminals.size()) {

					return terminals.get(c - 1);
				}
			}
		} else {
			return terminals.get(0);
		}
	}

	public static String getCardId() {
		CardTerminal terminal = null;
		
		String cardId = null;

		// get the terminal
		try {
			TerminalFactory factory = TerminalFactory.getDefault();
			terminal = pickTerminal(factory.terminals().list());

			System.out.println("Using reader   : " + terminal);
		} catch (CardException e) {
			System.err.println("Missing card reader.");
		}

		try {
			// establish a connection with the card
			Card card = terminal.connect("*");

			// read eid data
			EidCard eidcard = EidCard.fromCard(card);

			EidInfo info = eidcard.readEidInfo();
			cardId = info.getDocRegNo();

			/*
			 * System.out.format("eID number     : %s\n", info.getDocRegNo());
			 * System.out.format("Issued         : %s\n", info.getIssuingDate());
			 * System.out.format("Valid          : %s\n", info.getExpiryDate());
			 * System.out.format("Issuer         : %s\n", info.getIssuingAuthority());
			 * System.out.format("JMBG           : %s\n", info.getPersonalNumber());
			 * System.out.format("Family name    : %s\n", info.getSurname());
			 * System.out.format("First name     : %s\n", info.getGivenName());
			 * System.out.format("Middle name    : %s\n", info.getParentGivenName());
			 * System.out.format("Gender         : %s\n", info.getSex());
			 * System.out.format("Place od birth : %s\n",
			 * info.getPlaceOfBirthFull().replace("\n", ", "));
			 * System.out.format("Date of birth  : %s\n", info.getDateOfBirth());
			 * System.out.format("Street address : %s, %s\n", info.getStreet(),
			 * info.getHouseNumber()); System.out.format("City           : %s, %s, %s\n",
			 * info.getCommunity(), info.getPlace(), info.getState());
			 */

		} catch (Exception e) {
			System.err.println("ID card is not inserted into card reader");

		}

		return cardId;

	}

	public static String CardLoginPass() {

		String cardLogin = null;

		CardTerminal terminal = null;

		// get the terminal
		try {
			TerminalFactory factory = TerminalFactory.getDefault();
			terminal = pickTerminal(factory.terminals().list());

			System.out.println("Using reader   : " + terminal);
		} catch (CardException e) {
			System.err.println("Missing card reader.");
		}

		try {
			// establish a connection with the card
			Card card = terminal.connect("*");

			// read eid data
			EidCard eidcard = EidCard.fromCard(card);

			EidInfo info = eidcard.readEidInfo();
			cardLogin = info.getDocRegNo();

		} catch (Exception e) {
			System.err.println("ID card is not inserted into card reader");

		}

		String pass = "{noop}".concat(cardLogin);

		return pass;

	}

	public static String CardLoginUsername() {

		String cardLoginUsername = null;

		CardTerminal terminal = null;

		// get the terminal
		try {
			TerminalFactory factory = TerminalFactory.getDefault();
			terminal = pickTerminal(factory.terminals().list());

			System.out.println("Using reader   : " + terminal);
		} catch (CardException e) {
			System.err.println("Missing card reader.");
		}

		try {
			// establish a connection with the card
			Card card = terminal.connect("*");

			// read eid data
			EidCard eidcard = EidCard.fromCard(card);

			EidInfo info = eidcard.readEidInfo();
			cardLoginUsername = info.getGivenName() + "" + info.getSurname();

		} catch (Exception e) {
			System.err.println("ID card is not inserted into card reader");

		}
		
		return cardLoginUsername;

	}

}
