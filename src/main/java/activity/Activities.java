package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities =new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        int count = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                count++;
            }
        }
        return count;
    }

    public int numberOfWithoutTrackActivities() {
        int count = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithoutTrack) {
                count++;
            }
        }
        return count;
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        for (ActivityType activityType : ActivityType.values()) {
            double distance = 0;
            for (Activity activity : activities) {
                if (activity.getType() == activityType) {
                    distance += activity.getDistance();
                }
            }
            reports.add(new Report(activityType, distance));
        }
        return reports;
    }
}
