package de.arthurpicht.processExecutor.outputHandler;

import de.arthurpicht.processExecutor.StandardOutHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Writes stdOut to console including all control characters.
 */
public class StandardOutToConsoleHandler implements StandardOutHandler {

    @Override
    public void handleOutput(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try (inputStreamReader) {
            int data = inputStreamReader.read();
            while(data != -1) {
                char theChar = (char) data;
                System.out.print(theChar);
                data = inputStreamReader.read();
            }
        }
    }

}
