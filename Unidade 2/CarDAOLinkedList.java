
import java.nio.channels.IllegalSelectorException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.time.Duration;
import java.util.HashMap;

public class CarDAOLinkedList implements CarDAO {

    private Listable<Car> cars = new LinkedList<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.append(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        Car car = getCarByLicensePlate(plateLicense);
        return car;
    }

    @Override
    public Car[] getAllCars() {
        return cars.selectAll();
    }

    @Override
    public void updateCar(Car newCar) {
        if (newCar == null || newCar.getLicensePlate() == null) {
            throw new NullPointerException("O carro está vazio");
        } else {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.select(i).getLicensePlate() != null
                        && cars.select(i).getLicensePlate().equalsIgnoreCase(newCar.getLicensePlate())) {
                    cars.update(i, newCar);
                    break;
                }
            }
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        if (plateLicense == null) {
            throw new IllegalArgumentException("Placa Inválida");
        } else {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.select(i).getLicensePlate() != null
                        && cars.select(i).getLicensePlate().equalsIgnoreCase(plateLicense)) {
                    return cars.delete(i);
                }
            }
        }
        return null;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return cars.select(i);
            }
        }
        return null;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        Listable<Car> resultList = new LinkedList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getMark().equalsIgnoreCase(mark)) {
                resultList.append(cars.select(i));
            }
        }
        return listToArray(resultList);
    }

    @Override
    public Car[] getCarsByModel(String model) {
        Listable<Car> resultList = new LinkedList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getModel().equalsIgnoreCase(model)) {
                resultList.append(cars.select(i));
            }
        }
        return listToArray(resultList);
    }

    @Override
    public Car[] getCarsByColor(String color) {
        Listable<Car> resultList = new LinkedList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getColor().equalsIgnoreCase(color)) {
                resultList.append(cars.select(i));
            }
        }
        return listToArray(resultList);
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        Listable<Car> resultList = new LinkedList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getOwnerName().equalsIgnoreCase(owner)) {
                resultList.append(cars.select(i));
            }
        }
        return listToArray(resultList);
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        Listable<Car> resultList = new LinkedList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (!cars.select(i).getArrived().isAfter(finalMoment)
                    && !cars.select(i).getArrived().isBefore(initialMoment)) {
                resultList.append(cars.select(i));
            }
        }
        return listToArray(resultList);
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        if (cars.size() == 0) {
            throw new NoSuchElementException("A lista esta vazia");
        }
        Car recentCar = null;
        for (int i = 0; i < cars.size(); i++) {
            Car tempCar = cars.select(i);
            if (tempCar.getArrived() != null) {
                if (recentCar == null) {
                    recentCar = tempCar;
                } else if (tempCar.getArrived().isAfter(recentCar.getArrived())) {
                    recentCar = tempCar;
                }
            }
        }
        return recentCar;
    }

    @Override
    public Car getCarByOldestArrival() {
        if (cars.size() == 0) {
            throw new NoSuchElementException("A lista esta vazia");
        }
        Car oldCar = null;
        for (int i = 0; i < cars.size(); i++) {
            Car tempCar = cars.select(i);
            if (tempCar.getArrived() != null) {
                if (oldCar == null) {
                    oldCar = tempCar;
                } else if (tempCar.getArrived().isBefore(oldCar.getArrived())) {
                    oldCar = tempCar;
                }
            }
        }
        return oldCar;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        return cars.print();
    }

    @Override
    public int getTotalCars() {
        return cars.size();
    }

    @Override
    public String getMostPopularMark() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        HashMap<String, Integer> marcas = new HashMap<>();
        String marcapopular = null;
        int maxmarca = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car tempCar = cars.select(i);
            if (tempCar.getMark() != null) {
                String marcaAtual = tempCar.getMark().toUpperCase();
                int contador = marcas.getOrDefault(marcaAtual, 0) + 1;
                marcas.put(marcaAtual, contador);
                if (contador > maxmarca) {
                    maxmarca = contador;
                    marcapopular = marcaAtual;
                }
            }
        } 

        return marcapopular;
    }

    @Override
    public String getMostPopularModel() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        HashMap<String, Integer> modelos = new HashMap<>();
        String modelopopular = null;
        int maxmodelo = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car tempCar = cars.select(i);
            if (tempCar.getModel() != null) {
                String modeloAtual = tempCar.getModel().toUpperCase();
                int contador = modelos.getOrDefault(modeloAtual, 0) + 1;
                modelos.put(modeloAtual, contador);
                if (contador > maxmodelo) {
                    maxmodelo = contador;
                    modelopopular = modeloAtual;
                }
            }
        }

        return modelopopular;
    }

    @Override
    public String getMostPopularColor() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        HashMap<String, Integer> cores = new HashMap<>();
        String cor = null;
        int maxcor = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car tempCar = cars.select(i);
            if (tempCar.getModel() != null) {
                String corAtual = tempCar.getModel().toUpperCase();
                int contador = cores.getOrDefault(corAtual, 0) + 1;
                cores.put(corAtual, contador);
                if (contador > maxcor) {
                    maxcor = contador;
                    cor = corAtual;
                }
            }
        }

        return cor;
    }

    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        if (plateLicense != null && getCar(plateLicense) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clearAllCars() {
        cars.clear();
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("Erro lista vazia");
        }
        for (int i = cars.size() - 1; i >= 0; i--) {
            if (cars.select(i).getArrived()!=null && cars.select(i).getArrived().isBefore(date)) {
                cars.delete(i);
            }
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
       LocalDateTime horalocal = LocalDateTime.now();
       Listable <Car> result = new LinkedList<>();  
       if (cars.isEmpty()){
            throw new NoSuchElementException("Erro lista vazia");
        }
        for (int i = 0; i < cars.size() ; i++) {
            if (cars.select(i).getArrived()!=null) {
                long comparacao = Duration.between(cars.select(i).getArrived(), horalocal).toHours();
                if (comparacao>=minHours && comparacao<=maxHours){
                    result.append(cars.select(i));
                }
            }
        }
        return listToArray(result);
    }   
    
    @Override
    public int getAvailableSpaces() {
        return cars.maxCapacity()-cars.size();
    }

    @Override
    public boolean isParkingEmpty() {
        if (cars.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public int getMaxCapacity() {
        return cars.maxCapacity();
    }

    @Override
    public int getOccupancyRate() {
        return (cars.maxCapacity()/cars.size())*100;
    }

    @Override
    public boolean isParkingFull() {
        if (cars.isFull()){
            return true;
        }
        return false;
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        LocalDateTime horalocal = LocalDateTime.now();
        return Duration.between(getCarByLicensePlate(plateLicense).getArrived(), horalocal).toHours();
    }

    @Override
    public void removeCarsByOwner(String owner) {
        for (int i = 0; i < cars.size(); i++) {
            Car tempCar = cars.select(i);
            if (tempCar!=null && tempCar.getOwnerName() != null && tempCar.getOwnerName().equalsIgnoreCase(owner)) {
                cars.delete(i);
                }
            }
    }

    @Override
    public long getAverageArrivalTime() {
        int totalcarros = cars.size();
        long totalhoras=0;
        for (int i = 0; i < cars.size(); i++) {
                totalhoras+=getParkingDuration(cars.select(i).getLicensePlate());
            }
        return totalhoras/totalcarros;
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        Listable <Car> result = new LinkedList<>();  
        for (int i = 0; i < cars.size(); i++) {
                if (getParkingDuration(cars.select(i).getLicensePlate())>thresholdHours){
                    result.append(cars.select(i));
                }
            }
            return listToArray(result);
    }

    public Car[] listToArray(Listable<Car> lista) {
        return lista.selectAll();
    }
}