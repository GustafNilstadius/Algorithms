package Cars;

/**
 * Created by hipernx on 2015-02-18.
 */
public class Car implements Comparable<Car> {
    private String make;
    private int modelYear;
    private int km;

    public Car(String make, int year, int km){
        this.make = make;
        this.modelYear = year;
        this.km = km;
    }

    public Car(String carString){
        this.make = carString.substring(0, carString.indexOf(" "));
        this.modelYear = Integer.parseInt(carString.substring(carString.indexOf(" ")+1, carString.lastIndexOf(" ")));
        this.km = Integer.parseInt(carString.substring(carString.lastIndexOf(" ")+1));
    }

    public String getMake(){
        return make;
    }

    public int getModelYear(){
        return modelYear;
    }

    @Override
    public String toString() {
        return make + " " + modelYear + " " + km ;
    }

    @Override
    public int compareTo(Car car) {
        return make.compareTo(car.getMake());
    }
}
