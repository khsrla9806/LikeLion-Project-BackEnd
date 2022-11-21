package likelionhsu.likelionproject.web;

import likelionhsu.likelionproject.service.products.ProductsService;
import likelionhsu.likelionproject.web.dto.ProductsResponseDto;
import likelionhsu.likelionproject.web.dto.ProductsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductsApiController {
    private final ProductsService productsService;

    @PostMapping("/api/product/register")
    public Long save(@RequestBody ProductsSaveRequestDto requestDto) {
        return productsService.save(requestDto);
    }

    @GetMapping("/api/product/{id}")
    public ProductsResponseDto findById(@PathVariable Long id) {
        return productsService.findById(id);
    }
}
