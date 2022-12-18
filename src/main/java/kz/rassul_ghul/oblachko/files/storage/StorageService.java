package kz.rassul_ghul.oblachko.files.storage;


import kz.rassul_ghul.oblachko.files.NewFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;



public interface StorageService {
    void init();

    void store(NewFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
