package MCompleteSeleniumFramework.Tests.data;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MDataReader {
	
	
	public List<HashMap<String, Object>> getJsonDataMap() throws IOException {
		
		String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\CompleteSeleniumFramework\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, Object>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, Object>>>() {

				});//result={map,map1}
		
		return data;

		
	}

}
