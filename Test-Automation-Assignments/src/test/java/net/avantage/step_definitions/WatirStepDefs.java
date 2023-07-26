package net.avantage.step_definitions;

import io.cucumber.java.en.Given;
import net.avantage.pages.WatirPage;
import net.avantage.utils.Driver;

public class WatirStepDefs {
    WatirPage watirPage = new WatirPage();

    @Given("Navigate to watir shadowDom page")
    public void navigate_to_watir_shadow_dom_page() {
        Driver.get().get("http://watir.com/examples/shadow_dom.html");
    }

    @Given("get text in nested shadowRoot")
    public void get_text_in_nested_shadow_root() {
        watirPage.getTextInNestedShadowHost();
        watirPage.getNestedTextUsingJSExecutor();
    }
}
