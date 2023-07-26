package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.avantage.pages.SelectorHubPage;
import net.avantage.utils.Driver;

public class SelectorHubStepDefs {

    SelectorHubPage selectorHubPage = new SelectorHubPage();

    @Given("navigate tp selectorHub practice page")
    public void navigate_tp_selector_hub_practice_page() {
        Driver.get().get("https://selectorshub.com/xpath-practice-page/");
    }

    @Given("type name in enterName box")
    public void type_name_in_enter_name_box() {
        selectorHubPage.typeUserName();
    }

    @And("handle closed shadowRoot")
    public void handleClosedShadowRoot() {
        selectorHubPage.closeShadowDom();
    }

    @Given("navigate tp selectorHub iframe shadowdom practice page")
    public void navigate_tp_selector_hub_iframe_shadowdom_practice_page() {
        Driver.get().get("https://selectorshub.com/iframe-in-shadow-dom/");
    }

    @Given("type text in destiny box")
    public void type_text_in_destiny_box() {
        selectorHubPage.handleIframeInShadowRoot();
    }

    @And("hover over close button")
    public void hoverOverCloseButton() {
        selectorHubPage.handleCloseButton();
    }

    @Given("navigate to selectorsHub shadowRoot in iframe")
    public void navigate_to_selectors_hub_shadow_root_in_iframe() {
        Driver.get().get("https://selectorshub.com/shadow-dom-in-iframe/");
    }

    @Given("type text in")
    public void type_text_in() {
        selectorHubPage.shadowRootInsideIframe();
    }
}
