package com.epam.tc.hw3;

import java.util.List;

public class Constants {

    public static final String EXPECTED_TITLE = "Home Page";
    public static final String EXPECTED_USER_NAME = "ROMAN IOVLEV";
    public static final List<String> EXPECTED_ITEMS_ON_THE_HEADER_SECTION =
            List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public static final List<String> ALL_EXPECTED_TEXT_UNDER_IMAGES =
            List.of("To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                    "To be flexible and\n" + "customizable", "To be multiplatform", "Already have good base\n"
                            + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
    public static final List<String> EXPECTED_ITEMS_IN_THE_LEFT_SECTION =
            List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    public static final List<String> EXPECTED_LOG_ROWS =
            List.of("Colors: value changed to Yellow", "metal: value changed to Selen",
                    "Wind: condition changed to true", "Water: condition changed to true");

}
