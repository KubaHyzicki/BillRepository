import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Bill.Bill;

public class BillDatabase {
    private String dbPath;
    private Connection conn;

    public BillDatabase(String databaseName) {
        this.dbPath = "jdbc:sqlite:" + System.getProperty("user.dir") + "/db/" + databaseName;
        if( ! connect()){
          createNewDatabase();
        }
    }

    private void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(this.dbPath)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean connect() {
        this.conn = null;
        try {
            conn = DriverManager.getConnection(this.dbPath);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }

    public Boolean addToBase(String aPath, String aSupplier,
    			String aDate, Float aPrice, String aDescription, String aEndOfGuarantee)
    {
        return null;
    };
    
    public Boolean copyFile(String path)
    {
    	return false;
    }

    public List<Bill> showBase()
    {
    	return null;
    };

    public Boolean importBase(String path)
    {
        List<Bill> bills;
        try {
            bills = this.loadJson(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean exportBase()
    {
    	return false;
    }

    public Boolean generateJson()
    {
    	return false;
    }

    private List<Bill> loadJson(String path) throws FileNotFoundException
    {
        List<Bill> bills = JsonFileHandler.readBillsFromFile(path);
        for (int i = 0; i < bills.size(); i++) {
            File tempFile = new File(bills.get(i).path);
            if (!tempFile.exists()) {
                throw new FileNotFoundException(path + " not found!");
            }
        }
        return bills;
    }

    private Boolean zipDatabaseFiles()
    {
    	return false;
    }
}
