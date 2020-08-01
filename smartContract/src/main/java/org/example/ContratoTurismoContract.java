/*
 * SPDX-License-Identifier: Apache-2.0
 */
package org.example;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import static java.nio.charset.StandardCharsets.UTF_8;

@Contract(name = "ContratoTurismoContract",
    info = @Info(title = "ContratoTurismo contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "smartContract@example.com",
                                                name = "smartContract",
                                                url = "http://smartContract.me")))
// Params
// ["3213", "100", "Alexa", "Pedro"]

@Default
public class ContratoTurismoContract implements ContractInterface {
    public  ContratoTurismoContract() {

    }
    @Transaction()
    public boolean contratoTurismoExists(Context ctx, String contratoTurismoId) {
        byte[] buffer = ctx.getStub().getState(contratoTurismoId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createContratoTurismo(Context ctx, String contratoTurismoId, String value, String party, String counterParty) {
        boolean exists = contratoTurismoExists(ctx,contratoTurismoId);
        if (exists) {
            throw new RuntimeException("The asset "+contratoTurismoId+" already exists");
        }
        ContratoTurismo asset = new ContratoTurismo(value, party, counterParty);
        ctx.getStub().putState(contratoTurismoId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void startContractoTurismo(Context ctx, String contratoTurismoId) {
        
    }

    @Transaction()
    public void checkContractStatus(Context ctx, String contratoTurismoId) {
        
    }

    @Transaction()
    public void endContractoTurismo(Context ctx, String contratoTurismoId, String value) {
        
    }

    @Transaction()
    public ContratoTurismo readContratoTurismo(Context ctx, String contratoTurismoId) {
        boolean exists = contratoTurismoExists(ctx,contratoTurismoId);
        if (!exists) {
            throw new RuntimeException("The asset "+contratoTurismoId+" does not exist");
        }

        ContratoTurismo newAsset = ContratoTurismo.fromJSONString(new String(ctx.getStub().getState(contratoTurismoId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateContratoTurismo(Context ctx, String contratoTurismoId, String newValue) {
        boolean exists = contratoTurismoExists(ctx,contratoTurismoId);
        if (!exists) {
            throw new RuntimeException("The asset "+contratoTurismoId+" does not exist");
        }
        ContratoTurismo asset = new ContratoTurismo();
        asset.setValue(newValue);

        ctx.getStub().putState(contratoTurismoId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteContratoTurismo(Context ctx, String contratoTurismoId) {
        boolean exists = contratoTurismoExists(ctx,contratoTurismoId);
        if (!exists) {
            throw new RuntimeException("The asset "+contratoTurismoId+" does not exist");
        }
        ctx.getStub().delState(contratoTurismoId);
    }

}
