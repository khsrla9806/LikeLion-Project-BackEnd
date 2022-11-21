package likelionhsu.likelionproject.web;

import likelionhsu.likelionproject.service.products.ProductsService;
import likelionhsu.likelionproject.web.dto.ProductsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductsApiController {
    private final ProductsService productsService;

    @PostMapping("/api/product/register")
    public Long save(@RequestBody ProductsSaveRequestDto requestDto) {
        return productsService.save(requestDto);
    }
}
