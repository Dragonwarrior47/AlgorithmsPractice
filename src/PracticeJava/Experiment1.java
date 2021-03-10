package PracticeJava;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class Experiment1 {
        public static void main(String args[])
        {
            HiveStorageFormat hv = HiveStorageFormat.ORC;
            System.out.println(hv.getSerDe());
        }
}

enum HiveStorageFormat
{
    ORC( "kanhaiya.serder",
            "hive",
            "presto",
            "estimatedWriteSystemMemoryUsage");

    private final String serde;
    private final String inputFormat;
    private final String outputFormat;
    private final String estimatedWriterSystemMemoryUsage;

    HiveStorageFormat(String serde, String inputFormat, String outputFormat, String estimatedWriterSystemMemoryUsage)
    {
        this.serde = serde;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.estimatedWriterSystemMemoryUsage =  estimatedWriterSystemMemoryUsage;
    }

    public String getSerDe()
    {
        return serde;
    }

    public String getInputFormat()
    {
        return inputFormat;
    }

    public String getOutputFormat()
    {
        return outputFormat;
    }

    public String getEstimatedWriterSystemMemoryUsage()
    {
        return estimatedWriterSystemMemoryUsage;
    }


}