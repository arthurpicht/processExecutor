package de.arthurpicht.processExecutor.outputHandler;

import de.arthurpicht.processExecutor.CollectionHandler;
import de.arthurpicht.processExecutor.StandardOutHandler;
import de.arthurpicht.utils.io.InputStreams;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StandardOutCollectionHandler implements StandardOutHandler, CollectionHandler {

    private List<String> lines;

    public StandardOutCollectionHandler() {
        this.lines = new ArrayList<>();
    }

    @Override
    public synchronized void handleOutput(InputStream inputStream) throws IOException {
        this.lines = InputStreams.toStrings(inputStream);
    }

    public synchronized List<String> getLines() {
        return this.lines;
    }

}
