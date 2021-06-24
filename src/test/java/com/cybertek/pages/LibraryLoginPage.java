package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    //1- Create constructor and initialize driver and object of the class
    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
