import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import Bill.Bill;

public class JsonFileHandler {

    public static List<Bill> readBillsFromFile(String path) {
        List<Bill> bills = new ArrayList<Bill>();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);

            JSONArray billsArray = new JSONArray();
            billsArray.add(obj);

            billsArray.forEach( b -> bills.add(parseBillJsonObject((JSONObject) b)) );

        } catch (Exception e){
            e.printStackTrace();
        }
        return bills;
    }

    public static void writeBillsToFile(){}

    private static Bill parseBillJsonObject(JSONObject billJsonObj) {
        String path = (String) billJsonObj.get("path");
        String supplier = (String) billJsonObj.get("supplier");
        String date = (String) billJsonObj.get("date");
        Float price = (Float) billJsonObj.get("price");
        String description = (String) billJsonObj.get("description");
        String endOfGuarantee = (String) billJsonObj.get("endOfGuarantee");

        return new Bill(path, supplier, date, price, description, endOfGuarantee);
    }
}
