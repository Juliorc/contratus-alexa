package com.contratus.ui.views.alexa;

import com.contratus.ui.MainView;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the share-contract template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("share-contract")
@JsModule("./src/views/alexa/share-contract.js")
@Route(value = "shareContract", layout = MainView.class)
public class ShareContract extends PolymerTemplate<ShareContract.ShareContractModel> {

    /**
     * Creates a new ShareContract.
     */
    public ShareContract() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between ShareContract and share-contract
     */
    public interface ShareContractModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
