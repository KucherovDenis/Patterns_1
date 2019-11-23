package builder.method;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import factory.method.FileReaderFactory;

public class FileReaderBuilder {
    protected String fileName;
    protected Class<Fallback> fallbackClass;
    protected String fileType;

    public FileReaderBuilder(String fileName, Class<Fallback> fallbackClass, String fileType) {
        this.fileName = fileName;
        this.fallbackClass = fallbackClass;
        this.fileType = fileType;
    }

    public FileReaderBuilder() {
    }

    public FileReaderBuilder feelFileName(String fileName){
        this.fileName = fileName;
        return this;
    }

    public FileReaderBuilder feelFallBackClass(Class<Fallback> fallbackClass){
        this.fallbackClass = fallbackClass;
        return this;
    }

    public FileReaderBuilder feelFileType(String fileType){
        this.fileType = fileType;
        return this;
    }

    public static FileReaderBuilder start(){
        return new FileReaderBuilder();
    }

    public AbstractFileReader build(){
        FileReaderFactory readerFactory = FileReaderFactory.newFileReaderFactory(fileName, fallbackClass);
        return readerFactory.fileReader(fileType);
    }
}
