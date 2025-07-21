package com.mmt.tests;

import com.mmt.automation.base.BaseTest;
import com.mmt.automation.pages.*;
import org.testng.annotations.Test;

public class TrainBookingTest extends BaseTest {

    @Test
    public void bookTrainTicketTest() {
        HomePage home = new HomePage(driver);
        home.navigateToTrains();
        home.selectStations("Vadodara", "Surat");
        home.selectUpcomingFridayAfter9PM();
        home.selectClassAndSearch();

        TrainResultsPage results = new TrainResultsPage(driver);
        results.printAllTrainsAndPrices();
        results.selectFirstTrainAfter9PM();

        BookingPage booking = new BookingPage(driver);
        booking.fillTravelerDetails("Maharshi Mistry");
        booking.clickPayAndBook();
        booking.printErrorAndDetails();
    }
}