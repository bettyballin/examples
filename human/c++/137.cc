cpp
#include <iostream>
using namespace std;

long long productModulo(int n, int arr[], int m) {
    long long product = 1;
    for (int i = 0; i < n; i++) {
        product = (product * (arr[i] % m)) % m;
    }
    return product;
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    int arr[n];
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int m;
    cout << "Enter the modulo value: ";
    cin >> m;

    cout << "Product modulo " << m << ": " << productModulo(n, arr, m);
    return 0;
}