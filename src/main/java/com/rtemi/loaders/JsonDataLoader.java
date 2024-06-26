package com.rtemi.loaders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtemi.model.TicketUID;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataLoader<T extends TicketUID> {

    private List<T> dataList;

    public JsonDataLoader(String jsonFilePath, Class<T> type) throws IOException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        dataList = objectMapper.readValue(
                new File(jsonFilePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, type)
        );
    }
    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

}
