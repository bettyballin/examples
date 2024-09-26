var xmlString = '<http><csrf token-repository-ref="tokenRepository"/></http><b:bean id="tokenRepository" class="org.springframework.security.web.csrf.CookieCsrfTokenRepository" p:cookieHttpOnly="false"/>';

var parser = new DOMParser();
var xmlDoc = parser.parseFromString(xmlString, "text/xml");

console.log(xmlDoc.documentElement);