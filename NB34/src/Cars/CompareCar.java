package Cars;

import java.util.Comparator;

/**
 * Created by hipernx on 2015-02-18.
 */
public class CompareCar implements Comparator<Car>  {
    @Override
    public int compare(Car car, Car t1) {
        if (car.getModelYear() < t1.getModelYear()){
            return -1;
        } else if (car.getModelYear() > t1.getModelYear()){
            return 1;
        }
        return 0;
    }
}
