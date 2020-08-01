package com.contratus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeoutException;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;

public final class GatewayContratus {
    public static void main(String[] args) throws IOException {
    	
    	System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // Load an existing wallet holding identities used to access the network.
        Path walletDirectory = Paths.get("/home/kmoragas/Works/contratus/bee/Gateway/resources/wal");
        Wallet wallet = Wallets.newFileSystemWallet(walletDirectory);

        // Path to a common connection profile describing the network.
        Path networkConfigFile = Paths.get("resources/connection.json");

        // Configure the gateway connection used to access the network.
        Gateway.Builder builder = Gateway.createBuilder()
                .identity(wallet, "contratusMSP")
                .networkConfig(networkConfigFile);

        // Create a gateway connection
        try (Gateway gateway = builder.connect()) {

            // Obtain a smart contract deployed on the network.
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("contratus");

            // Submit transactions that store state to the ledger.
            byte[] createCarResult = contract.submitTransaction("createContratoTurismo", "1233", "33", "Amanda", "Victor");
            System.out.println(new String(createCarResult, StandardCharsets.UTF_8));

            // Evaluate transactions that query state from the ledger.
            // byte[] queryAllCarsResult = contract.evaluateTransaction("queryAllCars");
            // System.out.println(new String(queryAllCarsResult, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}