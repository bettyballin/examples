cpp
#include <iostream>
#include <string>
#include <bitset>
#include <vector>

// Multiplies str1 and str2, and prints result.
std::string multiply(std::string num1, std::string num2)
{
    int len1 = num1.size();
    int len2 = num2.size();
    if (len1 == 0 || len2 == 0)
    return "0";
 
    // will keep the result number in vector
    // in reverse order
    std::vector<int> result(len1 + len2, 0);
 
    // Below two indexes are used to find positions
    // in result.
    int i_n1 = 0;
    int i_n2 = 0;
     
    // Go from right to left in num1
    for (int i=len1-1; i>=0; i--)
    {
        int carry = 0;
        int n1 = num1[i] - '0';
 
        // To shift position to left after every
        // multiplication of a digit in num2
        i_n2 = 0;
         
        // Go from right to left in num2            
        for (int j=len2-1; j>=0; j--)
        {
            // Take current digit of second number
            int n2 = num2[j] - '0';
 
            // Multiply with current digit of first number
            // and add result to previously stored result
            // at current position.
            int sum = n1*n2 + result[i_n1 + i_n2] + carry;
 
            // Carry for next iteration
            carry = sum/10;
 
            // Store result
            result[i_n1 + i_n2] = sum % 10;
 
            i_n2++;
        }
 
        // store carry in next cell
        if (carry > 0)
            result[i_n1 + i_n2] += carry;
 
        // To shift position to left after every
        // multiplication of a digit in num1.
        i_n1++;
    }
 
    // ignore '0's from the right
    int i = result.size() - 1;
    while (i>=0 && result[i] == 0)
    i--;
 
    // If all were '0's - means either both or
    // one of num1 or num2 were '0'
    if (i == -1)
    return "0";
 
    // generate the result string
    std::string s = "";
     
    while (i >= 0)
        s += std::to_string(result[i--]);
 
    return s;
}

// A function to perform division of large numbers
std::string longDivision(std::string number, int divisor)
{
    // As result can be very large store it in string
    std::string ans;
 
    // Find prefix of number that is larger
    // than divisor.
    int idx = 0;
    int temp = number[idx] - '0';
    while (temp < divisor)
        temp = temp * 10 + (number[++idx] - '0');
 
    // Repeatedly divide divisor with temp. After
    // every division, update temp to include one
    // more digit.
    while (number.size() > idx) {
        // Store result in answer i.e. temp / divisor
        ans += (temp / divisor) + '0';
 
        // Take next digit of number
        if(idx + 1 < number.size())
            temp = (temp % divisor) * 10 + number[++idx] - '0';
        else
            break;
    }
 
    // If divisor is greater than number
    if (ans.length() == 0)
        return "0";
 
    // else return ans
    return ans;
}

int main()
{
    std::string strNumber = "174981883239023362650696299580"; 
    std::vector<bool> boolean;
    while (strNumber.size() > 0 && strNumber[0] != '0')
    {
        std::string temp = longDivision(strNumber, 2);
        if (multiply(temp, "2") == strNumber)    // if this is true there was no reminder on the division
            {boolean.push_back(0); std::cout << "0";}
        else 
            {boolean.push_back(1);std::cout << "1";}
        strNumber = temp;
    }
    std::cout<< std::endl;
    
    std::cout << "The number you are after: "; 
    for (int i = boolean.size()-1; i >= 0; i--)
    {
        std::cout << (int)boolean[i];
    }
    std::cout<< std::endl;
    
    return 0;
}