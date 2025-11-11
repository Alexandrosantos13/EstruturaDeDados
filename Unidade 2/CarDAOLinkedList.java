
import java.nio.channels.IllegalSelectorException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
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

    public Car[] listToArray(Listable<Car> lista) {
        return lista.selectAll();
    }
}