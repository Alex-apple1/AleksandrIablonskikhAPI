package hw9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListDTO {
    public static final String NAME = "First list test";

    private String id;
    private String name;
    private String idBoard;
    private boolean closed;
}
