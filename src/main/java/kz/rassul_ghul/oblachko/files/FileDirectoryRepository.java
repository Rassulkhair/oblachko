package kz.rassul_ghul.oblachko.files;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileDirectoryRepository extends CrudRepository<FileDirectory, Long> {
    Optional<FileDirectory> findByExternalId(UUID externalId);
}
