package com.contratus.ui.views.pedro;

import com.contratus.ui.MainView;
import com.contratus.ui.utils.Constants;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the payment-method-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("payment-method-view")
@JsModule("./src/views/pedro/payment-method-view.js")
public class PaymentMethodView extends PolymerTemplate<PaymentMethodView.PaymentMethodViewModel> {

    /**
     * Creates a new PaymentMethodView.
     */
    public PaymentMethodView() {
        // You can initialise any data required for the connected UI components here.));
    }

    /**
     * This model binds properties between PaymentMethodView and payment-method-view
     */
    public interface PaymentMethodViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
