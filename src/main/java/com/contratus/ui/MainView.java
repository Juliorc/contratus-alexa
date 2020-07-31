package com.contratus.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;

import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinServlet;
import com.contratus.app.security.SecurityUtils;
import com.contratus.ui.views.HasConfirmation;
import com.contratus.ui.views.admin.products.ProductsView;
import com.contratus.ui.views.admin.users.UsersView;
import com.contratus.ui.views.dashboard.DashboardView;
import com.contratus.ui.views.storefront.StorefrontView;

import static com.contratus.ui.utils.Constants.*;

public class MainView extends AppLayout {

	private final ConfirmDialog confirmDialog = new ConfirmDialog();
	private final Tabs menu;
	private H1 viewTitle;

	public MainView() {

		confirmDialog.setCancelable(true);
		confirmDialog.setConfirmButtonTheme("raised tertiary error");
		confirmDialog.setCancelButtonTheme("raised tertiary");
		
        setPrimarySection(Section.DRAWER);
        addToNavbar(createHeaderContent());
        menu = createMenuTabs();
        addToDrawer(createDrawerContent(menu));
        
		getElement().addEventListener("search-focus", e -> {
			getElement().getClassList().add("hide-navbar");
		});

		getElement().addEventListener("search-blur", e -> {
			getElement().getClassList().remove("hide-navbar");
		});
	}
	
    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.getThemeList().set("light", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        viewTitle = new H1();
        layout.add(viewTitle);
        layout.add(new Image("frontend/images/contratus_207x60.png",
                "contratus"));
        return layout;
    }

	
    private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        //layout.setPadding(false);
        //layout.setSpacing(false);
        //layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.START);
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("profile");
        logoLayout.setAlignItems(FlexComponent.Alignment.START);
        Image profileImage = new Image("images/logos/18.png", "Profile img");
        profileImage.setHeight("60px");
        logoLayout.add(profileImage);
        logoLayout.add(new H4("Kevin Moraga"));
        layout.add(logoLayout, menu);
        return layout;
    }

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		confirmDialog.setOpened(false);
		if (getContent() instanceof HasConfirmation) {
			((HasConfirmation) getContent()).setConfirmDialog(confirmDialog);
		}
		RouteConfiguration configuration = RouteConfiguration.forSessionScope();
		if (configuration.isRouteRegistered(this.getContent().getClass())) {
			String target = configuration.getUrl(this.getContent().getClass());
			Optional < Component > tabToSelect = menu.getChildren().filter(tab -> {
				Component child = tab.getChildren().findFirst().get();
				return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
			}).findFirst();
			tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
		} else {
			menu.setSelectedTab(null);
		}
	}

	private static Tabs createMenuTabs() {
		final Tabs tabs = new Tabs();
		tabs.setOrientation(Tabs.Orientation.VERTICAL);
		tabs.add(getAvailableTabs());
		return tabs;
	}

	private static Tab[] getAvailableTabs() {
		final List<Tab> tabs = new ArrayList<>(4);
		tabs.add(createTab(VaadinIcon.EDIT, TITLE_STOREFRONT, StorefrontView.class));
		tabs.add(createTab(VaadinIcon.CLOCK,TITLE_DASHBOARD, DashboardView.class));

		if (SecurityUtils.isAccessGranted(UsersView.class)) {
			tabs.add(createTab(VaadinIcon.USER,TITLE_USERS, UsersView.class));
		}
		if (SecurityUtils.isAccessGranted(ProductsView.class)) {
			tabs.add(createTab(VaadinIcon.CALENDAR, TITLE_PRODUCTS, ProductsView.class));
		}
		final String contextPath = VaadinServlet.getCurrent().getServletContext().getContextPath();
		final Tab logoutTab = createTab(createLogoutLink(contextPath));
		tabs.add(logoutTab);
		return tabs.toArray(new Tab[tabs.size()]);
	}

	private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
		return createTab(populateLink(new RouterLink(null, viewClass), icon, title));
	}

	private static Tab createTab(Component content) {
		final Tab tab = new Tab();
		tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
		tab.add(content);
		return tab;
	}

	private static Anchor createLogoutLink(String contextPath) {
		final Anchor a = populateLink(new Anchor(), VaadinIcon.ARROW_RIGHT, TITLE_LOGOUT);
		// inform vaadin-router that it should ignore this link
		a.setHref(contextPath + "/logout");
		a.getElement().setAttribute("router-ignore", true);
		return a;
	}

	private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
		//a.add(icon.create());
		a.add(title);
		return a;
	}
}
