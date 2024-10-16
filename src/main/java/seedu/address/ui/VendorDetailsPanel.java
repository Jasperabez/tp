package seedu.address.ui;

import java.util.logging.Logger;

import javafx.beans.value.ObservableObjectValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.vendor.Vendor;

/**
 * Panel containing the list of vendors.
 */
public class VendorDetailsPanel extends UiPart<Region> {
    private static final String FXML = "VendorDetailsPanel.fxml";
    private Vendor vendor;
    private final Logger logger = LogsCenter.getLogger(VendorDetailsPanel.class);

    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label description;
    @FXML
    private Label noVendorMsg;
    @FXML
    private GridPane detailsHolder;
    @FXML
    private StackPane detailsChildrenPlaceholder;

    /**
     * Creates a {@code VendorListPanel} with the given {@code ObservableList}.
     */
    public VendorDetailsPanel(ObservableObjectValue<Vendor> vendor, ObservableList<Vendor> assignedEvents) {
        super(FXML);

        vendor.addListener((observable, oldValue, newValue) -> {
            showVendorDetails();
            setVendor(newValue);
        });

        VendorListPanel vendorListPanel = new VendorListPanel(assignedEvents, "Assigned Events");
        detailsChildrenPlaceholder.getChildren().add(vendorListPanel.getRoot());

    }

    private void setVendor(Vendor vendor) {
        this.vendor = vendor;
        name.setText(vendor.getName().fullName);
        phone.setText(vendor.getPhone().value);
        description.setText(vendor.getDescription().value);
    }

    private void showVendorDetails() {
        detailsHolder.setVisible(true);
        noVendorMsg.setVisible(false);
    }

}