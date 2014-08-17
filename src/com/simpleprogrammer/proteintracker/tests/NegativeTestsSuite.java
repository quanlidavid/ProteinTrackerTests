package com.simpleprogrammer.proteintracker.tests;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(NegativeTestsCategory.class)
@SuiteClasses({ HelloJUnitTest.class, TrackingServiceTests.class })
public class NegativeTestsSuite {

}
