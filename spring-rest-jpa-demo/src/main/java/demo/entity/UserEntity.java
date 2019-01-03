package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue()
    private Long id;

    @JsonIgnore
    private Long createdUser;

    @JsonIgnore
    private Long updatedUser;

    @JsonIgnore
    private Date createdDate;

    @NotNull
    @Column(name = "NAME")
    @JsonView(UserView.Public.class)
    private String name;

    @JsonIgnore
    @Column(name = "USER_PASSWORD")
    @JsonView(UserView.Internal.class)
    private String password;

    @NotNull
    @Column(name = "EMAIL")
    @JsonView(UserView.Public.class)
    private String email;

    @Column(name = "GSM_NO")
    @JsonView(UserView.Public.class)
    private String gsmNo;

    @Column(name = "TCKN")
    @JsonView({UserView.PublicWithIdentityNumber.class, UserView.Internal.class})
    private String identityNumber;

    @Transient
    private boolean termAndConditions;
}
