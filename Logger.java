import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

import java.io.*;
import java.util.*;

import java.text.SimpleDateFormat;

public class Logger
{
    public static final PrintStream console = System.out;

    private PrintStream outFilePrintStream;
    private static boolean printToFile = false;
    
    private void setPrintToFile(String fileName)
    {
        try
        {
            outFilePrintStream = new PrintStream(new File(fileName));
            System.setOut(outFilePrintStream);
            printToFile = true;
        }
        catch (IOException e)
        {
            log("ERROR", String.format("output file %s not found."));
        }
    }

    private void setPrintToOutput()
    {
        System.setOut(console);
        printToFile = false;
    }

    public Logger(String fileName)
    {
        setPrintToFile(fileName);
    }

    public Logger()
    {
        setPrintToOutput();
    }

    public static void log(String s)
    {
        System.out.println(s);
    }

    public static void log(String type, String content)
    {
        List<String> validLogs = Arrays.asList("ERROR","INFO","LOG", "TEST");

        if(!validLogs.contains(type))
        {
            log("ERROR", String.format("log type %s not provided.", type));
            return;
        }
        else
        {
            System.out.println(String.format("[%s] %s", type, content));
        }
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
        System.out.println("-----------------");

        try
        {
            Class<?> clazz = Class.forName(className);

            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();

            List<String> actualFields = getFieldNames(fields);
            List<String> actualMethods = getMethodNames(methods);

            log("LOG", String.format("fields of %s: ", className));
            log(actualFields.toString());
            log("");
            log("LOG", String.format("methods of %s: ", className));
            log(actualMethods.toString());
        }
        catch (ClassNotFoundException e)
        {
            log(String.format("unable to load class: %s", className));
        }

        System.out.println("-----------------");
    }

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException
    {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd_hh:mm"); 

        Logger fileOut = new Logger("outputtest.log");

        fileOut.printClassInfo("Animal");
        fileOut.printClassInfo("Exhibit");

        Animal testAnimal = new Animal();
        Thread.sleep(1000);
        Animal testAnimal2 = new Animal();
        Thread.sleep(1000);

        log("LOG",String.format("%s age in seconds: %d", testAnimal.getName(), testAnimal.getAgeInSeconds()));

        Animal.printAnimalLedger();

        fileOut.setPrintToOutput();

    }
}
