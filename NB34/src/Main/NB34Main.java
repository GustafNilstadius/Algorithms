package Main;

import Cars.Car;
import Cars.CompareCar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hipernx on 2015-02-18.
 */
public class NB34Main {


    public static void main(String[] args) {

        try {
            BufferedReader in = new BufferedReader(new FileReader("cars.txt"));
            int rows = Integer.parseInt(in.readLine());
            Car[] cars = new Car[rows];
            for (int i = 0; i < rows; i++) {
                cars[i] = new Car(in.readLine());
            }
            in.close();
            System.out.println(Arrays.toString(cars));
            Arrays.sort(cars);
            System.out.println(Arrays.toString(cars));
            BufferedWriter out = new BufferedWriter(new FileWriter("cars_sorted_Name.txt"));
            out.append("" + rows + "\n");
            for (int i = 0; i < cars.length; i++) {
                out.append(cars[i].toString() + "\n");
            }
            out.flush();
            out.close();


            //CompareCar[] compCars = (Comparable) cars;
            Comparator<Car> comp = new CompareCar();
            Arrays.sort(cars, comp);
            System.out.println(Arrays.toString(cars));
            BufferedWriter out2 = new BufferedWriter(new FileWriter("cars_sorted_Age.txt"));
            out2.append("" + rows + "\n");
            for (int i = 0; i < cars.length; i++) {
                out2.append(cars[i].toString() + "\n");
            }
            out2.flush();
            out2.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
