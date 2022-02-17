package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginValidData(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"lenastep@gmail.com","12345nnnN"});
        list.add(new Object[]{"lenastep@gmail.com","12345nnnN"});
        list.add(new Object[]{"lenastep@gmail.com","12345nnnN"});
//kogda vizivaem snova method on smeshaetsya i vozvrashaet sleduyshiy element
        return list.iterator(); //obhodit kollekciy i vozvrashaet 1 element
    }

    @DataProvider
    public Iterator<Object[]> CarValidData(){

        List<Object[]> list = new ArrayList<>();
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);
        list.add(new Object[]{"Tel Aviv, Israel", "BMW","M5","2020","2.5","Petrol","MT","AWD","5","4","C","6.5","103-45-"+index,"65","500","type of","Very good car"});
        list.add(new Object[]{"Tel Aviv, Israel", "BMW","M5","2020","2.5","Petrol","MT","AWD","5","4","C","6.5","102-46-"+index,"65","500","type of","Very good car"});
        list.add(new Object[]{"Tel Aviv, Israel", "BMW","M5","2020","2.5","Petrol","MT","AWD","5","4","C","6.5","101-47-"+index,"65","500","type of","Very good car"});

        return list.iterator(); //obhodit kollekciy i vozvrashaet 1 element
    }
    @DataProvider
    public Iterator<Object[]> loginValidDataModel(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("lenastep@gmail.com").withPassword("12345nnnN")});
        list.add(new Object[]{new User().withEmail("lenastep@gmail.com").withPassword("12345nnnN")});
        list.add(new Object[]{new User().withEmail("lenastep@gmail.com").withPassword("12345nnnN")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addCarValidDataModel(){//??????????????????//

        List<Object[]> list = new ArrayList<>();

        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);

        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel").make("BMW").model("M5").year("2020").engine("2.5").fuel("Petrol").gear("MT").wD("AWD").doors("5").seats("4").clasS("C").fuelConsumption("6.5").carRegNumber("105-41-"+index).price("65").distanceIncluded("500").features("type of").about("Very good car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel").make("BMW").model("M5").year("2020").engine("2.5").fuel("Petrol").gear("MT").wD("AWD").doors("5").seats("4").clasS("C").fuelConsumption("6.5").carRegNumber("104-55-"+index).price("65").distanceIncluded("500").features("type of").about("Very good car").build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addCarValidDataCSV() throws IOException {
//Fail s racshireniem CSV
        List<Object[]> list = new ArrayList<>();
//tyt yzhe sami kontroliryem index v faile
// na FileReader i readLine nyzhen Exception
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/cars.csv")));
        //reader.readLine(); trebyet peremennyu - String line
        String line = reader.readLine();

        while(line!=null){

           String[]split=line.split(",");
           list.add(new Object[]{Car.builder()
                   .address(split[0])
                   .make(split[1])
                   .model(split[2])
                   .year(split[3])
                   .engine(split[4])
                   .fuel(split[5])
                   .gear(split[6])
                   .wD(split[7])
                   .doors(split[8])
                   .seats(split[9])
                   .clasS(split[10])
                   .fuelConsumption(split[11])
                   .carRegNumber(split[12])
                   .price(split[13])
                   .distanceIncluded(split[14])
                   .features(split[15])
                   .about(split[16])
                   .build()});

           line=reader.readLine();
        }
        return list.iterator();
    }
}
