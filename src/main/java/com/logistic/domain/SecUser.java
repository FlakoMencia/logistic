package com.logistic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "sec_user", schema = "public", catalog = "ingeneo")
public class SecUser implements Serializable {

    @Serial
    private static final long serialVersionUID = -2656921031731949635L;


    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_sec_user")
    @SequenceGenerator(name = "seq_sec_user", sequenceName = "seq_sec_user", allocationSize = 1)
    private Long idUser;

    @Basic
    @Column(name = "cd_user", nullable = false, length = 150)
    private String cdUser;
    @Basic
    @Column(name = "st_password", nullable = false, length = 100)
    private String stPassword;
    @Basic
    @Column(name = "st_cre_user", length = 150)
    private String stCreUser;
    @Basic
    @Column(name = "dt_create", nullable = false)
    private Date dtCreate;
    @Basic
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Basic
    @Column(name = "st_mod_user", length = 150)
    private String stModUser;
    @Basic
    @Column(name = "dt_modify")
    private Date dtModify;
    @Basic
    @Column(name = "st_email", length = -1)
    private String stEmail;

    @OneToMany(mappedBy = "secUserByFkUser", fetch = FetchType.EAGER)
    @Getter(onMethod = @__(@JsonIgnore))
    @ToString.Exclude
    private Set<SecUserRole> secUserRoles;


}
