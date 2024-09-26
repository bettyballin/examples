package org.my.foosoft.authn;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class StandaloneLdapSam {

    public static void main(String[] args) {
        String ldapUrl = "ldap://localhost:389";
        String baseDn = "dc=example,dc=com";
        String userDn = "cn=admin,dc=example,dc=com";
        String password = "password";
        String searchFilter = "(objectClass=person)";

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userDn);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext ctx = new InitialDirContext(env);
            NamingEnumeration<?> namingEnum = ctx.search(baseDn, searchFilter, null);

            while (namingEnum.hasMore()) {
                Attributes attrs = ((javax.naming.directory.SearchResult) namingEnum.next()).getAttributes();
                System.out.println(attrs);
            }
            namingEnum.close();
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}