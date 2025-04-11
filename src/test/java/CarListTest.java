import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    private CarList carlist;

    @BeforeEach
    void setUp() {
        carlist = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carlist.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carlist.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(carlist.removeAt(5));
        assertEquals(99, carlist.size());
    }

    @Test
    public void whenElementRemoveThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carlist.add(car);
        assertEquals(101, carlist.size());
        assertTrue(carlist.remove(car));
        assertEquals(100, carlist.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(carlist.remove(car));
        assertEquals(100, carlist.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carlist.clear();
        assertEquals(0, carlist.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrowException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carlist.get(100);
        });
    }

    @Test
    public  void methodGetReturnedRightValue() {
        Car car = carlist.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle(){
        Car car = new Car("BMW", 1);
        carlist.add(car, 50);
        assertEquals(car.getBrand(), carlist.get(50).getBrand());

    }

    @Test
    public void insertIntoFirstPosition(){
        Car car = new Car("BMW", 1);
        carlist.add(car, 0);
        assertEquals(car.getBrand(), carlist.get(0).getBrand());

    }

    @Test
    public void insertIntoLastPosition(){
        Car car = new Car("BMW", 1);
        carlist.add(car, 100);
        assertEquals(car.getBrand(), carlist.get(100).getBrand());

    }

}