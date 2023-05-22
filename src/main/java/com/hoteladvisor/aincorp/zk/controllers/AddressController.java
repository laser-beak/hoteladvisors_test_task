package com.hoteladvisor.aincorp.zk.controllers;

import com.hoteladvisor.aincorp.zk.models.Address;
import com.hoteladvisor.aincorp.zk.sevices.AddressPersistenceBeanRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import javax.ejb.EJB;
import java.util.List;

public class AddressController extends SelectorComposer<Component> {

    private final static Logger log = LoggerFactory.getLogger(AddressController.class);

    @Wire
    public Textbox keywordBox;

    @Wire
    public Listbox addressListBox;

    @Wire
    public Label idLabel;
    @Wire
    public Label indexLabel;
    @Wire
    public Label cityLabel;
    @Wire
    public Label streetLabel;
    @Wire
    public Label houseLabel;
    @Wire
    public Label flatLabel;
    @Wire
    public Label descriptionLabel;

    @EJB(beanName = "AddressPersistenceBeanRemote")
    private AddressPersistenceBeanRemote service;

    public AddressController() {
    }

    @Listen("onSelect = #addressListBox")
    public void showDetail() {
        Address selected = addressListBox.getSelectedItem().getValue();

        if (selected != null) {
            idLabel.setValue(String.valueOf(selected.getId()));
            indexLabel.setValue(String.valueOf(selected.getIndex()));
            cityLabel.setValue(selected.getCity());
            houseLabel.setValue(selected.getHouse());
            streetLabel.setValue(selected.getStreet());
            flatLabel.setValue(selected.getFlat());
            descriptionLabel.setValue("Описание");
        } else {
            indexLabel.setValue("");
            indexLabel.setValue("");
            cityLabel.setValue("");
            houseLabel.setValue("");
            streetLabel.setValue("");
            flatLabel.setValue("");
        }
    }

    @Listen("onClick = #searchButton")
    public void searchAddresses() {
        log.info("args @searchBox is {}", keywordBox.getValue());

        List<Address> addressList = service.findAll();
        addressListBox.setModel(new ListModelList<>(addressList));
    }
}
