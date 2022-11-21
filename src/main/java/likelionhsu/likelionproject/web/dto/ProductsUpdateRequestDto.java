package likelionhsu.likelionproject.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductsUpdateRequestDto {
    private String title;
    private String content;
    private int price;

    @Builder
    public ProductsUpdateRequestDto(String title, String content, int price) {
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
