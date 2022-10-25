package org.cruz.trava.zap;

import org.junit.Assert;
import org.junit.Test;

public class TravaZapTest {

    @Test
    public void testeZapTravaTudo() {

        var travaZap = new TravaZap();
        Assert.assertTrue(travaZap.zapTravaTudo());

    }
}