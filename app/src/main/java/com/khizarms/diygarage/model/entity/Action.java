package com.khizarms.diygarage.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Service.class,
            childColumns = "service_id",
            parentColumns = "service_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Action implements Serializable {

  private static final long serialVersionUID = -8522256879590658546L;

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "action_id")
  private long id;

  @ColumnInfo(name = "service_id", index = true)
  private long serviceId;

  private String summary;

  private String description;

  @NonNull
  private ServiceType serviceType;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getServiceId() {
    return serviceId;
  }

  public void setServiceId(long serviceId) {
    this.serviceId = serviceId;
  }

  @NonNull
  public ServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(@NonNull ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  public enum ServiceType {

    MOTOR,
    TRANSMISSION,
    COSMETIC,

  }
}
