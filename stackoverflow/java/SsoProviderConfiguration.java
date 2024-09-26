import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.SpringSecurityCoreVersion;

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