package functionalinterfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
@Builder
public class User {
    private String firstName;
    private String lastName;
    private int age;
}
