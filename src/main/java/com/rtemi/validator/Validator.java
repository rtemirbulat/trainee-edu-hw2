package com.rtemi.validator;
import static java.util.logging.Logger.getLogger;
import com.rtemi.loaders.JsonDataLoader;
import com.rtemi.model.BusTicket;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validator {
    public static final Logger LOGGER = getLogger(Validator.class.getSimpleName());

    public static void main(String[] args) throws IOException {
        String pathToSource = "src/main/resources/busTicket.json";
        JsonDataLoader<BusTicket> busTicketJsonDataLoader = new JsonDataLoader<>(pathToSource, BusTicket.class);
        List<BusTicket> busTickets = busTicketJsonDataLoader.getDataList();
        busTickets.forEach(busTicket -> LOGGER.log(Level.INFO, busTicket.toString()));


    }



    public Validator() throws IOException {
    }
}
