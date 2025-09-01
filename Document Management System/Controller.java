@RestController
@RequestMapping("/api/metadata")
@RequiredArgsConstructor
public class DocumentMetadataController {
    private final DocumentMetadataRepository repository;

    @PostMapping
    public DocumentMetadata create(@RequestBody DocumentMetadata doc) {
        doc.setUploadDate(LocalDateTime.now());
        return repository.save(doc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentMetadata> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<DocumentMetadata> getAll(@RequestParam(required = false) String search) {
        return (search != null) ? repository.findByTitleContainingIgnoreCase(search)
                                : repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentMetadata> update(@PathVariable Long id, @RequestBody DocumentMetadata doc) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(doc.getTitle());
            existing.setDescription(doc.getDescription());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
