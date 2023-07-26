package net.avantage.step_definitions;

import io.cucumber.java.en.Given;
import net.avantage.api.Api03Put;

public class Api03PutStepDefs {
    Api03Put api03Put = new Api03Put();
    @Given("Send the Put request")
    public void send_the_put_request() {
        api03Put.sendPutRequest();

    }


}
