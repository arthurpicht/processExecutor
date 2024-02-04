package de.arthurpicht.processExecutor.outputHandler.generalOutputHandler;

import de.arthurpicht.processExecutor.ProcessExecutor;
import de.arthurpicht.processExecutor.StandardErrorHandler;
import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.io.IOException;
import java.io.InputStream;

/**
 * Handles standard out of {@link ProcessExecutor} for different destinations:
 *
 * <ul>
 *     <li>writes to console in real time (optional)</li>
 *     <li>writes to logger (optional)</li>
 *     <li>collects output for further processing</li>
 * </ul>
 */
public class GeneralStandardErrorHandler extends AbstractGeneralOutputHandler implements StandardErrorHandler {

    public static class Builder {
        private Logger logger = null;
        private boolean toConsole = false;
        private Level logLevel = Level.ERROR;

        public GeneralStandardErrorHandler.Builder withLogger(Logger logger) {
            this.logger = logger;
            return this;
        }

        public GeneralStandardErrorHandler.Builder withLogLevel(Level logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public GeneralStandardErrorHandler.Builder withConsoleOutput() {
            this.toConsole = true;
            return this;
        }

        public GeneralStandardErrorHandler build() {
            return new GeneralStandardErrorHandler(this.logger, this.logLevel, this.toConsole);
        }
    }

    private GeneralStandardErrorHandler(Logger logger, Level logLevel, boolean toConsole) {
        super(logger, Level.ERROR, toConsole);
    }

    public GeneralStandardErrorHandler(Logger logger, boolean toConsole) {
        super(logger, Level.ERROR, toConsole);
    }

    @Override
    public void handleOutput(InputStream inputStream) throws IOException {
        super.handleOutput(inputStream);
    }

}
