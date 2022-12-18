package kz.rassul_ghul.oblachko.files;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long size;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime dateCreated;

    @Column
    @LastModifiedDate
    private LocalDateTime dateModified;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directory_id", nullable = false)
    private FileDirectory directory;

}
