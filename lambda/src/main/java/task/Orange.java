package task;

import lombok.*;

//@Getter
//@Setter
//@ToString
@Data
@Builder    //easy create object instead of "... = new Orange()"

// we usually use @Data and @NoArgsConstructor

public class Orange {
    private int weight;
    private Color color;
}

//@Builder generates an @AllArgsConstructor unless there is another @XConstructor