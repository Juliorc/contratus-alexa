package com.contratus.testbench.elements.ui;

import com.contratus.testbench.elements.components.AppNavigationElement;
import com.vaadin.testbench.HasElementQuery;

public interface HasApp extends HasElementQuery {

	default MainViewElement getApp() {
		return $(MainViewElement.class).onPage().first();
	}

	default AppNavigationElement getMenu() {
		return getApp().getMenu();
	}

}
