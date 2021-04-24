package com.hashgraph.hederahashgraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeoutException;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.Hbar;
import com.hedera.hashgraph.sdk.PrecheckStatusException;
import com.hedera.hashgraph.sdk.PrivateKey;
import com.hedera.hashgraph.sdk.ReceiptStatusException;
@SpringBootApplication
public class HederahashgraphApplication {
	private static Client client;
	private static AccountId myAccountId;
	private static PrivateKey myPrivateKey;
	public AccountId getMyAccountId() {
		return myAccountId;
	}
	public void setMyAccountId(AccountId myAccountId) {
		this.myAccountId = myAccountId;
	}
	public PrivateKey getMyPrivateKey() {
		return myPrivateKey;
	}
	public void setMyPrivateKey(PrivateKey myPrivateKey) {
		this.myPrivateKey = myPrivateKey;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public static void main(String[] args) {
		SpringApplication.run(HederahashgraphApplication.class, args);
		
		//an object of the hbar class is created which initializes an account on the hedera testnet
		hbar node=new hbar();
		consensusService node1=new consensusService();
		try {
			node.accountCreate();
			node1.createTransaction();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrecheckStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReceiptStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
