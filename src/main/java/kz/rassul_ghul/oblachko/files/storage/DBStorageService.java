package kz.rassul_ghul.oblachko.files.storage;

import kz.rassul_ghul.oblachko.Error;
import kz.rassul_ghul.oblachko.OblachkoException;
import kz.rassul_ghul.oblachko.files.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DBStorageService implements StorageService {

    private final FileDirectoryRepository fileDirectoryRepository;
    private final FileRepository fileRepository;

    @Override
    public void init() {

    }

    @Override
    public void store(NewFile newFile) {
        var directoryOpt = fileDirectoryRepository.findByExternalId(newFile.getDirectoryId());
        if (directoryOpt.isEmpty()) {
            throw new OblachkoException(Error.DIRECTORY_NOT_FOUND);
        }
        var directory = directoryOpt.get();
        File file = new File();
        UUID uniqueName = UUID.randomUUID();
        MultipartFile multipartFile = newFile.getFile();
        file.setName(uniqueName + "-" + multipartFile.getOriginalFilename());
        file.setSize(multipartFile.getSize());
        file.setType(multipartFile.getContentType());
        try {
            file.setData(multipartFile.getBytes());
        } catch (IOException exception) {
            throw new OblachkoException(exception);
        }
        file.setDirectory(directory);
        file.setDateCreated(LocalDateTime.now());
        try {
            byte[] bytes;
            bytes = multipartFile.getBytes();
            Files.write(Paths.get("/Users/shokanovrassulkhair/IdeaProjects/oblachko/src/main/resources/files/" + uniqueName + "-" + multipartFile.getOriginalFilename()), bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileRepository.save(file);

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

}
