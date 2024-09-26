import ldap

# Assuming 'attr' is a dictionary with 'cn' and 'sAMAccountName' keys
attr = {'cn': 'example_cn', 'sAMAccountName': 'example_samaccountname'}
dn = 'dc=example,dc=com'  # Replace with your LDAP DN

search_filter_cn = f"(cn={attr['cn']})"
search_filter_samaccountname = f"(sAMAccountName={attr['sAMAccountName']})"

try:
    l = ldap.initialize('ldap://ldap.example.com')  # Replace with your LDAP server URL
    l.simple_bind_s('cn=admin,dc=example,dc=com', 'password')  # Replace with your LDAP admin credentials

    l_search_cn = l.search(dn, ldap.SCOPE_SUBTREE, search_filter_cn)
    result_status_cn, result_data_cn = l.result(l_search_cn)

    if len(result_data_cn) > 0:
        print(f"Group with CN '{attr['cn']}' already exists.")
        
    else:
        try:
            l_search_samaccountname = l.search(dn, ldap.SCOPE_SUBTREE, search_filter_samaccountname)
            result_status_samaccountname, result_data_samaccountname = l.result(l_search_samaccountname)

            if len(result_data_samaccountname) > 0:
                print(f"Group with sAMAccountName '{attr['sAMAccountName']}' already exists.")
                
        except ldap.LDAPError as e:
            print(f"An error occurred: {e}")

except ldap.LDAPError as e:
    print(f"An error occurred: {e}")