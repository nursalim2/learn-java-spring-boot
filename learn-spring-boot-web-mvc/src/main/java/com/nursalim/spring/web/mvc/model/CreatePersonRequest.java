package com.nursalim.spring.web.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private List<String> hobbies;
    private List<CreateSocialMediaRequest> createSocialMediaRequests;
    private CreateAddressRequest address;
}
