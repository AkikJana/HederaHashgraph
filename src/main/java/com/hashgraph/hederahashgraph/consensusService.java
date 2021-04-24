package com.hashgraph.hederahashgraph;

import java.util.concurrent.TimeoutException;

import com.hedera.hashgraph.sdk.PrecheckStatusException;
import com.hedera.hashgraph.sdk.ReceiptStatusException;
import com.hedera.hashgraph.sdk.TopicCreateTransaction;
import com.hedera.hashgraph.sdk.TopicId;
import com.hedera.hashgraph.sdk.TransactionReceipt;
import com.hedera.hashgraph.sdk.TransactionResponse;

public class consensusService {
    public void createTransaction() throws TimeoutException, PrecheckStatusException, ReceiptStatusException{
        //initialize a hederahashgraph object
    HederahashgraphApplication obj=new HederahashgraphApplication();
    //Create the transaction
TopicCreateTransaction transaction = new TopicCreateTransaction();

//Sign with the client operator private key and submit the transaction to a Hedera network
TransactionResponse txResponse = transaction.execute(obj.getClient());

//Request the receipt of the transaction
TransactionReceipt receipt = txResponse.getReceipt(obj.getClient());

//Get the topic ID
TopicId newTopicId = receipt.topicId;

System.out.println("The new topic ID is " + newTopicId);
    
}
    

//v2.0.0
}
