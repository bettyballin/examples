csharp
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

public enum Direction
{
    North,
    South,
    East,
    West
}

public class Program
{
    public static void SomeFunction(Direction direction)
    {
        if (!Enum.IsDefined(typeof(Direction), direction))
        {
            throw new ArgumentException("Invalid direction", nameof(direction));
        }
    }
}

[TestClass]
public class TestClass
{
    [TestMethod]
    [ExpectedException(typeof(ArgumentException))]
    public void SomeTestMethod()
    {
        Direction testValue = (Direction)-1;
        Assert.IsFalse(Enum.IsDefined(typeof(Direction), testValue));
        Program.SomeFunction((Direction)-1);
    }
}