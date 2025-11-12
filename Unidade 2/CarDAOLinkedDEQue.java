import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Implementação do DAO (Data Access Object) para gerenciamento de carros
 * utilizando uma estrutura de dados do tipo fila com dupla terminação (DEQue).
 * 
 * Esta classe implementa todas as operações CRUD (Create, Read, Update, Delete)
 * e operações de consulta específicas para carros, mantendo os dados em uma
 * estrutura de fila que preserva a ordem FIFO (First In, First Out).
 * 
 * @author Cláudio Rodolfo Sousa de Oliveira
 * @version 1.0
 * @since 2025-10-20
 * @see CarDAO
 * @see Car
 * @see DEQueable
 * @see LinkedDEQue
 */
public class CarDAOLinkedDEQue implements CarDAO {

    private DEQueable<Car> cars = new LinkedDEQue<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.enqueue(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        Car result = null;
        while (!cars.isEmpty()) {
            tempdeque.enqueue(cars.dequeue());
            if (tempdeque.rear().getLicensePlate().equalsIgnoreCase(plateLicense)) {
                result = tempdeque.rear();
            }
        }
        while (!tempdeque.isEmpty()) {
            cars.enqueue(tempdeque.dequeue());
        }
        return result;
    }

    @Override
    public Car[] getAllCars() {
        return cars.selectAll();
    }

    @Override
    public void updateCar(Car newCar) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car tempcar = cars.dequeue();
            if (tempcar.getLicensePlate().equalsIgnoreCase(newCar.getLicensePlate())) {
                tempdeque.enqueue(newCar);
            } else {
                tempdeque.enqueue(tempcar);
            }
        }
        while (!tempdeque.isEmpty()) {
            cars.enqueue(tempdeque.dequeue());
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car tempcar = cars.dequeue();
            if (!tempcar.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                tempdeque.enqueue(tempcar);
            } else {
            }
        }
        while (!tempdeque.isEmpty()) {
            cars.enqueue(tempdeque.dequeue());
        }
        return null;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return getCar(licensePlate);
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        DEQueable<Car> result = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (temp != null && temp.getMark() != null && temp.getMark().equalsIgnoreCase(mark)) {
                result.enqueue(temp);
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return queueToArray(result);

    }

    @Override
    public Car[] getCarsByModel(String model) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        DEQueable<Car> result = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (temp != null && temp.getModel() != null && temp.getModel().equalsIgnoreCase(model)) {
                result.enqueue(temp);
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return queueToArray(result);
    }

    @Override
    public Car[] getCarsByColor(String color) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        DEQueable<Car> result = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (temp != null && temp.getColor() != null && temp.getColor().equalsIgnoreCase(color)) {
                result.enqueue(temp);
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return queueToArray(result);
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        DEQueable<Car> result = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (temp != null && temp.getOwnerName() != null && temp.getOwnerName().equalsIgnoreCase(owner)) {
                result.enqueue(temp);
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return queueToArray(result);
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        DEQueable<Car> result = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (temp != null && temp.getArrived() != null && !temp.getArrived().isBefore(initialMoment) && !temp.getArrived().isAfter(finalMoment)) {
                result.enqueue(temp);
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return queueToArray(result);
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        Car result = null;
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (result == null && temp != null && temp.getArrived() != null){
                result = temp;
            }
            if (temp != null && temp.getArrived() != null && temp.getArrived().isAfter(result.getArrived())){
                result = temp;
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return result;
    }

    @Override
    public Car getCarByOldestArrival() {
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        Car result = null;
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (result == null && temp != null && temp.getArrived() != null){
                result = temp;
            }
            if (temp != null && temp.getArrived() != null && temp.getArrived().isBefore(result.getArrived())){
                result = temp;
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return result;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        return cars.toString();
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
        DEQueable <Car> tempQueable = new LinkedDEQue<>();
            
        String marcapopular = null;
        int maxmarca = 0;
        while (!cars.isEmpty()) {
            Car tempCar = cars.dequeue();
            tempQueable.enqueue(tempCar);

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
        while (!tempQueable.isEmpty()){
            cars.enqueue(tempQueable.dequeue());
        }
        return marcapopular;
    }

    @Override
    public String getMostPopularModel() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        HashMap<String, Integer> models = new HashMap<>();
        DEQueable <Car> tempQueable = new LinkedDEQue<>();
            
        String modelopopular = null;
        int maxmodelo = 0;
        while (!cars.isEmpty()) {
            Car tempCar = cars.dequeue();
            tempQueable.enqueue(tempCar);

            if (tempCar.getModel() != null) {
                String modeloatual = tempCar.getModel().toUpperCase();
                int contador = models.getOrDefault(modeloatual, 0) + 1;
                models.put(modeloatual, contador);
                if (contador > maxmodelo) {
                    maxmodelo = contador;
                    modelopopular = modeloatual;
                }
            }
        } 
        while (!tempQueable.isEmpty()){
            cars.enqueue(tempQueable.dequeue());
        }
        return modelopopular;
    }

    @Override
    public String getMostPopularColor() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        HashMap<String, Integer> colors = new HashMap<>();
        DEQueable <Car> tempQueable = new LinkedDEQue<>();
            
        String corpopular = null;
        int maxcor = 0;
        while (!cars.isEmpty()) {
            Car tempCar = cars.dequeue();
            tempQueable.enqueue(tempCar);

            if (tempCar.getColor() != null) {
                String coratual = tempCar.getColor().toUpperCase();
                int contador = colors.getOrDefault(coratual, 0) + 1;
                colors.put(coratual, contador);
                if (contador > maxcor) {
                    maxcor = contador;
                    corpopular = coratual;
                }
            }
        } 
        while (!tempQueable.isEmpty()){
            cars.enqueue(tempQueable.dequeue());
        }
        return corpopular;
    }


    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        boolean result = false;
        DEQueable <Car> tempDeQueable = new LinkedDEQue<>();
        while (!cars.isEmpty()){
            Car temp = cars.dequeue();
            tempDeQueable.enqueue(temp);
            if (temp.getLicensePlate()!=null && temp.getLicensePlate().equalsIgnoreCase(plateLicense)){
                result=true;
            }

        }
        while (!tempDeQueable.isEmpty()){
            cars.enqueue(tempDeQueable.dequeue());
        }
        return result;
    }

    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()){
            cars.dequeue();
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            if (temp.getArrived() == null || !temp.getArrived().isBefore(date)){
                tempdeque.enqueue(temp);
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Erro: a lista está vazia");
        }
        LocalDateTime horalocal = LocalDateTime.now();
        DEQueable<Car> tempdeque = new LinkedDEQue<>();
        DEQueable<Car> resultdeque = new LinkedDEQue<>();
        while (!cars.isEmpty()) {
            Car temp = cars.dequeue();
            tempdeque.enqueue(temp);
            if (temp.getArrived()!=null){  
                long tempo = Duration.between(temp.getArrived(), horalocal).toHours();
                if (tempo>=minHours && tempo<=maxHours){
                    resultdeque.enqueue(temp);
                }
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return queueToArray(resultdeque);
    }



    @Override
    public int getAvailableSpaces() {
        return cars.maxCapacity() - cars.size();
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

    private Car[] queueToArray(DEQueable<Car> queue) {
        Car[] resultArrayCars = new Car[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            resultArrayCars[index] = queue.dequeue();
            index++;
        }
        return resultArrayCars;
    }
}