package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {

    private final List<Project> projects = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company(InputStream employeesFiles, InputStream projectsFiles) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(employeesFiles))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String firstname = line.split(" ")[0];
                String lastname = line.split(" ")[1];
                employees.add(new Employee(firstname, lastname));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(projectsFiles))) {
            String line;
            while ((line = reader.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        List<ReportLine> result = new ArrayList<>();
        for (Project p : projects) {
            result.add(new ReportLine(p, 0));
        }
        isNotValidName(result, employeeName, year, month);
        return result;
    }

    private void isNotValidName (List<ReportLine> result, String employeeName, int year, int month) {
        boolean notValidName = true;
        for (TimeSheetItem t : timeSheetItems) {
            if (t.getEmployee().getName().equals(employeeName)) {
                for (ReportLine r : result) {
                    if (r.getProject().getName().equals(t.getProject().getName())) {
                        notValidName = false;
                        if (t.getBeginDate().getYear() == year && t.getBeginDate().getMonthValue() == month) {
                            r.addTime(t.hoursBetweenDates());
                        }
                    }
                }
            }
        }
        if (notValidName) {
            throw new IllegalArgumentException("Invalid name!");
        }
    }

    public void printToFile(String employeeName, int year, int month, Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            int sum = 0;
            List<ReportLine> noZeroTime = new ArrayList<>();
            for (ReportLine r : calculateProjectByNameYearMonth(employeeName, year, month)) {
                if (r.getTime() != 0) {
                    noZeroTime.add(r);
                    sum += r.getTime();
                }
            }
            String monthStr = month < 10 ? "-0" + month : "-" + month;
            writer.write(employeeName + "\t" + year + monthStr + "\t" + sum + "\n");
            for (ReportLine r : noZeroTime) {
                writer.write(r.getProject().getName() + "\t" + r.getTime() + "\n");
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file!, ioe");
        }

    }
}
