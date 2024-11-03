package com.murat.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Firstname alani bos birakilamaz")
    @Size(min=3, max=40, message = "boyut mutlaka en az 3 en fzla 40 olmali")
    private String firstName;
    @NotEmpty(message = "Lastname alani bos birakilamaz")
    @Size(min=3, max=40)
    private String lastName;
    private String birthOfDate;
}
