package net.avantage.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.avantage.api.Api02Post;

public class Api02PostStepDef {
    Api02Post api02Post=new Api02Post();
    @Given("the post request is sent with the body")
    public void the_post_request_is_sent_with_the_body() {
    api02Post.postUsingHashMap();
    }
    @Then("the request is posted successfully")
    public void the_request_is_posted_successfully() {

    }

}
