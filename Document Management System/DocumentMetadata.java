@Entity
@Table(name = "documents")
public class DocumentMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String fileName;
    private Long fileSize;
    private LocalDateTime uploadDate;
    private String uploadedBy;
}
