package com.contratus.application.views.contratus;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.contratus.application.views.main.MainView;

import com.contratus.application.views.contratus.ContratusView.ContratusViewModel;

@Route(value = "empty", layout = MainView.class)
@PageTitle("Contratus")
@JsModule("./src/views/contratus/contratus-view.js")
@Tag("contratus-view")
public class ContratusView extends PolymerTemplate<ContratusViewModel> {

    // This is the Java companion file of a design
    // You can find the design file in /frontend/src/views/src/views/contratus/contratus-view.js
    // The design can be easily edited by using Vaadin Designer (vaadin.com/designer)

    public static interface ContratusViewModel extends TemplateModel {
    }

    public ContratusView() {
    }
}
