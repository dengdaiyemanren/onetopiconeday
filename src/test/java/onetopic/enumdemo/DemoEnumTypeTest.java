package onetopic.enumdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DemoEnumTypeTest
{
    @Test
    public void compare()
    {
        String enumValue = DemoEnumType.RED.toString();
        String exceptValue ="red";
        assertEquals("equals",enumValue,exceptValue);
    }
}
