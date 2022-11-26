package likelionhsu.likelionproject.service.products;

import likelionhsu.likelionproject.domain.products.Products;
import likelionhsu.likelionproject.domain.products.ProductsRepository;
import likelionhsu.likelionproject.web.dto.ProductsResponseDto;
import likelionhsu.likelionproject.web.dto.ProductsSaveRequestDto;
import likelionhsu.likelionproject.web.dto.ProductsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto) {
        return productsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ProductsUpdateRequestDto requestDto) {
        Products products = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 상품이 없습니다. id = " + id));
        products.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getPrice());

        return id;
    }

    public ProductsResponseDto findById(Long id) {
        Products entity = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 상품이 없습니다. id = " + id));
        return new ProductsResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        Products products = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 상품이 없습니다. id = " + id));
        productsRepository.delete(products);
    }
}
