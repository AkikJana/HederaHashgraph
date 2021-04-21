package com.hashgraph.hederahashgraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeoutException;

import com.hedera.hashgraph.sdk.Hbar;
import com.hedera.hashgraph.sdk.PrecheckStatusException;
import com.hedera.hashgraph.sdk.ReceiptStatusException;
@SpringBootApplication
public class HederahashgraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(HederahashgraphApplication.class, args);
		hbar node=new hbar();
		try {
			node.accountCreate();
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
