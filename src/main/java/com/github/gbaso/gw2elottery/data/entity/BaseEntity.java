package com.github.gbaso.gw2elottery.data.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

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
    @GeneratedValue(generator = "seq_generator")
    @GenericGenerator(name = "seq_generator", strategy = "sequence", parameters = {
            @Parameter(name = SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1") })
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
