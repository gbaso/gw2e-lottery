package com.github.gbaso.gw2elottery.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Equals and hash code implemented according to <a
 * href=https://thorben-janssen.com/ultimate-guide-to-implementing-equals-and-hashcode-with-hibernate/>Ultimate
 * Guide to Implementing equals() and hashCode() with Hibernate</a>
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    @Column(nullable = false)
    private Integer version;

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        return id != null && id.equals(other.id);
    }

}
