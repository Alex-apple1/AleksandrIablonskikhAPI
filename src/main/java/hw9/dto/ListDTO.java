package hw9.dto;

import lombok.Data;

@Data
public class ListDTO {
    public static final String NAME = "First list test";

    private String id;
    private String name;
    private String idBoard;
}
