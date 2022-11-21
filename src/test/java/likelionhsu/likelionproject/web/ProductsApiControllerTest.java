package likelionhsu.likelionproject.web;

import likelionhsu.likelionproject.domain.products.Products;
import likelionhsu.likelionproject.domain.products.ProductsRepository;
import likelionhsu.likelionproject.web.dto.ProductsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductsRepository productsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        productsRepository.deleteAll();
    }

    @Test
    public void Products_등록테스트() throws Exception {
        String title = "title";
        String content = "content";
        int price = 150000;
        String author = "kimhunsope@naver.com";
        ProductsSaveRequestDto requestDto = ProductsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .price(price)
                .author(author)
                .build();
        String url = "http://localhost:" + port + "/api/product/register";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody())
                .isGreaterThan(0L);
        List<Products> all = productsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getPrice()).isEqualTo(price);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);
    }
}