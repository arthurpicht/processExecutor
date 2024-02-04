package de.arthurpicht.processExecutor.outputHandler.generalOutputHandler;

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
 *     <li>writes to console in real time (optional)</li>
 *     <li>writes to logger (optional)</li>
 *     <li>collects output for further processing</li>
 * </ul>
 */
public class GeneralStandardOutHandler extends AbstractGeneralOutputHandler implements StandardOutHandler {

    public static class Builder {
        private Logger logger = null;
        private boolean toConsole = false;
        private Level logLevel = Level.INFO;

        public Builder withLogger(Logger logger) {
            this.logger = logger;
            return this;
        }

        public Builder withLogLevel(Level logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public Builder withConsoleOutput() {
            this.toConsole = true;
            return this;
        }

        public GeneralStandardOutHandler build() {
            return new GeneralStandardOutHandler(this.logger, this.logLevel, this.toConsole);
        }
    }

    private GeneralStandardOutHandler(Logger logger, Level logLevel, boolean toConsole) {
        super(logger, logLevel, toConsole);
    }

    public GeneralStandardOutHandler(Logger logger, boolean toConsole) {
        super(logger, Level.INFO, toConsole);
    }

    @Override
    public void handleOutput(InputStream inputStream) throws IOException {
        super.handleOutput(inputStream);
    }

}
