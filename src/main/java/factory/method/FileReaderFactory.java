package factory.method;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import classwork.util.json.JsonFileReader;
import classwork.util.xml.XmlFileReader;
import classwork.util.xml.XmlFileWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;

public class FileReaderFactory {

        protected String fileName;
        protected Class<Fallback> fallbackClass;

    private FileReaderFactory(String fileName, Class<Fallback> fallbackClass) {
        this.fileName = fileName;
        this.fallbackClass = fallbackClass;
    }

    public AbstractFileReader fileReader(String typeFile){
        switch (typeFile){
            case "json":
                return new JsonFileReader(new ObjectMapper(), fileName, fallbackClass);
            default:
                return new XmlFileReader(new XmlMapper(), fileName, fallbackClass);
        }
    }

    public static final FileReaderFactory newFileReaderFactory(String fileName, Class<Fallback> fallbackClass){
        return new FileReaderFactory(fileName, fallbackClass);
    }
}
