package set_study;

import java.util.*;

/**
 * @author JeffCar
 * @date 12/4/2020 - 11:53 AM
 */
public class DAO <T>{
    private Map<String,T> map = new HashMap<>();


    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public DAO() {

    }

    public void save(String id, T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity){
        if (map.containsKey(id)){
            map.put(id,entity);
        }
    }

    public List<T> list(){
        List<T> list1 = new ArrayList<>();
        Collection collection = map.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            list1.add((T) iterator.next());
        }

        return list1;

    }

    public void delete(String id){
        map.remove(id);
    }
}
