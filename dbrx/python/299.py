import unittest
import unittest.mock as mock

def my_function():
    my_class = MyClass()
    my_class.my_method()

class MyClass:
    def my_method(self):
        return "actual result"

class TestMyFunction(unittest.TestCase):
    @mock.patch('__main__.MyClass')
    def test_my_function(self, mock_class):
        # Set up the mocked class to return what we want when called
        instance = mock.Mock()
        instance.my_method.return_value = 'expected result'
        mock_class.return_value = instance
        
        my_function()  # Call your function with mocks in place

        self.assertTrue(instance.my_method.called, "my_method was not called")

if __name__ == '__main__':
    unittest.main()