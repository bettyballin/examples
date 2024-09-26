package org.my.foosoft.authn;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class JaasDelegatingLdapSam {
    private String ldapUrl;
    private String ldapSearchBase;
    private String ldapSearchFilter;

    public JaasDelegatingLdapSam(String ldapUrl, String ldapSearchBase, String ldapSearchFilter) {
        this.ldapUrl = ldapUrl;
        this.ldapSearchBase = ldapSearchBase;
        this.ldapSearchFilter = ldapSearchFilter;
    }

    public boolean authenticate(String username, String password) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=" + username + "," + ldapSearchBase);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext ctx = new InitialDirContext(env);
            ctx.close();
            return true;
        } catch (NamingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String ldapUrl = "ldap://localhost:389";
        String ldapSearchBase = "dc=example,dc=com";
        String ldapSearchFilter = "(uid={0})";

        JaasDelegatingLdapSam ldapSam = new JaasDelegatingLdapSam(ldapUrl, ldapSearchBase, ldapSearchFilter);
        boolean isAuthenticated = ldapSam.authenticate("testuser", "testpassword");

        if (isAuthenticated) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}