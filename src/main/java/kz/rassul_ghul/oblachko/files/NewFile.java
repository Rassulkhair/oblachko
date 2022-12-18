package kz.rassul_ghul.oblachko.files;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@Setter
public class NewFile {
    private MultipartFile file;
    private UUID directoryId;
}
