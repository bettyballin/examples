
#include <stdio.h>
#include <modsecurity/modsecurity.h>
#include <modsecurity/rules.h>
#include <modsecurity/transaction.h>

const char *basic_rules = "SecRuleEngine On\n";

int main() {
    ModSecurity *modsec = msc_init();
    Rules *rules = msc_create_rules_set();
    const char *error = NULL;

    if (msc_rules_add(rules, basic_rules, &error) < 0) {
        fprintf(stderr, "Error adding rules: %s\n", error);
        return -1;
    }

    Transaction *transaction
