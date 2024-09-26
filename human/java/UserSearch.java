// XML Configuration
<bean id="initialDirContextFactory" class="com.AA.BB.LdapConfig"/>
<bean id="authoritiesPopulator" class="com.AA.BB.AuthoritiesPopulator"/>
<bean id="userSearch" class="com.AA.BB.UserSearch">        
    <constructor-arg index="0" ref="initialDirContextFactory"/>
    <property name="searchSubtree" value="true"/>
</bean>

// Java Code
package com.AA.BB;

import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.ldap.search.LdapUserSearch;

public class UserSearch implements LdapUserSearch {
    private BaseLdapPathContextSource contextSource;
    private String searchBase;
    private String searchFilter;

    public UserSearch(BaseLdapPathContextSource contextSource) {
        this.contextSource = contextSource;
        this.searchBase = "OU=AA,DC=US,DC=BB,DC=local";
        this.searchFilter = "(sAMAccountName={0})";
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails searchForUser(String username) {
        // Implement the search logic here
        return null;
    }

    // Getters and setters for searchBase and searchFilter if needed
    public String getSearchBase() {
        return searchBase;
    }

    public void setSearchBase(String searchBase) {
        this.searchBase = searchBase;
    }

    public String getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(String searchFilter) {
        this.searchFilter = searchFilter;
    }
}