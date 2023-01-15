package com.automation.tests;

import com.automation.constants.Constants;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SampleGalenTest extends GalenTestNgTestBase {
    private WebDriver driver;

    @Override
    public WebDriver createDriver(Object[] objects) {
        driver = new ChromeDriver();
        return driver;
    }

    @Test(invocationCount = 5)
    public void welcomePage_shouldLookGood_onDesktopDevice() throws IOException {
        load("http://testapp.galenframework.com/", 1024, 768);
        String spec_file_path = Constants.SPECS_DIR + "welcomePage.spec";
//        checkLayout(spec_file_path, Arrays.asList("desktop"));

        LayoutReport layoutReport =
                Galen.checkLayout(driver, spec_file_path, Arrays.asList("desktop"));

        List<GalenTestInfo> tests = new LinkedList<>();
        GalenTestInfo test = GalenTestInfo.fromString("Welcome Page on Desktop");

        test.getReport().layout(layoutReport, "Welcome Page");
        tests.add(test);

        new HtmlReportBuilder().build(tests, "galen-html-reports");
    }

}
