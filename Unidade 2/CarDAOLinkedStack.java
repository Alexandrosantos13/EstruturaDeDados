import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CarDAOLinkedStack implements CarDAO {

    private Stackable<Car> StackCars = new LinkedStack<>(20);

    /* Métodos auxiliares */
    private Car[] stackToArray(Stackable<Car> Stack) {
        Stackable<Car> tempStack = new LinkedStack<>();
        Car[] resultArray = new Car[Stack.getSize()];
        int index = 0;
        while (!Stack.isEmpty()) {
            Car temp = Stack.pop();
            resultArray[index] = temp;
            index++;
            tempStack.push(temp);
        }
        while (!tempStack.isEmpty()) {
            Stack.push(tempStack.pop());
        }
        return resultArray;
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
        while (!StackCars.isEmpty()) {
            Car car = StackCars.pop();
            TempStackCars.push(car);

            if (car.getLicensePlate() != null && car.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                resultcar = car;
                break;
            }
        }
        while (!TempStackCars.isEmpty()) {
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
        while (!StackCars.isEmpty()) {
            Car car = StackCars.pop();
            TempStackCars.push(car);
            if (car.getLicensePlate().equals(newCar.getLicensePlate())) {
                TempStackCars.pop();
                TempStackCars.push(newCar);
                break;
            }
        }
        while (!TempStackCars.isEmpty()) {
            StackCars.push(TempStackCars.pop());
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        Stackable<Car> resultStack = new LinkedStack<>();
        Car result = null;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                result = temp;
            } else {
                resultStack.push(temp);
            }
        }
        while (!resultStack.isEmpty()) {
            StackCars.push(resultStack.pop());
        }
        return result;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        Stackable<Car> resultStack = new LinkedStack<>();
        Car result = null;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                result = temp;
                resultStack.push(temp);
            } else {
                resultStack.push(temp);
            }
        }
        while (!resultStack.isEmpty()) {
            StackCars.push(resultStack.pop());
        }
        return result;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        Stackable<Car> TempStack = new LinkedStack<>();
        Stackable<Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getMark().equalsIgnoreCase(mark)) {
                resultStack.push(temp);
                TempStack.push(temp);
            } else {
                TempStack.push(temp);
            }
        }
        Car[] newlistCars = new Car[resultStack.getSize()];
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        while (!resultStack.isEmpty()) {
            newlistCars[index] = resultStack.pop();
            index++;
        }
        return newlistCars;
    }

    @Override
    public Car[] getCarsByModel(String model) {
        Stackable<Car> TempStack = new LinkedStack<>();
        Stackable<Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getModel().equalsIgnoreCase(model)) {
                resultStack.push(temp);
                TempStack.push(temp);
            } else {
                TempStack.push(temp);
            }
        }
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        Car[] newlistCars = new Car[resultStack.getSize()];
        while (!resultStack.isEmpty()) {
            newlistCars[index] = resultStack.pop();
            index++;
        }
        return newlistCars;
    }

    @Override
    public Car[] getCarsByColor(String color) {
        Stackable<Car> TempStack = new LinkedStack<>();
        Stackable<Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getColor().equalsIgnoreCase(color)) {
                resultStack.push(temp);
                TempStack.push(temp);
            } else {
                TempStack.push(temp);
            }
        }
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        Car[] newlistCars = new Car[resultStack.getSize()];
        while (!resultStack.isEmpty()) {
            newlistCars[index] = resultStack.pop();
            index++;
        }
        return newlistCars;
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        Stackable<Car> TempStack = new LinkedStack<>();
        Stackable<Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getOwnerName().equalsIgnoreCase(owner)) {
                resultStack.push(temp);
                TempStack.push(temp);
            } else {
                TempStack.push(temp);
            }
        }
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        Car[] newlistCars = new Car[resultStack.getSize()];
        while (!resultStack.isEmpty()) {
            newlistCars[index] = resultStack.pop();
            index++;
        }
        return newlistCars;
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        Stackable<Car> TempStack = new LinkedStack<>();
        Stackable<Car> resultStack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (!temp.getArrived().isAfter(finalMoment) && temp.getArrived().isBefore(initialMoment)) {
                resultStack.push(temp);
                TempStack.push(temp);
            } else {
                TempStack.push(temp);
            }
        }
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        Car[] newlistCars = new Car[resultStack.getSize()];
        while (!resultStack.isEmpty()) {
            newlistCars[index] = resultStack.pop();
            index++;
        }
        return newlistCars;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        Car result = null;
        Stackable<Car> tempStack = new LinkedStack<>();
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            tempStack.push(temp);
            if (result == null && temp.getArrived() != null) {
                result = temp;
            } else if (result != null && temp.getArrived() != null && temp.getArrived().isAfter(result.getArrived())) {
                result = temp;
            }
        }
        while (!tempStack.isEmpty()) {
            StackCars.push(tempStack.pop());
        }
        return result;
    }

    @Override
    public Car getCarByOldestArrival() {
        Car result = null;
        Stackable<Car> tempStack = new LinkedStack<>();
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            tempStack.push(temp);
            if (result == null && temp.getArrived() != null) {
                result = temp;
            } else if (result != null && temp.getArrived() != null && temp.getArrived().isBefore(result.getArrived())) {
                result = temp;
            }
        }
        while (!tempStack.isEmpty()) {
            StackCars.push(tempStack.pop());
        }
        return result;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        return StackCars.toString();
    }

    @Override
    public int getTotalCars() {
        return StackCars.getSize();
    }

    @Override
    public String getMostPopularMark() {
        HashMap<String, Integer> marcas = new HashMap<>();
        Stackable<Car> TempStack = new LinkedStack<>();
        int marcapopular = 0;
        String marcapopstring = null;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            TempStack.push(temp);
            if (!marcas.containsKey(temp.getMark().toUpperCase())) {
                marcas.put(temp.getMark().toUpperCase(), 1);
                if (marcas.get(temp.getMark().toUpperCase()) > marcapopular) {
                    marcapopular = marcas.get(temp.getMark().toUpperCase());
                    marcapopstring = temp.getMark();
                }
            } else {
                marcas.put(temp.getMark().toUpperCase(), marcas.get(temp.getMark().toUpperCase()) + 1);
                if (marcas.get(temp.getMark().toUpperCase()) > marcapopular) {
                    marcapopular = marcas.get(temp.getMark().toUpperCase());
                    marcapopstring = temp.getMark();
                }
            }
        }
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        return marcapopstring;
    }

    @Override
    public String getMostPopularModel() {
        HashMap<String, Integer> modelos = new HashMap<>();
        Stackable<Car> TempStack = new LinkedStack<>();
        int modelopopular = 0;
        String modelopopstring = null;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            TempStack.push(temp);
            if (!modelos.containsKey(temp.getMark().toUpperCase())) {
                modelos.put(temp.getMark().toUpperCase(), 1);
                if (modelos.get(temp.getMark().toUpperCase()) > modelopopular) {
                    modelopopular = modelos.get(temp.getMark().toUpperCase());
                    modelopopstring = temp.getMark();
                }
            } else {
                modelos.put(temp.getMark().toUpperCase(), modelos.get(temp.getMark().toUpperCase()) + 1);
                if (modelos.get(temp.getMark().toUpperCase()) > modelopopular) {
                    modelopopular = modelos.get(temp.getMark().toUpperCase());
                    modelopopstring = temp.getMark();
                }
            }
        }
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        return modelopopstring;
    }

    @Override
    public String getMostPopularColor() {
        HashMap<String, Integer> cores = new HashMap<>();
        Stackable<Car> TempStack = new LinkedStack<>();
        int corpopular = 0;
        String corpopstring = null;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            TempStack.push(temp);
            if (!cores.containsKey(temp.getMark().toUpperCase())) {
                cores.put(temp.getMark().toUpperCase(), 1);
                if (cores.get(temp.getMark().toUpperCase()) > corpopular) {
                    corpopular = cores.get(temp.getMark().toUpperCase());
                    corpopstring = temp.getMark();
                }
            } else {
                cores.put(temp.getMark().toUpperCase(), cores.get(temp.getMark().toUpperCase()) + 1);
                if (cores.get(temp.getMark().toUpperCase()) > corpopular) {
                    corpopular = cores.get(temp.getMark().toUpperCase());
                    corpopstring = temp.getMark();
                }
            }
        }
        while (!TempStack.isEmpty()) {
            StackCars.push(TempStack.pop());
        }
        return corpopstring;
    }

    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        Stackable<Car> tempStack = new LinkedStack<>();
        boolean Switch = false;
        while (!StackCars.isEmpty() && Switch == false) {
            Car temp = StackCars.pop();
            tempStack.push(temp);
            if (temp.getLicensePlate() != null && temp.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                Switch = true;
            }
        }
        while (!tempStack.isEmpty()) {
            StackCars.push(tempStack.pop());
        }
        return Switch;
    }

    @Override
    public void clearAllCars() {
        while (!StackCars.isEmpty()) {
            StackCars.pop();
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        Stackable<Car> tempStack = new LinkedStack<>();
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getArrived() != null && !temp.getArrived().isBefore(date)) {
                tempStack.push(temp);
            }
        }
        while (!tempStack.isEmpty()) {
            StackCars.push(tempStack.pop());
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        LocalDateTime horalocal = LocalDateTime.now();
        Stackable<Car> tempStack = new LinkedStack<>();
        Stackable<Car> resultstack = new LinkedStack<>();
        int index = 0;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            tempStack.push(temp);
            if (temp.getArrived() != null) {
                long comparacao = Duration.between(temp.getArrived(), horalocal).toHours();
                if (comparacao >= minHours && comparacao <= maxHours) {
                    resultstack.push(temp);
                }
            }
        }
        while (!tempStack.isEmpty()) {
            StackCars.push(tempStack.pop());
        }

        Car[] resultlist = new Car[resultstack.getSize()];
        while (!resultstack.isEmpty()) {
            resultlist[index] = resultstack.pop();
            index++;
        }
        return resultlist;
    }

    @Override
    public int getAvailableSpaces() {
        int availableSpaces = StackCars.getMaxCapacity() - StackCars.getSize();
        return availableSpaces;
    }

    @Override
    public boolean isParkingEmpty() {
        boolean result = true;
        if (StackCars.getSize() > 0) {
            result = false;
        }
        return result;
    }

    @Override
    public int getMaxCapacity() {
        return StackCars.getMaxCapacity();
    }

    @Override
    public int getOccupancyRate() {
        int result = ((StackCars.getSize() / StackCars.getSize()) / 100);
        return result;
    }

    @Override
    public boolean isParkingFull() {
        boolean result = false;
        if (StackCars.getSize() == StackCars.getMaxCapacity()) {
            result = true;
        }
        return result;
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        LocalDateTime horalocal = LocalDateTime.now();
        Stackable<Car> tempStack = new LinkedStack<>();
        Long duracao = 0L;
        while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            tempStack.push(temp);
            if (temp.getLicensePlate() !=null && temp.getArrived() !=null && temp.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                duracao = Duration.between(temp.getArrived(), horalocal).toHours();
                break;
            }
        }

        while (!tempStack.isEmpty()) {
            StackCars.push(tempStack.pop());
        }
        return duracao;
    }

    @Override
    public void removeCarsByOwner(String owner) {
        Stackable<Car> tempStack = new LinkedStack<>();
         while (!StackCars.isEmpty()) {
            Car temp = StackCars.pop();
            if (temp.getOwnerName()!=null && !temp.getOwnerName().equalsIgnoreCase(owner)){
                tempStack.push(temp);
            }else if (temp.getOwnerName()==null){
                tempStack.push(temp);
            }
         }
          while (!tempStack.isEmpty()) {
            StackCars.push(tempStack.pop());
        }
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