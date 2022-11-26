package likelionhsu.likelionproject.domain.products;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "product_img")
@Entity
public class ProductImg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeImgName; // 이미지 파일명

    private String originalImgName; // 원본 이미지 파일명

    private String imgUrl; // 이미지 조회 경로

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Products product;

    @Builder
    public ProductImg(String originalImgName, String storeImgName, String imgUrl) {
        this.originalImgName = originalImgName;
        this.storeImgName = storeImgName;
        this.imgUrl = imgUrl;
    }

    public void updateProductImg(String originalImgName, String storeImgName, String imgUrl) {
        this.originalImgName = originalImgName;
        this.storeImgName = storeImgName;
        this.imgUrl = imgUrl;
    }
}
