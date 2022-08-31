package de.arthurpicht.processExecutor.outputHandler.generalOutputHandler;

import de.arthurpicht.processExecutor.CollectionHandler;
import de.arthurpicht.processExecutor.ProcessExecutor;
import de.arthurpicht.processExecutor.StandardOutHandler;
import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.io.IOException;
import java.io.InputStream;

/**
 * Handles standard out of {@link ProcessExecutor} for different destinations:
 *
 * <ul>
 *     <li>writes to console in real time</li>
 *     <li>writes to logger</li>
 *     <li>collects output for further processing</li>
 * </ul>
 */
public class GeneralStandardOutHandler extends AbstractGeneralOutputHandler implements StandardOutHandler, CollectionHandler {

    public GeneralStandardOutHandler(Logger logger, boolean toConsole) {
        super(logger, Level.INFO, toConsole);
    }

    @Override
    public void handleOutput(InputStream inputStream) throws IOException {
        super.handleOutput(inputStream);
    }

}
