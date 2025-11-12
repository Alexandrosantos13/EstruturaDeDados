import java.time.LocalDateTime;

import br.edu.ifba.vdc.bsi.linkeddequedao.dao.repository.LinkedDEQue;

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
        DEQueable <Car> tempdeque = new LinkedDEQue<>();
        Car result = null;
        while (!cars.isEmpty()){
            tempdeque.enqueue(cars.dequeue());
            if (tempdeque.rear().getLicensePlate().equalsIgnoreCase(plateLicense)){
                result = tempdeque.rear();
            }
        }
        while (!tempdeque.isEmpty()){
            cars.enqueue(tempdeque.dequeue());
        }
        return result;
    }

    @Override
    public Car[] getAllCars() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void updateCar(Car newCar) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car deleteCar(String plateLicense) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByModel(String model) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByColor(String color) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
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