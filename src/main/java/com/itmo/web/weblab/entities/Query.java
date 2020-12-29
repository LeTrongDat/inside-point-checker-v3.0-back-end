package com.itmo.web.weblab.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties({"id"})
public class Query implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "X is mandatory")
//    @Min(value = -2, message = "X should not be less than -2")
//    @Max(value = 2, message = "X should not be greater than 2")
    private Double x;

    @NotNull(message = "Y is mandatory")
//    @Min(value = -3, message = "Y should not be less than -3")
//    @Max(value = 5, message = "Y should not be greater than 5")
    private Double y;

    @NotNull(message = "R is mandatory")
//    @Min(value = 1, message = "R should not be less than 1")
//    @Max(value = 3, message = "R should not be greater than 3")
    private Double r;

    private String result;
    private Long executionTime;
    private Date creationTime;

    public String getResult() {
        if (this.x == null || this.y == null || this.r == null) return null;
        creationTime = new Date();
        this.executionTime = System.currentTimeMillis();
        this.result = isInsideArea() ? "Yes" : "No";
        this.executionTime = System.currentTimeMillis() - this.executionTime;
        return this.result;
    }

    // ------- Private methods -------
    private boolean isInsideArea() {
        return (isInsideCircle() || isInsideRectangle() || isInsideTriangle());
    }

    private boolean isInsideCircle() {
        if (-this.r / 2 <= this.x && this.x <= 0 && 0 <= this.y && this.y <= this.y / 2) {
            return Math.pow(this.x, 2) + Math.pow(this.x, 2) <= Math.pow(this.r, 2);
        }
        return false;
    }

    private boolean isInsideRectangle() {
        return -this.r <= this.x && this.x <= 0 && -this.r / 2 <= this.y && this.y <= 0;
    }

    private boolean isInsideTriangle() {
        if (0 <= this.x && this.x <= this.r && 0 <= this.y && this.y <= this.r / 2) {
            return (this.r - this.x) / 2 >= this.y;
        }
        return false;
    }

}
