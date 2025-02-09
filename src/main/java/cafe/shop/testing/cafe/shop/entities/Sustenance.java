package cafe.shop.testing.cafe.shop.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity

@Table(name = "sustenance")
public class Sustenance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "type_id")
  private Type type;

  @Lob
  @Column(columnDefinition = "MEDIUMBLOB")
  private String img;

  @Column(name = "description")
  private String desc;

  @Column(name = "last_update")
  private Timestamp lastUpdated;

  private boolean isActive = true;



  public Sustenance() {}

  public Sustenance(String name, Type type, String img, String desc, Timestamp lastUpdated, boolean isActive) {
    this.name = name;
    this.type = type;
    this.img = img;
    this.desc = desc;
    this.lastUpdated = lastUpdated;
    this.isActive = isActive;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Timestamp getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Timestamp lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  

  
}
