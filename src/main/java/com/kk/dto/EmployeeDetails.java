package com.kk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {

        private int id;
        private String firstName;
        private String lastName;
        private String organization;
}
