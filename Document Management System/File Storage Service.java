@RestController
@RequestMapping("/api/files")
public class FileController {

    private final String storagePath = "uploads/";

    @PostMapping("/upload-chunk")
    public ResponseEntity<String> uploadChunk(@RequestParam String fileId,
                                              @RequestParam int chunkNumber,
                                              @RequestParam("file") MultipartFile file) throws IOException {
        File dir = new File(storagePath + fileId);
        if (!dir.exists()) dir.mkdirs();
        File chunkFile = new File(dir, chunkNumber + ".part");
        file.transferTo(chunkFile);
        return ResponseEntity.ok("Chunk " + chunkNumber + " uploaded");
    }

    @PostMapping("/finalize-upload")
    public ResponseEntity<String> finalizeUpload(@RequestParam String fileId,
                                                 @RequestParam int totalChunks,
                                                 @RequestParam String finalFileName) throws IOException {
        File dir = new File(storagePath + fileId);
        File finalFile = new File(storagePath, finalFileName);
        try (FileOutputStream fos = new FileOutputStream(finalFile, true)) {
            for (int i = 1; i <= totalChunks; i++) {
                File chunk = new File(dir, i + ".part");
                Files.copy(chunk.toPath(), fos);
                chunk.delete();
            }
        }
        return ResponseEntity.ok("Upload completed: " + finalFileName);
    }

    @GetMapping("/download-chunk/{fileName}/{chunkNumber}/{chunkSize}")
    public ResponseEntity<byte[]> downloadChunk(@PathVariable String fileName,
                                                @PathVariable int chunkNumber,
                                                @PathVariable int chunkSize) throws IOException {
        File file = new File(storagePath, fileName);
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            byte[] buffer = new byte[chunkSize];
            raf.seek((long) (chunkNumber - 1) * chunkSize);
            int bytesRead = raf.read(buffer);
            return ResponseEntity.ok(Arrays.copyOf(buffer, bytesRead));
        }
    }
}
