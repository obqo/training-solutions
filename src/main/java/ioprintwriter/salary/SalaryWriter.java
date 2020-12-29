package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {

    private List<String> names = new ArrayList<>();

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String name : names) {
                writer.print(name);
                writer.print(": ");
                if (name.startsWith("Dr")) {
                    writer.println(500_000);
                } else if (name.startsWith("Mr")) {
                    writer.println(200_000);
                } else writer.println(100_000);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file!", ioe);
        }
    }
}
