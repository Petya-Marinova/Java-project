package com.example.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {

    @NonNull
    @Size(min =2, message = "User`s first name should contain more than 2 letters")
    private String firstName;
    @NonNull
    @Size(min =3, message = "User`s last name should contain more than 2 letters")
    private String lastName;
    @NonNull
    @Email
    @Size(min =2, message = "Email should be in a valid format")
    private String email;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$", message = "" +
            "At least one upper case English letter\n" +
            "At least one lower case English letter\n" +
            "At least one digit\n" +
            "At least one special character\n" +
            "Minimum eight in length")
    private String password;

    @NonNull
    private String address;
}
