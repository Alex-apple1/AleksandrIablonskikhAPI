package hw9.entities;

import lombok.Data;

@Data
public class List {
    public static final String NAME = "ToDo test list";

    private String id;
    private String name;
    private Boolean closed;
    private Integer pos;
    private String idBoard;
}
