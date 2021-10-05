package hw9.entities;

import lombok.Data;

@Data
public class ListDTO {
    public static final String NAME = "One list test";

    private String id;
    private String name;
//    private Boolean closed;
//    private Integer pos;
    private String idBoard;
}
