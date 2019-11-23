package classwork.util.json;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileReader extends AbstractFileReader {

    private Class<Fallback> fallbackClass;

    public JsonFileReader(ObjectMapper mapper, String fileName, Class<Fallback> fallbackClass) {
        super(mapper, fileName);
        this.fallbackClass = fallbackClass;
    }

    @Override
    public Object readFile() {
        ObjectMapper o = (ObjectMapper) mapper;
        Object result = null;
        System.out.println("Считываем данные из файла " + fileName);
        try {
            result = o.readValue(new File(fileName), fallbackClass);
            System.out.println("Данные считаны из файла " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
