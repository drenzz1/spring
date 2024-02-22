package org.foo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "regions")
@NoArgsConstructor
public class Region {
    @Id
    private Long id;
    private String region;
    private String country;
}
