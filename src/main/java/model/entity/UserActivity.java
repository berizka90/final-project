package model.entity;

import java.util.Objects;

public class UserActivity {
    public enum Status {
        PENDING,
        ACTIVE,
        END
    }
    private int id;
    private int userId;
    private int activityId;
    private int time;
    private Status status;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public int getTime() {
        return time;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setActivityId(int userActivity) {
        this.activityId = userActivity;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserActivity that = (UserActivity) o;
        return userId == that.userId &&
                activityId == that.activityId &&
                time == that.time &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, status);
    }

    @Override
    public String toString() {
        return "UserActivity{" +
                "id=" + id +
                ", userId=" + userId +
                ", activityId=" + activityId +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}
