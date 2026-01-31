package com.Jan2426Crud;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "crud2426")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ABCD {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String name;

    @NotNull
    @NotBlank
    @Positive
    private Double balance;
}
