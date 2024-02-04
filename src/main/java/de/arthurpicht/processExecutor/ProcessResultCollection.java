package de.arthurpicht.processExecutor;

import java.util.ArrayList;
import java.util.List;

public class ProcessResultCollection {

    private final int exitCode;
    private final List<String> stdOutLines;
    private final List<String> errorOutLines;

    public ProcessResultCollection(
            ProcessExecutor processExecutor,
            StandardOutHandler standardOutHandler) {
        this.exitCode = processExecutor.getExitCode();
        this.stdOutLines = standardOutHandler.getLines();
        this.errorOutLines = new ArrayList<>();
    }

    public ProcessResultCollection(
            ProcessExecutor processExecutor,
            StandardOutHandler standardOutHandler,
            StandardErrorHandler standardErrorHandler) {
        this.exitCode = processExecutor.getExitCode();
        this.stdOutLines = standardOutHandler.getLines();
        this.errorOutLines = standardErrorHandler.getLines();
    }

    public int getExitCode() {
        return exitCode;
    }

    public List<String> getStandardOut() {
        return stdOutLines;
    }

    public List<String> getErrorOut() {
        return errorOutLines;
    }

    public boolean isSuccess() {
        return this.exitCode == 0;
    }

    public boolean isFail() {
        return this.exitCode != 0;
    }

}
