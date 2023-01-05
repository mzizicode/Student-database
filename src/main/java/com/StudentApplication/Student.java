package com.StudentApplication;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table
@Entity
@EqualsAndHashCode
public class Student {
   @Id
   @SequenceGenerator(
           name = "student_sequence",
           sequenceName = "student_sequence"
   )
    @GeneratedValue(
            generator = "student_sequence",
            strategy =  GenerationType.SEQUENCE

   )

    private Long id;
   @NotNull
   @Column(nullable = false)
    private String firstName;
   @Email
   @Column(nullable = false,unique = true)
    private String email;
   @NotNull
   @Column(nullable = false)
    private Gender gender;

}
