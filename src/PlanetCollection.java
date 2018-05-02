import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class PlanetCollection implements Comparator<PlanetCollection>{
    public HashMap<Integer, Planet> hashMap = new HashMap<>();
    private Gson gson = new Gson();

    public void doItCommand(String command){
        if(command.trim().startsWith("remove_all ")){
            String stringJSON = command.trim().substring("remove_all".length(), command.trim().length()).trim();
            this.removeAll(stringJSON);
        }else if(command.trim().startsWith("remove_lower ")){
            String key = command.trim().substring("remove_lower".length(), command.trim().length()).trim();
            this.removeLower(key);
        }else if(command.trim().startsWith("remove_greater ")) {
            String JSON = command.trim().substring("remove_greater".length(), command.trim().length()).trim();
            this.removeGreater(JSON);
        }else if(command.trim().startsWith("add_if_max ")) {
            String JSON = command.trim().substring("add_if_max".length(), command.trim().length()).trim();
            this.addIfMax(JSON);
        }else System.out.println("Команда не найдена");
    }

    private void removeAll(String JSON){
        try {
            Planet element = gson.fromJson(JSON, Planet.class);
            int count = 0;
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry<Integer, Planet> pair = (HashMap.Entry<Integer, Planet>) it.next();
                Planet planet = pair.getValue();

                System.out.println(gson.toJson(planet, Planet.class));

                if (planet.equals(element)) {
                    it.remove();
                    count++;
                }
            }
            System.out.println("Удалилось: " + count + " элементов");
        }catch (JsonSyntaxException e){
            System.out.println("Неправильный формат объекта JSON");
        }
    }


    private void removeLower(String key){
        try {
            key = (key.trim().substring(1, key.length() - 1)).trim();

            Integer keyInteger = Integer.parseInt(key);

            int count = 0;
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry<Integer, Planet> pair = (HashMap.Entry<Integer, Planet>) it.next();
                Integer parKey = pair.getKey();

                if (keyInteger.intValue() > parKey.intValue()) {
                    it.remove();
                    count++;
                }
            }
            System.out.println("Удалилось: " + count + " элементов");
        }catch (NumberFormatException e){
            System.out.println("Неправильно задан ключ");
        }
    }


    private void removeGreater(String JSON){
        try {
            Planet element = gson.fromJson(JSON, Planet.class);
            int count = 0;
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry<Integer, Planet> pair = (HashMap.Entry<Integer, Planet>) it.next();
                Planet planet = pair.getValue();

                if (planet.Density > element.Density) {
                    it.remove();
                    count++;
                }
            }
            System.out.println("Удалилось: " + count + " элементов");
        }catch (JsonSyntaxException e){
            System.out.println("Неправильный формат объекта JSON");
        }
    }


    private void addIfMax(String JSON){
        try {
            Planet element = gson.fromJson(JSON, Planet.class);
            int count = 0;
            Iterator it = hashMap.entrySet().iterator();
            double max = 0;
            while (it.hasNext()) {
                HashMap.Entry<Integer, Planet> pair = (HashMap.Entry<Integer, Planet>) it.next();
                Planet planet = pair.getValue();

                if (planet.Density > max) {
                    max = planet.Density;
                }
            }
            if (element.Density > max) {
                hashMap.put(9000, element);
                count++;
            }
            System.out.println("Добавился: " + count + " элемент");
        }catch (JsonSyntaxException e){
            System.out.println("Неправильный формат объекта JSON");
        }
    }


    @Override
    public int compare(PlanetCollection o1, PlanetCollection o2) {
        return 0;
    }
}





