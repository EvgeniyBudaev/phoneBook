package entity;

import java.util.Objects;

public class Phone {
    private int id;
    private int userId;
    private String phoneNumber;
    private int status;

    public Phone() {
    }

    public Phone(int id, int userId, String phoneNumber, int status) {
        this.id = id;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id == phone.id &&
                userId == phone.userId &&
                phoneNumber == phone.phoneNumber &&
                status == phone.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, phoneNumber, status);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", userId=" + userId +
                ", phoneNumber=" + phoneNumber +
                ", status=" + status +
                '}';
    }
}
