package builder.app;

import builder.method.FileReaderBuilder;
import classwork.params.da.JsonParameterReader;
import classwork.params.da.JsonParameterSerializeWriter;
import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;

/**
 * @author Evgeni Korolev
 * @date 03.04.2018
 */
public class FileReadSerializeWrite {


    public static final String TEMP_V_1_OUT = "temp.v1.out";

    /**
     * Из файла parameters.json считываем данные
     * После сериазилуем в файл temp.out
     * Далее перегоняем потоком в result_parameters.json
     * <p>
     * Смысл задания - сериализовать объект в файл.
     * Из файла считать - записать в новый файл и сравнить с исходным
     * <p>
     * fileReader->serializeWriter
     * parameters.v1.json -> temp.v1.out
     */

    //todo нужно реализовать паттерн строитель для считывания из файлов разного формата
    public static void main(String... args) throws Exception {

        String fileName = "parameters.v1.xml";

//	    JsonParameterReader service = new JsonParameterReader();
//        Fallback business = null;
//	    System.out.println("Значение business: " + business);
//	    System.out.println("Считываем данные из файла " + fileName);
//        business = service.read(fileName);
//	    System.out.println("Данные считаны:");
//	    System.out.println(business);
        Fallback business = null;
        System.out.println("Значение business: " + business);
        AbstractFileReader reader = FileReaderBuilder.start().
                feelFileName(fileName).
                feelFileType("xml").
                feelFallBackClass(Fallback.class).
                build();
        business = (Fallback) reader.readFile();
        System.out.println("Данные считаны:");
        System.out.println(business);

        JsonParameterSerializeWriter mySerializer = new JsonParameterSerializeWriter();
        System.out.println("Записываем данные в файла " + TEMP_V_1_OUT);
        mySerializer.customSerializeWriter(business, TEMP_V_1_OUT);
        System.out.println("Данные записаны на диск в файл " + TEMP_V_1_OUT);

    }
}
