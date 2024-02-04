package de.arthurpicht.processExecutor;

import java.io.IOException;
import java.io.InputStream;

public interface StandardOutHandler extends CollectionHandler {

    void handleOutput(InputStream inputStream) throws IOException;

}
