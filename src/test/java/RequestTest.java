import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renwu on 2017/6/16.
 */
public class RequestTest extends CommonTest{

    @Test
    public void comTest(){
        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
        ResponseEntity responseEntity = sendRequest(formData, "/request/test");
        System.out.println(responseEntity);
    }

    @Test
    public void testMap(){
        Map<String,String> map = new HashMap<>();
        map.put("aaa","aaa");
        map.put("bbb","bbb");
        ResponseEntity responseEntity = sendRequestJson(map, "/request/testRequestBody");
        System.out.println(responseEntity);
    }
}
