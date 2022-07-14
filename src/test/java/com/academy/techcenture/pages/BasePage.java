package com.academy.techcenture.pages;

import com.academy.techcenture.utilities.CommonUtils;
import com.academy.techcenture.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected CommonUtils commonUtils;
    protected static Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
        this.commonUtils = new CommonUtils();
    }
}
