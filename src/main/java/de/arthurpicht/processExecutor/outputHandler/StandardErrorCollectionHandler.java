package de.arthurpicht.processExecutor.outputHandler;

import de.arthurpicht.processExecutor.CollectionHandler;
import de.arthurpicht.processExecutor.StandardErrorHandler;
import de.arthurpicht.utils.io.InputStreams;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StandardErrorCollectionHandler implements StandardErrorHandler, CollectionHandler {

    private List<String> lines;

    public StandardErrorCollectionHandler() {
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
