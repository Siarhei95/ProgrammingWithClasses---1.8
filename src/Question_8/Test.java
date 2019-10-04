//Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод  toString(). Создать второй класс, агрегирующий массив типа  Customer, с подходящими конструкторами
//и методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, ном ер банковского счета.
//Найти и вывести:
//a) список покупателей в алфавитном порядке;
//b) список покупателей, у которых номер кредитной карточки находится в заданном интервале

package Question_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Shop market = new Shop("Market");
        market.addCustomerToShopList(new Customer("Пупкин", "Петр", "Иосифович", "Беларусь", 11_22_33_44, 12345));
        market.addCustomerToShopList(new Customer("Шац", "Василий", "Клеопатрович", "Египет", 22_33_44_55, 23456));
        market.addCustomerToShopList(new Customer("Пакрышкин", "Николай", "Федукович", "Непал", 33_44_55_66, 34567));
        market.addCustomerToShopList(new Customer("Непоседа", "Валерий", "Викторович", "Украина", 44_55_66_77, 45678));
        market.addCustomerToShopList(new Customer("Нурмагамедов", "Хабиб", "Абдулманапович", "Россия", 55_66_77_88, 56789));
        market.addCustomerToShopList(new Customer("Неглупая", "Ольга", "Алексеевна", "Россия", 66_77_88_99, 67890));
        market.addCustomerToShopList(new Customer("Ортоникидзе", "Люся", "Кирилловна", "Грузия", 77_88_99_00, 78901));
        market.addCustomerToShopList(new Customer("Победа", "Виктория", "Алексеевна", "Россия", 88_99_00_11, 89012));


        System.out.println("\nSort surname: ");                        //отсортируем по фамилиям
        List<Customer> listSortByName = market.getListByName();
        for (Customer c : listSortByName) {
            System.out.println(c);
        }

        System.out.println("\nSort surname: ");                       ////отсортируем по именам
        List<Customer> listSortByName2 = market.getListByName2();
        for (Customer c : listSortByName2) {
            System.out.println(c);
        }

        System.out.println("\nPrint customers by diapazon credit card:");
        List<Customer> listSortByDiapazonCreditCard = market.getListByDiapasonCreaditCard(22_33_44_55, 66_77_88_99);
        for (Customer c : listSortByDiapazonCreditCard) {
            System.out.println(c);
        }

    }
}

class Shop {
    private String shopName;
    private ArrayList<Customer> customersList = new ArrayList<>();

    Shop(String shopName) {
        this.shopName = shopName;
    }

    void addCustomerToShopList(Customer customer) {
        customersList.add(customer);
    }

    List<Customer> getListByName() {                        //разбирал сортировку коллекций через примеры в интернете!!!
        List<Customer> list = new ArrayList<>(customersList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getSurname().compareToIgnoreCase(o2.getSurname());
            }
        });
        return list;
    }

    List<Customer> getListByName2() {
        List<Customer> list = new ArrayList<>(customersList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return list;
    }

    List<Customer> getListByDiapasonCreaditCard(int diapazonStart, int diapazonEnd) {
        List<Customer> list = new ArrayList<>();
        for (Customer c : customersList) {
            if (c.getCreditCardId() >= diapazonStart && c.getCreditCardId() <=diapazonEnd) {
                list.add(c);
            }
        }

        return list;
    }
}

class Customer {
    {
        idGenerator++;
    }

    private static int idGenerator = 0;
    private int id = idGenerator;
    private String surname;
    private String name;
    private String name3;
    private String address;
    private int creditCardId;
    private int bankNumberCard;

    Customer(String surname, String name, String name3, String address, int creditCardId, int bankNumberCard) {
        this.surname = surname;
        this.name = name;
        this.name3 = name3;
        this.address = address;
        this.creditCardId = creditCardId;
        this.bankNumberCard = bankNumberCard;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getName3() {
        return name3;
    }

    public String getAddress() {
        return address;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public int getBankNumberCard() {
        return bankNumberCard;
    }

    public String toString() {
        return String.format("ID: %d\t name: %s\t name2: %s\t name3 %s \t from: %s\t credit card %d\t bank number %d",
                id, surname, name, name3, address, creditCardId, bankNumberCard);
    }
}
