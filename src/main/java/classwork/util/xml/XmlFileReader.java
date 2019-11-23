package classwork.util.xml;

import classwork.params.entity.template.Fallback;
import classwork.util.AbstractFileReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlFileReader extends AbstractFileReader {

	private Class<Fallback> fallbackClass;

	public XmlFileReader(Object mapper, String fileName, Class<Fallback> fallbackClass) {
		super(mapper, fileName);
		this.fallbackClass = fallbackClass;
	}
	
	@Override
	public Object readFile() {
		XmlMapper o = (XmlMapper)mapper;
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
