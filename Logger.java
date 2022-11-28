import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

public class Logger
{
    public static void log(String s)
    {
        System.out.println(s);
    }

    private static List<String> getMethodNames(Method[] methods)
    {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());

        return methodNames;
    }

    private static List<String> getFieldNames(Field[] fields)
    {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());

        return fieldNames;
    }

    public static void printClassInfo(String className)
    {
        try
        {
            Class<?> clazz = Class.forName(className);

            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();

            List<String> actualFields = getFieldNames(fields);
            List<String> actualMethods = getMethodNames(methods);

            log(actualFields.toString());
            log(actualMethods.toString());
        }
        catch (ClassNotFoundException e)
        {
            log("unable to load class");
        }
        
    }

    public static void main(String[] args) throws ClassNotFoundException
    {
        printClassInfo("Animal");

    }
}
