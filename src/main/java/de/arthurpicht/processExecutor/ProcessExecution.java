package de.arthurpicht.processExecutor;

import de.arthurpicht.processExecutor.outputHandler.StandardErrorCollectionHandler;
import de.arthurpicht.processExecutor.outputHandler.StandardOutCollectionHandler;
import de.arthurpicht.processExecutor.outputHandler.generalOutputHandler.GeneralStandardErrorHandler;
import de.arthurpicht.processExecutor.outputHandler.generalOutputHandler.GeneralStandardOutHandler;
import org.slf4j.Logger;

import java.io.InputStream;
import java.util.List;

/**
 * Some end-user shortcuts for using process execution functionality.
 */
public class ProcessExecution {

    public static int executeInteractive(List<String> commandList) throws ProcessExecutionException {
        return executeInteractive(commandList.toArray(new String[0]));
    }

    public static int executeInteractive(String... commands) throws ProcessExecutionException {
        ProcessExecutor processExecutor = new ProcessExecutorBuilder()
                .withCommands(commands)
                .asInteractive()
                .build();
        return processExecutor.execute();
    }

    public static ProcessResultCollection execute(Logger logger, boolean toConsole, String... commands) throws ProcessExecutionException {
        GeneralStandardOutHandler stdOutHandler = new GeneralStandardOutHandler(logger, toConsole);
        GeneralStandardErrorHandler stdErrorHandler = new GeneralStandardErrorHandler(logger, toConsole);
        ProcessExecutor processExecutor = new ProcessExecutorBuilder()
                .withCommands(commands)
                .withStandardOutHandler(stdOutHandler)
                .withStandardErrorHandler(stdErrorHandler)
                .build();

        processExecutor.execute();

        return new ProcessResultCollection(
                processExecutor, stdOutHandler, stdErrorHandler
        );
    }

    public static ProcessResultCollection execute(
            StandardOutHandler standardOutHandler, StandardErrorHandler standardErrorHandler, String... commands)
            throws ProcessExecutionException {

        ProcessExecutor processExecutor = new ProcessExecutorBuilder()
                .withCommands(commands)
                .withStandardOutHandler(standardOutHandler)
                .withStandardErrorHandler(standardErrorHandler)
                .build();

        processExecutor.execute();

        return new ProcessResultCollection(
                processExecutor, standardOutHandler, standardErrorHandler
        );
    }


    public static ProcessResultCollection execute(Logger logger, boolean toConsole, InputStream inputStream, String... commands) throws ProcessExecutionException {
        GeneralStandardOutHandler stdOutHandler = new GeneralStandardOutHandler(logger, toConsole);
        GeneralStandardErrorHandler stdErrorHandler = new GeneralStandardErrorHandler(logger, toConsole);
        ProcessExecutor processExecutor = new ProcessExecutorBuilder()
                .withCommands(commands)
                .withInput(inputStream)
                .withStandardOutHandler(stdOutHandler)
                .withStandardErrorHandler(stdErrorHandler)
                .build();

        processExecutor.execute();

        return new ProcessResultCollection(
                processExecutor, stdOutHandler, stdErrorHandler
        );
    }

    public static ProcessResultCollection execute(
            InputStream inputStream, StandardOutHandler standardOutHandler, StandardErrorHandler standardErrorHandler,
            String... commands)
            throws ProcessExecutionException {
        ProcessExecutor processExecutor = new ProcessExecutorBuilder()
                .withCommands(commands)
                .withInput(inputStream)
                .withStandardOutHandler(standardOutHandler)
                .withStandardErrorHandler(standardErrorHandler)
                .build();

        processExecutor.execute();

        return new ProcessResultCollection(
                processExecutor, standardOutHandler, standardErrorHandler
        );
    }

    public static ProcessResultCollection execute(String... commands) throws ProcessExecutionException {
        StandardOutCollectionHandler stdOutHandler = new StandardOutCollectionHandler();
        StandardErrorCollectionHandler stdErrorHandler = new StandardErrorCollectionHandler();
        ProcessExecutor processExecutor = new ProcessExecutorBuilder()
                .withCommands(commands)
                .withStandardOutHandler(stdOutHandler)
                .withStandardErrorHandler(stdErrorHandler)
                .build();

        processExecutor.execute();

        return new ProcessResultCollection(
                processExecutor, stdOutHandler, stdErrorHandler
        );
    }

}
