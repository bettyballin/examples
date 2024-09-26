There is no JavaScript code provided. The text appears to be the output of a WHOIS query. 

If you're looking to parse this output in JavaScript, here's an example of how you could do it:


const whoisData = `
$ whois macromediasetup.com
[Querying whois.verisign-grs.com]
[Redirected to whois.PublicDomainRegistry.com]
[Querying whois.PublicDomainRegistry.com]
[whois.PublicDomainRegistry.com]
Registration Service Provided By: DOMAIN NAMES REGISTRAR REG.RU LTD.
Contact: +7.4955801111

Domain Name: MACROMEDIASETUP.COM

Registrant:
    PrivacyProtect.org
    Domain Admin        (contact@privacyprotect.org)
    P.O. Box 97
    Note - All Postal Mails Rejected, visit Privacyprotect.org
    Moergestel
    null,5066 ZH
    NL
    Tel. +45.36946676

Creation Date: 28-May-2010
Expiration Date: 28-May-2011

Domain servers in listed order:
    ns2.reg.ru
    ns1.reg.ru


Administrative Contact:
    PrivacyProtect.org
    Domain Admin        (contact@privacyprotect.org)
    P.O. Box 97
    Note - All Postal Mails Rejected, visit Privacyprotect.org
    Moergestel
    null,5066 ZH
    NL
    Tel. +45.36946676

Technical Contact:
    PrivacyProtect.org
    Domain Admin        (contact@privacyprotect.org)
    P.O. Box 97
    Note - All Postal Mails Rejected, visit Privacyprotect.org
    Moergestel
    null,5066 ZH
    NL
    Tel. +45.36946676

Billing Contact:
    PrivacyProtect.org
    Domain Admin        (contact@privacyprotect.org)
    P.O. Box 97
    Note - All Postal Mails Rejected, visit Privacyprotect.org
    Moergestel
    null,5066 ZH
    NL
    Tel. +45.36946676
`;

const parseWhois = (data) => {
  const lines = data.trim().split('\n');
  const result = {};

  lines.forEach((line) => {
    if (line.startsWith('Domain Name:')) {
      result.domainName = line.split(':').pop().trim();
    } else if (line.startsWith('Creation Date:')) {
      result.creationDate = line.split(':').pop().trim();
    } else if (line.startsWith('Expiration Date:')) {
      result.expirationDate = line.split(':').pop().trim();
    } else if (line.startsWith('Domain servers in listed order:')) {
      result.nameServers = [];
      for (let i = 1; i < 3; i++) {
        result.nameServers.push(lines[lines.indexOf(line) + i].trim());
      }
    }
  });

  return result;
};

console.log(parseWhois(whoisData));