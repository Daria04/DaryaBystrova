package com.epam.tc.hw7.tests;

import com.epam.tc.hw7.Utils;
import com.epam.tc.hw7.entities.MetalAndColors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class ParseWithDataProvider {

    @DataProvider(name = "parseFromJson")
    public static Object[][] getData() throws IOException {
        Map<String, MetalAndColors> metalAndColorsMap = new ObjectMapper().readValue(
                new File(Utils.JSON_PATH),
                new TypeReference<>() {});
        Object[][] jsonObj = convertJsonObjToArrayOfObj(metalAndColorsMap);
        return jsonObj;
    }

    public static Object[][] convertJsonObjToArrayOfObj(Map<String, MetalAndColors> map) {
        Object[][] arrayOfObject = new Object[map.size()][1];
        int i = 0;
        for (Map.Entry<String, MetalAndColors> entry : map.entrySet()) {
            arrayOfObject[i][0] = entry.getValue();
            i++;
        }
        return arrayOfObject;
    }
}
