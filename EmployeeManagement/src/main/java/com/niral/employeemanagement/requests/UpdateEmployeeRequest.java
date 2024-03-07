package com.niral.employeemanagement.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    private String name;
    private String jobTitle;
    private Double salary;
    private String managerName;
}
