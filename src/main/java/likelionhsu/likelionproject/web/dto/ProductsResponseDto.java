package likelionhsu.likelionproject.web.dto;

import likelionhsu.likelionproject.domain.products.Products;
import lombok.Getter;

@Getter
public class ProductsResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String author;

    public ProductsResponseDto(Products entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.price = entity.getPrice();
        this.author = entity.getAuthor();
    }
}
