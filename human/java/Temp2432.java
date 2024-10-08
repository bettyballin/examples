cpp
#include <bits/stdc++.h>
using namespace std;

void create(int i, string domain, vector<bool> &included, string str, int len) {
    if(i == len) {
        cout << str << endl;
        return;
    }
    for(int j = 0; j < domain.length(); j++) {
        if(included[j] == 1)
            continue;
        else {
            included[j] = 1;
            str += domain[j];
            create(i + 1, domain, included, str, len);
            included[j] = 0;
            str.pop_back();
        }
    }
}

int main() {
    string domain = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_$#-~";
    int lo = 1;
    int hi = 10;
    for(int i = lo; i <= hi; i++) {
        int len = i;
        string str;
        vector<bool> included(domain.length(), 0);
        create(0, domain, included, str, len);
    }
    return 0;
}