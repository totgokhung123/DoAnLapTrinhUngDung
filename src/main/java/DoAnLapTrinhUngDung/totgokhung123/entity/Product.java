package DoAnLapTrinhUngDung.totgokhung123.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(max = 100, message = "Tên sản phẩm phải ít hơn 100 ký tự")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Giá sản phẩm không được để trống")
    @Size(min = 10000, message = "Gia sản phẩm ít nhất lớn hơn 10,000")
    @Column(name = "price")
    private double price;

    @NotBlank(message = "Số lượng sản phẩm không được để trống")
    @Size(min = 1, message = "Số lượng sản phẩm ít nhất lớn hơn 1")
    @Column(name = "sl")
    private double sl;

    @NotBlank(message = "mô tả sản phẩm không được để trống")
    @Size(max = 500, message = "mô tả phải ít hơn 500 ký tự")
    @Column(name = "description")
    private String description;

    @Future(message = "năm sản xuất không trước tương lai")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy")
    @Column(name = "NamSX")
    private Date NamSX;

    @Column(name = "MuTiImagePath")
    private String MuTiImagePath;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_path")
    private List<String> imagePaths;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "category_id",
            foreignKey = @ForeignKey(name = "FK_Product_Category")
    )
    private Category category;
}
