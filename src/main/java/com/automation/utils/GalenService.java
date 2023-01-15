package com.automation.utils;

import com.automation.constants.Constants;
import com.automation.drivers.DriverManager;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GalenService {
    private LayoutReport layoutReport;
    public static final List<GalenTestInfo> galenTestInfos = new ArrayList<>();

    public void checkLayout(String specFileName, String tags) throws IOException {
        Dimension dimension = new Dimension(1366, 768);
        String specFilePath = Constants.SPECS_DIR + specFileName;

        DriverManager.getDriver().manage().window().setSize(dimension);
        layoutReport = Galen.checkLayout(DriverManager.getDriver(), specFilePath, Collections.singletonList(tags));
    }

    public void generateLayoutReport(String specFileName) throws IOException {
        GalenTestInfo galenTestInfo = GalenTestInfo.fromString(specFileName);
        galenTestInfo.getReport().layout(layoutReport, "Verify Design Layout for " + specFileName);
        galenTestInfos.add(galenTestInfo);

        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        htmlReportBuilder.build(galenTestInfos, "galen-html-reports");

        if (layoutReport.errors() > 0)
            Assert.fail("Spec File - " + specFileName + " has " + layoutReport.errors() + " errors");
    }

}
