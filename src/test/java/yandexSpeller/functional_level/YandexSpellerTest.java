package yandexSpeller.functional_level;

import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import yandexSpeller.dto.SpellerDTO;
import yandexSpeller.servise.SpellerService;

public class YandexSpellerTest {

    @Test
    void yandexSpellerPositiveTest() {
        String body =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:spel=\"http://speller.yandex.net/services/spellservice\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <spel:CheckTextRequest lang=\"?\" options=\"0\" format=\"\">\n" +
                "         <spel:text>lilt</spel:text>\n" +
                "      </spel:CheckTextRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        RestAssured
            .given().body(body)
            .when().post("http://speller.yandex.net/services/spellservice")
            .then().statusCode(200);
    }

    @Test(description = "Get country by one Code")
    public void getCountryByName() {
        String wrongSimpleWord = "Aruba";

        SpellerDTO[] word = new SpellerService().getAnswerByWrongSimpleWord(wrongSimpleWord);

        assertEquals(word.length, 1, "Incorrect list of wrong words");
        assertEquals(word[0].getWord(), wrongSimpleWord, "Incorrect wrong word");
    }
}
