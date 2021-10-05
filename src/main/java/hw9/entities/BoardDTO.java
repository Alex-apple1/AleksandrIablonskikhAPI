package hw9.entities;

//import hw9.entities.subentities.LabelNames;
//import hw9.entities.subentities.Prefs;
import lombok.Data;

@Data
public class BoardDTO {
    public static final String NAME = "New test board";

    private String id;
    private String name;
//    private String desc;
//    private String descData;
//    private Boolean closed;
//    private String idOrganization;
//    private String idEnterprise;
//    private Boolean pinned;
//    private String url;
//    private String shortUrl;
//    private Prefs prefs;
//    private LabelNames labelNames;
//    private transient Object limits;
}
