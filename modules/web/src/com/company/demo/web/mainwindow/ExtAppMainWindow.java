package com.company.demo.web.mainwindow;

import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import java.util.Map;

public class ExtAppMainWindow extends AppMainWindow {
    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        VBoxLayout initialLayout = workArea.getInitialLayout();
        ComponentContainer vContainer = initialLayout.unwrap(ComponentContainer.class);

        Wizard wizard = new Wizard();
        wizard.setSizeFull();

        wizard.addStep(new EmptyWizardStep("First"));
        wizard.addStep(new EmptyWizardStep("Last"));

        vContainer.addComponent(wizard);
    }

    public static class EmptyWizardStep implements WizardStep {
        private final String caption;
        private final VerticalLayout content = new VerticalLayout();

        public EmptyWizardStep(String caption) {
            this.caption = caption;
        }

        @Override
        public String getCaption() {
            return caption;
        }

        @Override
        public Component getContent() {
            return content;
        }

        @Override
        public boolean onAdvance() {
            return true;
        }

        @Override
        public boolean onBack() {
            return false;
        }
    }
}
