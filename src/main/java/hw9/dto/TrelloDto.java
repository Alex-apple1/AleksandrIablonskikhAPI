package hw9.dto;

import java.util.List;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TrelloDto {
    private String name;
    private String id;
//    private List<String> altSpellings;
    private String idBoard;
//    private String region;
//    private String subregion;
//    private Long population;
//    private List<Float> latlng;
//    private String demonym;
//    private Long area;
//    private Float gini;
//    private List<String> timezones;
//    private List<String> callingCodes;
//    private List<String> topLevelDomain;
//    private List<String> currencies;
//    private List<String> languages;
}

