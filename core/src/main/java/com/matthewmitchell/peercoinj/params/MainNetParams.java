/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.matthewmitchell.peercoinj.params;

import com.matthewmitchell.peercoinj.core.NetworkParameters;
import com.matthewmitchell.peercoinj.core.Sha256Hash;
import com.matthewmitchell.peercoinj.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = Utils.decodeCompactBits(0x1e0fffffL);
        dumpedPrivateKeyHeader = 183;
        addressHeader = 18;
        p2shHeader = 20;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 38851;
        packetMagic= 0xccd5dbfa;
        genesisBlock.setDifficultyTarget(0x1e0fffffL);
        genesisBlock.setTime(1422894606L);
        genesisBlock.setNonce(5025607L);
        id = ID_MAINNET;
        spendableCoinbaseDepth = 50;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("0x00000a8c92f75efe8d48923ab380a382a89b2ba2e19bd06577e11828fa8d56b8"), genesisHash);


        dnsSeeds = new String[] {
                "", ""
        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
