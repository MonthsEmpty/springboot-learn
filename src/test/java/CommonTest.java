import com.vincent.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renwu on 2017/6/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class CommonTest {

    @Autowired
    protected TestRestTemplate testRestTemplate;
    @Autowired
    private EmbeddedWebApplicationContext server;
    protected HttpHeaders headers = new HttpHeaders();
    protected static List<String> cookie = new ArrayList<>();

    @Before
    public void prepare(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (null != cookie && !cookie.isEmpty()) {
            for (String s : cookie) {
                headers.add(HttpHeaders.COOKIE, s);
            }
        }
    }

    protected ResponseEntity<String> sendRequest(Object formData, String requestUri) {
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<String> entity = testRestTemplate.exchange(
//                "http://localhost:{port}/{path}",
                "http://localhost:{port}/vincent/{path}",
                HttpMethod.GET,
                new HttpEntity<>(formData, headers),
                String.class,
                server.getEmbeddedServletContainer().getPort(),
                requestUri
        );
        return entity;
    }

    protected ResponseEntity<String> sendRequestJson(Object formData, String requestUri) {
        ResponseEntity<String> entity = testRestTemplate.exchange(
                "http://localhost:{port}/{path}",
                HttpMethod.GET,
                new HttpEntity<>(formData, headers),
                String.class,
                server.getEmbeddedServletContainer().getPort(),
                requestUri
        );
        return entity;
    }
}
