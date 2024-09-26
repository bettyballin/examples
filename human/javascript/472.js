const { Configuration } = require('oidc-provider');

const config = {
  sessionManagement: {
    sessionCreationPolicy: 'STATELESS',
  },
};

new Configuration(config);