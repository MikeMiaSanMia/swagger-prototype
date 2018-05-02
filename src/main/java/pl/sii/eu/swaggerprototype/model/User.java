package pl.sii.eu.swaggerprototype.model;

import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(access = "private", name = "userName", example = "John", value = "Name of the User")
    private String userName;

    @ApiModelProperty(access = "private", name = "userName", example = "8000L", value =  "Salary of the User")
    private Long salary;

    public User() {
    }

    public User(String userName, Long salary) {
        this.userName = userName;
        this.salary = salary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
