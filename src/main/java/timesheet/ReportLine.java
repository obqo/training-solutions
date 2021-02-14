package timesheet;

public class ReportLine {

    private final Project project;
    private long time;

    public ReportLine(Project project, long time) {
        this.project = project;
        this.time = time;
    }

    public void addTime(long bonus) {
        time += bonus;
    }

    public Project getProject() {
        return project;
    }

    public long getTime() {
        return time;
    }
}
