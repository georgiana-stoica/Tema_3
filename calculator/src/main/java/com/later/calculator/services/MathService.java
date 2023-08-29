package com.later.calculator.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.later.calculator.Math;

@Service
public class MathService {

    public void performMathOperations(List<Math> operations, String fileName) {

        try{
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for( Math op : operations ){
                double result = 0;
                switch (op.getOperators() ){
                    case "add":
                        result = op.getOperands().get(0) + op.getOperands().get(1);
                        break;
                    case "sub":
                        result = op.getOperands().get(0) - op.getOperands().get(1);
                        break;
                    case "div":
                        result = op.getOperands().get(0) / op.getOperands().get(1);
                        break;
                    case "mult":
                        result = op.getOperands().get(0) * op.getOperands().get(1);
                        break;
                }
                pw.write(result + "\n");
            }
            pw.close();

        } catch ( IOException e ){
            e.printStackTrace();
        }
    }

    public boolean isFinished(String fileName) {

        List<Double> results = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while( scanner.hasNextDouble() ){
               results.add(scanner.nextDouble());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        if(results != null && results.size() == 4 )
            return true;
        else
            return false;
    }


    public List<Double> showResults(String fileName) {
        List<Double> results = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while( scanner.hasNextDouble() ){
                results.add(scanner.nextDouble());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return results;
    }
}
