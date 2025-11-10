import java.time.LocalDateTime;
public class CarDAOLinkedStack implements CarDAO {

    private Stackable<Car> StackCars = new LinkedStack<>(20);

    /*Métodos auxiliares */
    private Car [] stackToArray(Stackable<Car> Stack){
            Car [] resultArray = new Car [countelements(Stack)];
            int index = 0;
            while (!Stack.isEmpty()){
                resultArray [index]=Stack.pop();
                index++;
            }
            return resultArray;
    }

    private int countelements (Stackable <Car> Stack){
       int result = 0;
       Stackable <Car> Auxlist = new LinkedStack<>();
        while (!Stack.isEmpty()){
            Auxlist.push(Stack.pop());
            result++;
        }
        while (!Auxlist.isEmpty()){
            Stack.push(Auxlist.pop());
        }
        return result;
    }


    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        StackCars.push(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        Stackable<Car> TempStackCars = new LinkedStack<>(20);
        Car resultcar = null;
        while (!StackCars.isEmpty()){
            Car car = StackCars.pop();
            TempStackCars.push(car);

            if (car.getLicensePlate()!=null&&car.getLicensePlate().equalsIgnoreCase(plateLicense)){
                resultcar=car;
                break;
            }
        }
        while (!TempStackCars.isEmpty()){
            StackCars.push(TempStackCars.pop());
        }
        return resultcar;
    }

    @Override
    public Car[] getAllCars() {
        return stackToArray(StackCars);
    }

    @Override
    public void updateCar(Car newCar) {
        Stackable<Car> TempStackCars = new LinkedStack<>(20);
        while (!StackCars.isEmpty()){
            Car car = StackCars.pop();
            TempStackCars.push(car);
            if (car.getLicensePlate().equals(newCar.getLicensePlate())){
                TempStackCars.pop();
                TempStackCars.push(newCar);
                break;
            }
        }
        while (!TempStackCars.isEmpty()){
            StackCars.push(TempStackCars.pop());
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        Stackable <Car> resultStack = new LinkedStack<>();
        Car result = null;
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            if (temp.getLicensePlate().equalsIgnoreCase(plateLicense)){
                result = temp;
            }else{
                resultStack.push(temp);
            }
        }
         while (!resultStack.isEmpty()){
                StackCars.push(resultStack.pop());
            }
            return result;
    }


    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        Stackable <Car> resultStack = new LinkedStack<>();
        Car result = null;
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            if (temp.getLicensePlate().equalsIgnoreCase(licensePlate)){
                result = temp;
                resultStack.push(temp);
            }else{
                resultStack.push(temp);
            }
        }
         while (!resultStack.isEmpty()){
                StackCars.push(resultStack.pop());
            }
            return result;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        Stackable <Car> TempStack = new LinkedStack<>();
        Stackable <Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            if (temp.getMark().equalsIgnoreCase(mark)){
                resultStack.push(temp);
                TempStack.push(temp);
            }else{
                TempStack.push(temp);
            }
        }
        Car[] newlistCars = new Car[countelements(resultStack)];
         while (!TempStack.isEmpty()){
                StackCars.push(TempStack.pop());
            }
        while (!resultStack.isEmpty()){
                newlistCars[index]=resultStack.pop();
                index++;
            }
            return newlistCars;
    }
    

    @Override
    public Car[] getCarsByModel(String model) {
        Stackable <Car> TempStack = new LinkedStack<>();
        Stackable <Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            if (temp.getModel().equalsIgnoreCase(model)){
                resultStack.push(temp);
                TempStack.push(temp);
            }else{
                TempStack.push(temp);
            }
        }
         while (!TempStack.isEmpty()){
                StackCars.push(TempStack.pop());
            }
        Car[] newlistCars = new Car[countelements(resultStack)];
        while (!resultStack.isEmpty()){
                newlistCars[index]=resultStack.pop();
                index++;
            }
            return newlistCars;
    }

    @Override
    public Car[] getCarsByColor(String color) {
        Stackable <Car> TempStack = new LinkedStack<>();
        Stackable <Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            if (temp.getColor().equalsIgnoreCase(color)){
                resultStack.push(temp);
                TempStack.push(temp);
            }else{
                TempStack.push(temp);
            }
        }
         while (!TempStack.isEmpty()){
                StackCars.push(TempStack.pop());
            }
        Car[] newlistCars = new Car[countelements(resultStack)];
        while (!resultStack.isEmpty()){
                newlistCars[index]=resultStack.pop();
                index++;
            }
            return newlistCars;
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        Stackable <Car> TempStack = new LinkedStack<>();
        Stackable <Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            if (temp.getOwnerName().equalsIgnoreCase(owner)){
                resultStack.push(temp);
                TempStack.push(temp);
            }else{
                TempStack.push(temp);
            }
        }
         while (!TempStack.isEmpty()){
                StackCars.push(TempStack.pop());
            }
        Car[] newlistCars = new Car[countelements(resultStack)];
        while (!resultStack.isEmpty()){
                newlistCars[index]=resultStack.pop();
                index++;
            }
            return newlistCars;
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        Stackable <Car> TempStack = new LinkedStack<>();
        Stackable <Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            if (!temp.getArrived().isAfter(finalMoment)&&temp.getArrived().isBefore(initialMoment)){
                resultStack.push(temp);
                TempStack.push(temp);
            }else{
                TempStack.push(temp);
            }
        }
         while (!TempStack.isEmpty()){
                StackCars.push(TempStack.pop());
            }
        Car[] newlistCars = new Car[countelements(resultStack)];
        while (!resultStack.isEmpty()){
                newlistCars[index]=resultStack.pop();
                index++;
            }
            return newlistCars;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        Car result = null;
        Stackable <Car> tempStack = new LinkedStack<>();
        while (!StackCars.isEmpty()){
            Car temp = StackCars.pop();
            tempStack.push(temp);
            if (result ==null && temp.getArrived()!=null){
                result=temp;
            }
            else if (result != null && temp.getArrived() != null && temp.getArrived().isAfter(result.getArrived())){
                result=temp;
            }
        }
        while (!tempStack.isEmpty()){
            StackCars.push(tempStack.pop());
        }
        return result;
    }

    @Override
    public Car getCarByOldestArrival() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getTotalCars() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularMark() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularModel() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularColor() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void clearAllCars() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getAvailableSpaces() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingEmpty() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getMaxCapacity() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getOccupancyRate() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingFull() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void removeCarsByOwner(String owner) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getAverageArrivalTime() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }
}