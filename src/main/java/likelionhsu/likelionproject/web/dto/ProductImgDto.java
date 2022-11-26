package likelionhsu.likelionproject.web.dto;

import likelionhsu.likelionproject.domain.products.ProductImg;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ProductImgDto {
    private Long id;
    private String storeImgName; // 이미지 파일명
    private String originalImgName; // 원본 이미지 파일명
    private String imgUrl; // 이미지 조회 경로

    @Builder
    public ProductImgDto(String originalImgName, String storeImgName, String imgUrl) {
        this.originalImgName = originalImgName;
        this.storeImgName = storeImgName;
        this.imgUrl = imgUrl;
    }

    public ProductImg toEntity() {
        return ProductImg.builder()
                .originalImgName(originalImgName)
                .storeImgName(storeImgName)
                .imgUrl(imgUrl)
                .build();
    }
}
