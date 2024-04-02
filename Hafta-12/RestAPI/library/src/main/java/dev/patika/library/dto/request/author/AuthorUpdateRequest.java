package dev.patika.library.dto.request.author;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda.")
    private int id;
    @NotNull(message = "Yazar adı null olamaz.")
    @NotEmpty(message = "Yazar adı boş olamaz.")
    private String name;
    @NotNull(message = "Yazar doğum tarihi null olamaz.")
    private LocalDate birthday;
    @NotNull(message = "Yazar şehri null olamaz.")
    @NotEmpty(message = "Yazar şehri boş olamaz.")
    private String country;
}
