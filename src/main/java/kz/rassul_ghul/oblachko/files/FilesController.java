package kz.rassul_ghul.oblachko.files;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

import kz.rassul_ghul.oblachko.files.storage.StorageService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
@Tag(name = "Files")
public class FilesController {
    private final StorageService storageService;

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FilesController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String testMethod() {
        return "para";
    }

    @PostMapping("/")
    public void saveFile(@RequestParam MultipartFile multipartFile, @RequestParam UUID directoryId) {
        NewFile file = new NewFile();
        file.setFile(multipartFile);
        file.setDirectoryId(directoryId);
        storageService.store(file);
    }
}
