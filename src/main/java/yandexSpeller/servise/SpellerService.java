package yandexSpeller.servise;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import yandexSpeller.dto.SpellerDTO;

public class SpellerService extends CommonService{
    private SpellerService spellerService;

    public SpellerService getInstance() {
        if (spellerService == null)
            spellerService = new SpellerService();

        return spellerService;
    }

    public SpellerDTO[] getAnswerByWrongSimpleWord(String name) {
        return
            new CommonService()
                .getNoParams(String.format(URI.CHECKTEXT_URI, name))
                .getBody().as(SpellerDTO[].class);
    }

    public SpellerDTO[] getCountryByCode(String word) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("word", word);

        return
            new Gson().fromJson(
                new CommonService()
                    .getWithParams(URI.CHECKTEXT_URI, params)
                    .getBody().asString(), SpellerDTO[].class);
    }
}
