package com.hashgraph.hederahashgraph;

import com.hedera.hashgraph.sdk.AccountId;
import com.hedera.hashgraph.sdk.HederaPreCheckStatusException;
import com.hedera.hashgraph.sdk.HederaReceiptStatusException;
import com.hedera.hashgraph.sdk.PrecheckStatusException;
import com.hedera.hashgraph.sdk.PrivateKey;
import com.hedera.hashgraph.sdk.Client;
import com.hedera.hashgraph.sdk.TransactionResponse;
import com.hedera.hashgraph.sdk.PublicKey;
import com.hedera.hashgraph.sdk.ReceiptStatusException;
import com.hedera.hashgraph.sdk.AccountCreateTransaction;
import com.hedera.hashgraph.sdk.Hbar;
import com.hedera.hashgraph.sdk.AccountBalanceQuery;
import com.hedera.hashgraph.sdk.AccountBalance;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.concurrent.TimeoutException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class hbar {

    public void accountCreate() throws TimeoutException, PrecheckStatusException, ReceiptStatusException {

        //Grab your Hedera testnet account ID and private key
        HederahashgraphApplication obj=new HederahashgraphApplication();
         obj.setMyAccountId(AccountId.fromString(Dotenv.load().get("MY_ACCOUNT_ID")));
         obj.setMyPrivateKey(PrivateKey.fromString(Dotenv.load().get("MY_PRIVATE_KEY")));

        //Create your Hedera testnet client
        obj.setClient(Client.forTestnet());
        obj.getClient().setOperator(obj.getMyAccountId(), obj.getMyPrivateKey());

        // Generate a new key pair
        //PrivateKey newAccountPrivateKey = PrivateKey.generate();
        //PublicKey newAccountPublicKey = newAccountPrivateKey.getPublicKey();

        //Create new account and assign the public key
       /* TransactionResponse newAccount = new AccountCreateTransaction()
                .setKey(newAccountPublicKey)
                .setInitialBalance( Hbar.fromTinybars(1000))
                .execute(client);*/

        // Get the new account ID
        //AccountId newAccountId = newAccount.getReceipt(client).accountId;

        //System.out.println("The new account ID is: " +newAccountId);

        //Check the new account's balance
        AccountBalance accountBalance = new AccountBalanceQuery().setAccountId(obj.getMyAccountId()).execute(obj.getClient());

        System.out.println("The new account balance is: " +accountBalance.hbars);
        

    }
}