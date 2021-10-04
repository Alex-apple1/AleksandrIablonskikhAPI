//package hw9.service;
//
//import com.google.gson.Gson;
//
//import hw9.dto.TrelloDto;
//import java.util.HashMap;
//import java.util.Map;
//
//public class RestCountriesService {
//    private RestCountriesService restCountriesService;
//
//    public RestCountriesService getInstance() {
//        if (restCountriesService == null)
//            restCountriesService = new RestCountriesService();
//
//        return restCountriesService;
//    }
//
//    public TrelloDto[] getBoardById(String boardId) {
//        return
//            new CommonService()
//                .getNoParams(String.format(URI.GET_BY_BOARD_ID_URI, boardId))
//                .getBody().as(TrelloDto[].class);
//    }
//
//    public TrelloDto[] getCountryByCode(String code) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("codes", code);
//
//        return
//            new Gson().fromJson(
//                new CommonService()
//                    .getWithParams(URI.GET_BY_COUNTRY_CODE_URI, params)
//                    .getBody().asString(), TrelloDto[].class);
//    }
//}
