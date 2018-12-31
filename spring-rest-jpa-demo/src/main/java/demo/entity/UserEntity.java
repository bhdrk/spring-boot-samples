package demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private String id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GSM_NO")
    private String gsmNo;

    @Column(name = "TCKN")
    private String tckn;
}
