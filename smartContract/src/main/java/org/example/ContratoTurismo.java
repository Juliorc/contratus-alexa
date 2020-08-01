/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import com.owlike.genson.Genson;

@DataType()
public class ContratoTurismo {

    private final static Genson genson = new Genson();

    @Property()
    private String value;

    @Property()
    private String party;
    
    @Property()
    private String counterParty;

    public ContratoTurismo() { }
    
    public ContratoTurismo(String value, String party, String counterParty) {
        this.value = value;
        this.party = party;
        this.counterParty = counterParty;
    }
    
    public String getParty() {
        return this.party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCounterParty() {
        return this.counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toJSONString() {
        return genson.serialize(this).toString();
    }

    public static ContratoTurismo fromJSONString(String json) {
        ContratoTurismo asset = genson.deserialize(json, ContratoTurismo.class);
        return asset;
    }
}
