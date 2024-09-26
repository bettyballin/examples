csharp
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using Microsoft.Xaml.Behaviors;

public sealed class PasswordBoxBehavior : Behavior<UIElement>
{
    public static readonly DependencyProperty PasswordProperty =
        DependencyProperty.Register("Password", typeof(string), typeof(PasswordBoxBehavior), new PropertyMetadata(null));

    public string Password
    {
        get { return (string)GetValue(PasswordProperty); }
        set { SetValue(PasswordProperty, value); }
    }

    protected override void OnAttached()
    {
        base.OnAttached();
        AssociatedObject.LostKeyboardFocus += AssociatedObjectLostKeyboardFocus;
    }

    protected override void OnDetaching()
    {
        AssociatedObject.LostKeyboardFocus -= AssociatedObjectLostKeyboardFocus;
        base.OnDetaching();
    }

    void AssociatedObjectLostKeyboardFocus(object sender, KeyboardFocusChangedEventArgs e)
    {
        var associatedPasswordBox = AssociatedObject as PasswordBox;
        if (associatedPasswordBox != null)
        {
            Password = associatedPasswordBox.Password;
        }
    }
}