import javax.persistence.*;
import java.io.Serializable;
import org.springframework.security.core.SpringSecurityCoreVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sso_provider_configuration")
@Getter
@Setter
@NoArgsConstructor
public class SsoProviderConfiguration implements Serializable {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String registrationId;

    private String clientId;

    private String clientSecret;

    private String clientAuthenticationMethod;

    private String authorizationGrantType;

    private String redirectUri;

    private String scope;

    private String clientName;

    private String authorizationUri;

    private String tokenUri;

    private String jwkSetUri;

    private String issuerUri;

    private String authenticationMethod;

    private String userNameAttributeName;

    private String userInfoUri;
}